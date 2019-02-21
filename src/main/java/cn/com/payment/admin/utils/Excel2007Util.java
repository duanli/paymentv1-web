package cn.com.payment.admin.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 处理excel读入的工具类 Created by Liujishuai on 2015/8/5.
 */
public class Excel2007Util {

	/**
	 * 要求excel版本在2007以上
	 * 
	 * @param file
	 *            文件信息
	 * @param startSheet
	 *            起始sheet编号
	 * @param endSheet
	 *            起始sheet编号
	 * @param startRow
	 *            起始行号
	 * @param endRow
	 *            终止行号
	 * @param startCell
	 *            起始列
	 * @param endCell
	 *            终止列
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public static List<List<List<Object>>> readExcel(File file, Integer startSheet, Integer endSheet, Integer startRow,
			Integer endRow, Integer startCell, Integer endCell) throws Exception {
		if (!file.exists()) {
			throw new Exception("找不到文件");
		}
		List<List<List<Object>>> list = new LinkedList<List<List<Object>>>();
		XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(file));
		// 设置row
		if (null == startSheet)
			startSheet = 0;
		if (null == endSheet)
			endSheet = xwb.getNumberOfSheets();
		XSSFSheet sheet = null;
		for (int i = startSheet; i <= endSheet; i++) {
			sheet = xwb.getSheetAt(i);
			if (sheet == null) {
				continue;
			}
			List<List<Object>> listSheet = readSheet(sheet, null, null, null, null);
			if (listSheet.size() != 0) {
				list.add(listSheet);
			}
		}
		return list;
	}

	/**
	 * 要求excel版本在2007以上
	 * 
	 * @param file
	 *            文件信息
	 * @return 默认取第一个sheet，第一行第一列开始取值
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public static List<List<List<Object>>> readExcel(File file) throws Exception {
		if (!file.exists()) {
			throw new Exception("找不到文件");
		}
		List<List<List<Object>>> list = new LinkedList<List<List<Object>>>();
		XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(file));
		XSSFSheet sheet = null;
		for (int i = 0; i < 1; i++) {
			sheet = xwb.getSheetAt(i);
			if (sheet == null) {
				continue;
			}
			List<List<Object>> listSheet = readSheet(sheet, 1, null, null, null);
			if (listSheet.size() != 0) {
				list.add(listSheet);
			}
		}
		return list;
	}

	/**
	 * 要求excel版本在2007以上
	 * 
	 * @param file
	 *            文件信息
	 * @return
	 * @throws Exception
	 */
	public static List<List<Object>> readSheet(XSSFSheet sheet, Integer startRow, Integer endRow, Integer startCell,
			Integer endCell) throws Exception {
		List<List<Object>> list = new LinkedList<List<Object>>();
		// 设置row
		if (null == startRow)
			startRow = (int) sheet.getFirstRowNum();
		if (null == endRow)
			endRow = (int) sheet.getPhysicalNumberOfRows();
		XSSFRow row = null;
		for (int i = startRow; i <= (endRow - 1); i++) {
			row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			// 读取行
			List<Object> linked = readRows(row, startCell, endCell);
			if (linked.size() != 0) {
				list.add(linked);
			}
		}
		return list;
	}

