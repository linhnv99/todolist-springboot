package com.linkdev.todolist.conf;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ControllerAdvice// bắt exception
@EnableWebMvc
@ComponentScan(basePackages = "com.linkdev.todolist")
public class MVCConf implements WebMvcConfigurer {

	// register bean that return .jsp from the WEB-INF/view
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/view/");
		bean.setSuffix(".jsp");
		return bean;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/META-INF/css/");
		registry.addResourceHandler("/font/**").addResourceLocations("classpath:/META-INF/font/");
		registry.addResourceHandler("/images/**").addResourceLocations("classpath:/META-INF/images/");
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/META-INF/js/");
		registry.addResourceHandler("/lib/**").addResourceLocations("classpath:/META-INF/lib/");
		registry.addResourceHandler("/files/**").addResourceLocations("file:F:/JavaWeb/todolist/uploads/");
	}

//	@ExceptionHandler(value = Exception.class)
//	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//
//		if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) { // 404
//			// Otherwise setup and send the user to a default error-view.
//			ModelAndView mav = new ModelAndView();
//			mav.addObject("exception", e);
//			mav.addObject("url", req.getRequestURL());
//			mav.setViewName("404");
//			return mav;
//		} else {
//			// Otherwise setup and send the user to a default error-view.
//			ModelAndView mav = new ModelAndView();
//			mav.addObject("exception", e);
//			mav.addObject("url", req.getRequestURL());
//			mav.setViewName("error");
//			return mav;
//		}
//	}
}
