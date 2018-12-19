package com.mio4.controller;

import com.mio4.aspect.LogAspect;
import com.mio4.model.User;
import com.mio4.service.toutiaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private toutiaoService toutiaoService;

    @RequestMapping(value = {"/","/index","/index2"})
    @ResponseBody
    public String index(HttpSession session){
        logger.info("visit index");
        //logger.warn("something is not right");
        return "Hello!" + session.getAttribute("msg") +  toutiaoService.say();
    }


    @RequestMapping(path = "/profile/{groupId}/{userId}")
    @ResponseBody
    public String profile(@PathVariable("groupId") String groupId,
                          @PathVariable("userId") int userId,
                          @RequestParam(value = "type", defaultValue = "1") int type,
                          @RequestParam(value = "key",defaultValue = "mio4") String key){

        return String.format("{%s},{%d},{%d},{%s}",groupId,userId,type,key);
    }

    @RequestMapping(value = "/vm")
    public String news(Model model){
        model.addAttribute("value","value 1");
        List<String> colors = Arrays.asList(new String[]{"RED", "BLUE", "BLACK"});
        Map<String,String> map = new HashMap<String,String>();
        for(int i = 0; i < 10; i++){
            map.put(String.valueOf(i),String.valueOf(i*i));
        }
        model.addAttribute("colors",colors);
        model.addAttribute("map",map);

        User user = new User();
        user.setId(1);
        user.setName("Jack");
        model.addAttribute("user",user);
        return "news";
    }


    @RequestMapping(value = "/request")
    @ResponseBody
    public String request_test(HttpServletRequest request,
                              HttpServletResponse response){
        HttpSession session = request.getSession();
        StringBuilder sb = new StringBuilder();
        Enumeration<String> headerName =  request.getHeaderNames();
        while(headerName.hasMoreElements()){
            String name = headerName.nextElement();
            sb.append(name + ":" + request.getHeader(name) + "<br>");
        }

        for(Cookie cookie : request.getCookies()){
            sb.append("Cookie:" + cookie.getName() + ":" + cookie.getValue() + "<br>");
        }

        sb.append("getMethod:" + request.getMethod() + "<br>");
        sb.append("getPathInfo:" + request.getPathInfo() + "<br>");
        sb.append("getQueryString:" + request.getQueryString() + "<br>");

        return sb.toString();
    }

    @RequestMapping(value = "/response")
    @ResponseBody
    public String response_test(@CookieValue(value = "coderid",defaultValue = "10086") String coderid,
                                @RequestParam(value = "key",defaultValue = "key") String key,
                                @RequestParam(value = "value",defaultValue = "value") String value,
                                HttpServletResponse response){
        coderid = "123456";
        response.addCookie(new Cookie(key,value));
        response.addHeader(key,value);
        return "CoderId from cookie:" + coderid;
    }

    @RequestMapping(value = "/redirect/{code}")
    public String redirect_test(@PathVariable(value = "code") int code,
                                HttpSession session){ //301 | 302实现页面跳转
//        RedirectView red = new RedirectView("/",true);
//        if(code == 301)
//            red.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
//        return red;

        session.setAttribute("msg","this is session");
        return "redirect:/";
    }

    @RequestMapping(value = "/admin")
    @ResponseBody
    public String admin(@RequestParam(value = "key",required = false) String key){
        if("admin".equals(key)){
            return "hello amdin";
        }
        throw new IllegalArgumentException("Key 出现错误");
    }

    @ExceptionHandler
    @ResponseBody
    public String error(Exception e){ //自定义跳转到的错误页面
        return "error:" + e.getMessage();
    }


}














