package controller;


import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;


@Controller
@RequestMapping("/formdata")
public class HelloController {

    @Autowired
    Converter converter;

    @RequestMapping("/all")
    public String myMethod(HttpServletRequest request){
        String[] hobby = request.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobby));
        String username = request.getParameter("username");
        System.out.println(username);
        String password = request.getParameter("password");
        System.out.println(password);
        String birthday = request.getParameter("birthday");
        System.out.println(converter.convert(birthday));
        return "/WEB-INF/view/hello.jsp";
    }

    @RequestMapping("/hobby")
    public String myMethod1(String[] hobby){
        System.out.println(Arrays.toString(hobby));
        return "/WEB-INF/view/hello.jsp";
    }

    @RequestMapping("/user")
    public String myMethod2(User user){
        System.out.println(user);
        return "/WEB-INF/view/hello.jsp";
    }

    @RequestMapping("/date")
    public String myMethod3(Date birthday){
        System.out.println(birthday);
        return "/WEB-INF/view/hello.jsp";
    }
}
