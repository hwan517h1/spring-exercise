//package com.mvc;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
//public class InsteadWebXml implements WebApplicationInitializer {
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
//        applicationContext.register(WebConfiguration.class);
//        applicationContext.refresh();
//
//        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext); // ApplicationContext 주입한 DispatcherServlet 생성하기
//        ServletRegistration.Dynamic main = servletContext.addServlet("ds", dispatcherServlet); // servletName이 필요함
//        main.addMapping("/ds/*");
//    }
//}



