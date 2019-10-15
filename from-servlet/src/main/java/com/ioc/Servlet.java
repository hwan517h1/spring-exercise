package com.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext applicationContext = (ApplicationContext) getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE); // IoC Container   사 용함
        IoCContainerService ioCContainerService = applicationContext.getBean(IoCContainerService.class); // 등록된 Bean 사용함

        System.out.println("doGet");

        resp.getWriter().print("<html>");
        resp.getWriter().print("<head>");
        resp.getWriter().print("<body>");
        resp.getWriter().print("<h1>Hello, Spring!</h1>");
        resp.getWriter().print("<h1>" + ioCContainerService.getContent() + "</h1>");
        resp.getWriter().print("</body>");
        resp.getWriter().print("</head>");
        resp.getWriter().print("</html>");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
