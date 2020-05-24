package dtu.cdio.configs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//class config


@Configuration
@ComponentScan("dtu.cdio.*")

@EnableTransactionManagement

//Load to Environment.
@PropertySources({ @PropertySource("classpath:jdbc.properties") })
public class WebMvcConfig {
	 @Autowired
	private Environment env;
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	 @Bean(name = "dataSource")
	   public DataSource getDataSource() {
	       DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 
	       // See: datasouce-cfg.properties
	       dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
	       dataSource.setUrl(env.getProperty("ds.url"));
	       dataSource.setUsername(env.getProperty("ds.username"));
	       dataSource.setPassword(env.getProperty("ds.password"));
	 
	       System.out.println("## getDataSource: " + dataSource);
	 
	       return dataSource;
	   }
	 
	   @Bean(name = "transactionManager")
	   public DataSourceTransactionManager getTransactionManager() {
	       DataSourceTransactionManager txManager = new DataSourceTransactionManager();
	 
	       DataSource dataSource = this.getDataSource();
	       txManager.setDataSource(dataSource);
	 
	       return txManager;
	   }
	   
	 
	    @Bean
	    public JdbcTemplate jdbcTemplate() {
	        JdbcTemplate jdbcTemplate = new JdbcTemplate();
	        jdbcTemplate.setDataSource(getDataSource());
	        return jdbcTemplate;
	    }
	 
	/*
	 * @Bean public EmployeeDAO employeeDAO(){ EmployeeDAOImpl empDao = new
	 * EmployeeDAOImpl(); empDao.setJdbcTemplate(jdbcTemplate()); return empDao; }
	 */
}
