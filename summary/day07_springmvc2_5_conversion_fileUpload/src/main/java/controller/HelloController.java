package controller;


import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;


@Controller
@RequestMapping("/formdata")
public class HelloController {

   @RequestMapping("/register")
    public String register(User user, MultipartFile myfile) throws IOException {
       String s = UUID.randomUUID().toString().replace("-","");
       String pathFile = "E:\\code\\java\\spring_mvc\\homework_main\\src\\main\\resources\\test"+s+".txt";
       File file = new File(pathFile);
       myfile.transferTo(file);
       System.out.println(user);
       return "/WEB-INF/view/ok.jsp";
   }
}
