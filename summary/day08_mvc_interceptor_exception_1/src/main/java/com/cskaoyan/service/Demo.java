package com.cskaoyan.service;

import com.cskaoyan.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Demo {

  @RequestMapping("/hello")
    public String method(HttpServletRequest request) throws MyException {
      String id = request.getParameter("id");
      if(Integer.parseInt(id)==3){
          return "/WEB-INF/ok.jsp";
      }else {
          throw new MyException("你输入的不是3，所以报了异常");
      }
  }
}
