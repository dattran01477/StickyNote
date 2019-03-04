package com.stickynote.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.stickynote.validator.NoteUserValidator;

@Configuration
@EnableWebMvc
@ComponentScan("com.stickynote.*")
@PropertySource(value= {"classpath:db.properties"})
@EnableTransactionManagement
public class Config extends WebMvcConfigurerAdapter {
	
	@Autowired
	Environment enviroment;
	
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/resources/");
	}
	//configuration propersource
	@Bean
	public static PropertySourcesPlaceholderConfigurer PlaceholderConfigurer()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
	@Bean(name="messageSource")
	public MessageSource messageSource()
	{
		ReloadableResourceBundleMessageSource bundleMessageSource=new ReloadableResourceBundleMessageSource();
		bundleMessageSource.addBasenames("classpath:messages");
		bundleMessageSource.setDefaultEncoding("utf-8");
		return bundleMessageSource;
	}
	@Bean(name="dataSource")
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(enviroment.getProperty("driver"));
		dataSource.setUrl(enviroment.getProperty("url"));
		dataSource.setUsername("root");
		dataSource.setPassword("12345");
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean()
	{
		LocalSessionFactoryBean sessionFactoryBean=new LocalSessionFactoryBean();
	sessionFactoryBean.setDataSource(dataSource());
	sessionFactoryBean.setPackagesToScan(new String[] {"com.stickynote.entity"});
	
	Properties properties=new Properties();
	properties.put("hibernate.dialect", enviroment.getProperty("hibernate.dialect"));
	properties.put("hibernate.show_sql",enviroment.getProperty("hibernate.show_sql"));
	
	sessionFactoryBean.setHibernateProperties(properties);
	return sessionFactoryBean;
	}
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory  sessionFactory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		
		return transactionManager;
		
	}
	@Bean
	ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
	@Bean
	NoteUserValidator noteUserValidator()
	{
		return new NoteUserValidator();
	}
}
