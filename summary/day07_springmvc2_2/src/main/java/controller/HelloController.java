package controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/niu")
public class HelloController  {

    @RequestMapping("/hello")
    public ModelAndView helloMy() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("key","hello");
        modelAndView.setViewName("/WEB-INF/hello.jsp");
        return modelAndView;
    }

    @RequestMapping({"/hello3","/hello1","/hello2"})
    public ModelAndView helloMy2() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("key","hello123");
        modelAndView.setViewName("/WEB-INF/hello.jsp");
        return modelAndView;
    }

    @GetMapping("/lala/hello4")
    public ModelAndView helloMy3() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("key","hello4");
        modelAndView.setViewName("/WEB-INF/hello.jsp");
        return modelAndView;
    }

    @RequestMapping("/hello5")
    public String helloMy4() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("key", "hello5");
        modelAndView.setViewName("/WEB-INF/hello.jsp");
        return "forward:/lala/hello4";
    }

    @RequestMapping("/hello6")
    public String helloMy5() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("key", "hello6");
        modelAndView.setViewName("/WEB-INF/hello.jsp");
        return "redirect:/lala/hello4";
    }

    @PostMapping("/hello7")
    public String helloMy6() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("key", "hello6");
        modelAndView.setViewName("/WEB-INF/hello.jsp");
        return "redirect:/lala/hello4";
    }
}
