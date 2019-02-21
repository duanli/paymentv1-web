package cn.com.payment.admin.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class DefaultView extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/login");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		super.addViewControllers(registry);
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		//设置日期格式  
        ObjectMapper objectMapper = new ObjectMapper();  
        SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        objectMapper.setDateFormat(smt);  
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper); 
		// 设置中文编码格式
		List<MediaType> list = new ArrayList<MediaType>();
		list.add(MediaType.ALL);
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(list);
		converters.add(mappingJackson2HttpMessageConverter);
		super.configureMessageConverters(converters);
	}
}
