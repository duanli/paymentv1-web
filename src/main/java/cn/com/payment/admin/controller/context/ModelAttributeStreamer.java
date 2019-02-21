package cn.com.payment.admin.controller.context;
import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.NotReadablePropertyException;
import org.springframework.web.servlet.view.AbstractView;

/**
 * An implementation of AbstractView that loads binary content from any bean property or variable available in the model and streams it back
 * using optional parameters on the url to control the content type encoding and file name.
 * 
 * The additional URL attributes can either be hard names like image/jpeg or they can be paths to other model attributes that may contain the appropriate content type.
 *
 * @author JKennedy
 */
public class ModelAttributeStreamer extends AbstractView {
		public static final String BINARY = "binary";
		public static final String ACTION = "action";
	
		/**
		 * Default Buffer size for writing binary stream = 4096
		 */
		private static final int OUTPUT_BYTE_ARRAY_INITIAL_SIZE = 4096;
		
		/**
		 * Constant: __contenttype
		 */
		public final static String CONTENT_TYPE = "__contenttype";
		
		/**
		 * Constant: __contenttype
		 */
		public final static String FILE_NAME = "__filename";
		
		/**
		 * Constant: __varpath
		 */
		public final static String VAR_PATH = "__varpath";
		
		
		/**
		 * Variable Context used for getting variables from the model using paths
		 */
		private transient VariableContext variableContext;
		
	
		/**
		 * Writes the Binary content to the output stream for the response.  The header variables like content type and file name are "plucked" from the model 
		 * using the paths that are passed on the binary request. 
		 * 
		 */
		@Override
		@SuppressWarnings("rawtypes")
		protected void renderMergedOutputModel(Map model, HttpServletRequest request, HttpServletResponse response) throws Exception {
			ByteArrayOutputStream baos = new ByteArrayOutputStream(OUTPUT_BYTE_ARRAY_INITIAL_SIZE);
			byte[] binaryContent = null;
			ServletOutputStream out = null;
			String contentType;
			String fileName;
			
			createVariableContext(request, model);
			
			try {
				binaryContent = loadBinaryContent(model, request);
				 
				if (binaryContent == null)
					return;
				
				baos.write(binaryContent);
				
				if ((contentType = deriveContentType(request)) != null)
					response.setContentType(contentType);
				
				
				if ((fileName = deriveFileName (request)) != null)
					response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

				
				response.setContentLength(baos.size());

				// Flush byte array to servlet output stream.
				out = response.getOutputStream();
				baos.writeTo(out);
				out.flush();
			}
			finally {
				if (baos != null)
					baos.close();
				if (out != null)
					out.close();
			}
		}
		
		
		/**
		 * Creates a Variable Context that will allow access to variables based on paths that are based on the names of the model objects in the Model map
		 * There is an assumption that the Variable context will not need to be created for more than one top level object
		 * This class does not deal with models where there are potentially multiple top level objects and assumes that the conversation model
		 * is being used which wraps the model data into one object which all other paths are derived from.
		 * @param model
		 * @param request
		 * @return
		 */
		@SuppressWarnings("rawtypes")
		protected void createVariableContext (HttpServletRequest request, Map model) {
			String varPath = (String)request.getParameter(VAR_PATH);
			variableContext = new VariableContext (getRootObject(varPath, model));
		}
		
		/**
		 * 
		 * @return
		 */
		protected VariableContext getVariableContext() {
			return variableContext;
		}
		
		/**
		 * 
		 * @param variablePath
		 * @return
		 */
		@SuppressWarnings("rawtypes")
		protected Object getRootObject (String variablePath, Map map) {
			if (variablePath == null)
				return null;
			
			if (variablePath.indexOf (".") <= 0)
				return map.get(variablePath);
			
			return map.get(variablePath.substring(0, variablePath.indexOf(".")));
		}
		
		/**
		 * 
		 * @param variablePath
		 * @return
		 */
		protected Object getVariable (String path) {
			if (path.indexOf(".") > 0)
				path = path.substring(path.indexOf(".") + 1);
			
			return getVariableContext().get(path);
		}
		
		
		/**
		 *  Returns the binary content represented by the variable on the url parameter of VAR_PATH
		 *  @see VAR_PATH
		 */
		@SuppressWarnings("rawtypes")
		protected byte[] loadBinaryContent(Map model, HttpServletRequest request) {
			String varPath = (String)request.getParameter(VAR_PATH);
			
			return (byte[])getVariable(varPath);
		}
		
		/**
		 * 
		 */
		public String deriveContentType (HttpServletRequest request) {
			String contentType = (String)request.getParameter(CONTENT_TYPE);
			String contentTypeFromVariable = null;
		
			// avoid returning an empty string for content type
			if (contentType == null || contentType.length() <= 0)
				return null;
				
			try {
				contentTypeFromVariable = (String)getVariable(contentType);
			}
			catch (NotReadablePropertyException nrpe){} 
			
			return (contentTypeFromVariable == null) ? contentType : contentTypeFromVariable;
		}
		
		/**
		 * 
		 * @return
		 */
		public String deriveFileName (HttpServletRequest request) {
			String fileName = (String)request.getParameter(FILE_NAME);
			String fileNameFromVariable = null;
		
			// avoid returning an empty string for content type
			if (fileName == null || fileName.length() <= 0)
				return null;
			
			try {
				fileNameFromVariable = (String)getVariable(fileName);
			}
			catch (NotReadablePropertyException nrpe){} 
			
			return (fileNameFromVariable == null) ? fileName : fileNameFromVariable;
		}
		
		/**
		 * Static Utility Method to return a URL which will will resolve to this view with the appropriate parameters
		 * to dynamically load the binary content from the variable path and stream it
		 * 
		 * @param varPath
		 * @param contentType
		 * @param fileName
		 * @return
		 */
		public String getBinaryContentURL(String contextRoot, String varPath, String contentType, String fileName, String controllerName) {
			StringBuilder url = new StringBuilder();
			url.append(contextRoot);
			url.append("/");
			url.append(controllerName);
			url.append("/");
			url.append(BINARY);
			url.append(".");
			url.append(ACTION);
			url.append("?");
			boolean addAmpersand = false;
			
			addAmpersand = appendNonNullURLParameter (url, ModelAttributeStreamer.VAR_PATH, varPath, addAmpersand);
			
			addAmpersand = appendNonNullURLParameter (url, ModelAttributeStreamer.CONTENT_TYPE, contentType, addAmpersand);
				
			appendNonNullURLParameter (url, ModelAttributeStreamer.FILE_NAME, fileName, addAmpersand);
			
			return url.toString();
		}
		
		
		/**
		 * 
		 * @param builder
		 * @param name
		 * @param value
		 */
		private static boolean appendNonNullURLParameter (StringBuilder builder, String name, String value, boolean addAmpersand) {
			if (builder == null || name == null || value == null || value.length() <= 0)
				return false;

			if (addAmpersand)
				builder.append("&");
			
			builder.append(name);
			builder.append("=");
			builder.append(value);
			
			return true;
		}
}