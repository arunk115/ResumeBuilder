package com.mia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {

	public static void main(final String[] args) {
	//	java.security.Security.setProperty("networkaddress.cache.ttl" , "0");
		SpringApplication.run(Application.class, args); 
	}

//	@Override
//	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
//		final Map<String, Object> props = new HashMap<>();
//        props.put("spring.config.name", "nlp");
//        application.properties(props);
//		return application.sources(Application.class);
//	}
//
//	private ApplicationContext getExistingRootWebApplicationContext(
//			final ServletContext servletContext) {
//		final Object context = servletContext.getAttribute(
//				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//		if (context instanceof ApplicationContext) {
//			return (ApplicationContext) context;
//		}
//		return null;
//	}
//
//	@Override
//	public void onStartup(final ServletContext servletContext) throws ServletException {
//		super.onStartup(servletContext);
//		this.applicationContext = getExistingRootWebApplicationContext(servletContext);
//		if(env==null){
//			env = applicationContext.getBean(Environment.class);
//		}
//	}
}
