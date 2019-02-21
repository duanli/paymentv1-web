package cn.com.payment.admin.config;
 
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(MybatisConfiguration.class)
public class MyBatisMapperScannerConfiguration {

	
	@Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("cn.com.payment.admin.mapper"); ////每张表对应的XXMapper.java interface类型的Java文件
        
//      //这个可以配置多个属性
//        Properties properties = new Properties();
//        properties.setProperty("username", "root");
//        properties.setProperty("notEmpty", "false");
//        properties.setProperty("IDENTITY", "MYSQL");
//        mapperScannerConfigurer.setProperties(properties);
        
        return mapperScannerConfigurer;
    }
	
	
 
}
