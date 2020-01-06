package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/niu")
public class HelloController {
    /*
     * 这是正确的
     *
     * */
    @RequestMapping("/hello")
    public ModelAndView myMethod() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("key", "hello");
        /*这个一定会被视图解析器捕捉到*/
        modelAndView.setViewName("/WEB-INF/hello.jsp");
        return modelAndView;
    }

    @RequestMapping("/hello1")
    public ModelAndView myMethod1() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("key", "hello1");
        modelAndView.setViewName("/hello");
        return modelAndView;
    }

    @RequestMapping("/hello2")
    public String myMethod2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("key", "hello2");
        /*只能返回ModelAndView Name，不能跳转servlet*/
        return "/WEB-INF/iso.jsp";
    }

    @RequestMapping("/hello5/hello/hello4")
    public String myMethod4() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("key", "hello4");

        return "hello";
    }

    @RequestMapping("/hello5/hello_test4")
    public String myMethod4_test() {

        /* 只要前面不加 / ,就会和 /niu（窄化请求）/hello5/(mapping，去掉/最后面的)拼接 */
        return "forward:hello/hello4";
    }

    @RequestMapping("/hello5/hello_test5")
    public String myMethod5_test() {

        /* 只要前面不加 / ,就会和 /niu（窄化请求）/hello5/(mapping，去掉/最后面的)拼接 */
        /*这个找不到对应的servlet，就开始报错*/
        return "forward:/hello/hello4";
    }

}
