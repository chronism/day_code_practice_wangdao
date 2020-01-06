package control;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DispatcherController implements Controller {


    @Override
    public ModelAndView handleRequest(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myName", "yuanchuan");
        modelAndView.setViewName("/WEB-INF/hello.jsp");
        return modelAndView;
    }
}
