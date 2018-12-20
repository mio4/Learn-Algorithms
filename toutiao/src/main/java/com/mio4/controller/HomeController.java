package com.mio4.controller;

import com.mio4.model.News;
import com.mio4.model.ViewObject;
import com.mio4.service.NewsService;
import com.mio4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private NewsService newsService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index", method = {RequestMethod.GET, RequestMethod.POST})
    public String Index(Model model){
        List<News> newsList = newsService.getLatestNews(0,0,10);
        List<ViewObject> vos = new ArrayList<>();
        for(News news : newsList){
            ViewObject vo = new ViewObject();
            vo.set("news",news);
            vo.set("user",userService.getUser(news.getUserId()));
            vos.add(vo);
        }
        model.addAttribute("vos",vos);
        return "home";
    }


    private List<ViewObject>





}
