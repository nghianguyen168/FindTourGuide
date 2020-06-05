package dtu.cdio.configs;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

//Impelements lại WebApplicationInitializer => Tương ứng với file web.xml
public class SpringMVCApplication implements WebApplicationInitializer  {

	public void onStartup(ServletContext servletCxt) throws ServletException {
		   // Load Spring web application configuration
		//Cho phép sử dụng các Anotation
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(WebMvcConfig.class); 
        ac.setServletContext(servletCxt);
        ac.refresh();

        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
        
       
        
		
	}
	
}