	/**
	 * 要求excel版本在2007以上
	 * 
	 * @param file
	 *            文件信息
	 * @return
	 * @throws Exception
	 */
	public static List<Object> readRows(XSSFRow row, Integer startCell, Integer endCell) throws Exception {
		List<Object> linked = new LinkedList<Object>();
		// 设置起始列和终止列
		if (null == startCell)
			startCell = (int) row.getFirstCellNum();
		if (null == endCell)
			endCell = (int) row.getLastCellNum();
		XSSFCell cell = null;
		for (int j = startCell; j <= endCell; j++) {
			Object value = null;
			cell = row.getCell(j);
			if (cell == null) {
				continue;
			}
			switch (cell.getCellType()) {
			case XSSFCell.CELL_TYPE_STRING:
				// String类型返回String数据
				value = cell.getStringCellValue();
				break;
			case XSSFCell.CELL_TYPE_NUMERIC:
				// 日期数据返回LONG类型的时间戳
				if ("yyyy\"年\"m\"月\"d\"日\";@".equals(cell.getCellStyle().getDataFormatString())) {
					// System.out.println(cell.getNumericCellValue()+":日期格式："+cell.getCellStyle().getDataFormatString());
					value = DateUtils.getFragmentInMilliseconds(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()),
							Calendar.YEAR) / 1000;
				} else {
					// 数值类型返回double类型的数字
					// System.out.println(cell.getNumericCellValue()+":格式："+cell.getCellStyle().getDataFormatString());
					value = cell.getRawValue();
				}
				break;
			case XSSFCell.CELL_TYPE_BOOLEAN:
				// 布尔类型
				value = cell.getBooleanCellValue();
				break;
			case XSSFCell.CELL_TYPE_BLANK:
				// 空单元格
				break;
			default:
				value = cell.toString();
			}
			// if (value != null && !value.equals("")) {
			// // 单元格不为空，则加入列表
			// linked.add(value);
			// }
			linked.add(value);
		}
		return linked;
	}

	/**
	 * 要求excel版本在2007以上
	 * 
	 * @param fileInputStream
	 *            文件信息
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public static List<List<Object>> readExcel(FileInputStream fileInputStream) throws Exception {
		List<List<Object>> list = new LinkedList<List<Object>>();
		XSSFWorkbook xwb = new XSSFWorkbook(fileInputStream);
		// 读取第一张表格内容
		XSSFSheet sheet = xwb.getSheetAt(1);
		XSSFRow row = null;
		XSSFCell cell = null;
		for (int i = (sheet.getFirstRowNum() + 1); i <= (sheet.getPhysicalNumberOfRows() - 1); i++) {
			row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			List<Object> linked = new LinkedList<Object>();
			for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
				Object value = null;
				cell = row.getCell(j);
				if (cell == null) {
					continue;
				}
				switch (cell.getCellType()) {
				case XSSFCell.CELL_TYPE_STRING:
					value = cell.getStringCellValue();
					break;
				case XSSFCell.CELL_TYPE_NUMERIC:
					if ("yyyy\"年\"m\"月\"d\"日\";@".equals(cell.getCellStyle().getDataFormatString())) {
						// System.out.println(cell.getNumericCellValue()+":日期格式："+cell.getCellStyle().getDataFormatString());
						value = DateUtils.getFragmentInMilliseconds(
								HSSFDateUtil.getJavaDate(cell.getNumericCellValue()), Calendar.YEAR) / 1000;
					} else {
						// System.out.println(cell.getNumericCellValue()+":格式："+cell.getCellStyle().getDataFormatString());
						value = cell.getNumericCellValue();
					}
					break;
				case XSSFCell.CELL_TYPE_BOOLEAN:
					value = cell.getBooleanCellValue();
					break;
				case XSSFCell.CELL_TYPE_BLANK:
					break;
				default:
					value = cell.toString();
				}
				// if (value != null && !value.equals("")) {
				// // 单元格不为空，则加入列表
				// linked.add(value);
				// }
				linked.add(value);
			}
			if (linked.size() != 0) {
				list.add(linked);
			}
		}
		return list;
	}

	/**
	 * 导出excel
	 * 
	 * @param excel_name
	 *            导出的excel路径（需要带.xlsx)
	 * @param headList
	 *            excel的标题备注名称
	 * @param fieldList
	 *            excel的标题字段（与数据中map中键值对应）
	 * @param dataList
	 *            excel数据
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public static void createExcel(String excel_name, String[] headList, String[] fieldList,
			List<Map<String, Object>> dataList) throws Exception {
		// 创建新的Excel 工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 在Excel工作簿中建一工作表，其名为缺省值
		XSSFSheet sheet = workbook.createSheet();
		// 在索引0的位置创建行（最顶端的行）
		XSSFRow row = sheet.createRow(0);
		// 设置excel头（第一行）的头名称
		for (int i = 0; i < headList.length; i++) {
			// 在索引0的位置创建单元格（左上端）
			XSSFCell cell = row.createCell(i);
			// 定义单元格为字符串类型
			cell.setCellType(XSSFCell.CELL_TYPE_STRING);
			// 在单元格中输入一些内容
			cell.setCellValue(headList[i]);
		}
		// ===============================================================
		// 添加数据
		for (int n = 0; n < dataList.size(); n++) {
			// 在索引1的位置创建行（最顶端的行）
			XSSFRow row_value = sheet.createRow(n + 1);
			Map<String, Object> dataMap = dataList.get(n);
			// ===============================================================
			for (int i = 0; i < fieldList.length; i++) {
				// 在索引0的位置创建单元格（左上端）
				XSSFCell cell = row_value.createCell(i);
				// 定义单元格为字符串类型
				cell.setCellType(XSSFCell.CELL_TYPE_STRING);
				// 在单元格中输入一些内容
				cell.setCellValue((dataMap.get(fieldList[i])).toString());
			}
			// ===============================================================
		}
		// 新建一输出文件流
		FileOutputStream fos = new FileOutputStream(excel_name);
		// 把相应的Excel 工作簿存盘
		workbook.write(fos);
		fos.flush();
		// 操作结束，关闭文件
		fos.close();
	}

	/**
	 * 导出excel
	 * 
	 * @param title
	 *            导出excel标题
	 * @param headers
	 *            导出到excel显示的列头
	 * @param columns
	 *            对应数据库字段
	 * @param list
	 *            导出数据
	 */
	public static void exportExcel(String title, String[] headers, String[] columns, List<Map<String,Object>> list, OutputStream out,
			String pattern) throws NoSuchMethodException, Exception {
		// 创建工作薄
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 创建表格
		XSSFSheet sheet = workbook.createSheet(title);
		// 设置默认宽度
		sheet.setDefaultColumnWidth(25);
		// 创建样式
		XSSFCellStyle style = workbook.createCellStyle();
		// 设置样式
		style.setFillForegroundColor(IndexedColors.GOLD.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setBorderTop(CellStyle.BORDER_THIN);
		// 生成字体
		XSSFFont font = workbook.createFont();
		font.setColor(IndexedColors.VIOLET.index);
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		// 应用字体
		style.setFont(font);
		// 自动换行
		style.setWrapText(true);
		// 声明一个画图的顶级管理器
		Drawing drawing = sheet.createDrawingPatriarch();
		// 表头的样式
		XSSFCellStyle titleStyle = workbook.createCellStyle();// 样式对象
		titleStyle.setAlignment(CellStyle.ALIGN_CENTER_SELECTION);// 水平居中
		titleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		// 设置字体
		XSSFFont titleFont = workbook.createFont();
		titleFont.setFontHeightInPoints((short) 15);
		titleFont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);// 粗体
		titleStyle.setFont(titleFont);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headers.length - 1));
		// 指定合并区域
		XSSFRow rowHeader = sheet.createRow(0);
		// XSSFRow rowHeader=sheet.createRow(0);
		XSSFCell cellHeader = rowHeader.createCell(0);
		XSSFRichTextString textHeader = new XSSFRichTextString(title);
		cellHeader.setCellStyle(titleStyle);
		cellHeader.setCellValue(textHeader);

		XSSFRow row = sheet.createRow(1);
		for (int i = 0; i < headers.length; i++) {
			XSSFCell cell = row.createCell(i);
			cell.setCellStyle(style);
			XSSFRichTextString text = new XSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		// 遍历集合数据，产生数据行
		if (list != null && list.size() > 0) {
			int index = 2;
			for (Map<String,Object> item : list) {
				row = sheet.createRow(index);
				index++;
				for (short i = 0; i < columns.length; i++) {
					XSSFCell cell = row.createCell(i);
					String filedName = columns[i];
//					String getMethodName = "get" + filedName.substring(0, 1).toUpperCase() + filedName.substring(1);
//					Class tCls = t.getClass();
//					Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
//					Object value = getMethod.invoke(t, new Class[] {});
					Object value = item.get(filedName);
					String textValue = null;
					if (value == null) {
						textValue = "";
					} else if (value instanceof Date) {
						Date date = (Date) value;
						SimpleDateFormat sdf = new SimpleDateFormat(pattern);
						textValue = sdf.format(date);
					} else if (value instanceof byte[]) {
						row.setHeightInPoints(80);
						sheet.setColumnWidth(i, 35 * 100);
						byte[] bsValue = (byte[]) value;
						XSSFClientAnchor anchor = new XSSFClientAnchor(0, 0, 1023, 255, 6, index, 6, index);
						anchor.setAnchorType(2);
						drawing.createPicture(anchor, workbook.addPicture(bsValue, XSSFWorkbook.PICTURE_TYPE_JPEG));
					} else {
						// 其它数据类型都当作字符串简单处理
						textValue = value.toString();
					}

					if (textValue != null) {
						Pattern p = Pattern.compile("^//d+(//.//d+)?$");
						Matcher matcher = p.matcher(textValue);
						if (matcher.matches()) {
							// 是数字当作double处理
							cell.setCellValue(Double.parseDouble(textValue));
						} else {
							XSSFRichTextString richString = new XSSFRichTextString(textValue);
							// HSSFFont font3 = workbook.createFont();
							// font3.setColor(HSSFColor.BLUE.index);
							// richString.applyFont(font3);
							cell.setCellValue(richString);
						}
					}
				}
			}
		}
		workbook.write(out);
	}

	public static void main(String[] args) throws Exception {
		// 测试导入
		// File file = new
		// File("C:\\Users\\Administrator\\Desktop\\userimport.xlsx");
		// BufferedInputStream in = new BufferedInputStream(new
		// FileInputStream(file));
		// POIFSFileSystem fs = new POIFSFileSystem(in);
		// HSSFWorkbook wb = new HSSFWorkbook(fs);
		// int sheetSize = wb.getNumberOfSheets();
		// List<List<List<Object>>> result = readExcel(file);
		// int sheetLength = result.size();
		// for (int i = 0; i < sheetLength; i++) {
		// int rowLength = result.get(i).size();
		// for (int k = 0; k < rowLength; k++) {
		// int cellLength = result.get(i).get(k).size();
		// for (int j = 0; j < cellLength; j++) {
		// System.out.print(result.get(i).get(k).get(j) + "\t");
		// }
		// System.out.print("\t\n");
		// }
		// }
		// 测试导出
		String[] headers = { "卖家", "订单号" };
		String[] columns = { "buyerOpenId", "orderNo" };
		String fileName ="12345678" + ".xls";
		fileName = URLEncoder.encode(fileName, "utf-8");
		Map<String,Object> item = new HashMap<String,Object>();
		item.put("buyerOpenId", "id123123");
		item.put("orderNo", 123456);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(item);
		exportExcel("test", headers, columns, list, null,  "yyyy-MM-dd HH:mm:ss");

	}
}
