package com.mio4.controller;

import com.mio4.model.News;
import com.mio4.model.ViewObject;
import com.mio4.service.NewsService;
import com.mio4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    private List<ViewObject> getNews(int userId, int offset, int limit){
        List<News> newsList = newsService.getLatestNews(userId,offset,limit);
        List<ViewObject> vos = new ArrayList<>();
        for(News news : newsList){
            ViewObject vo = new ViewObject();
            vo.set("news",news);
            vo.set("user",userService.getUser(news.getUserId()));
            vos.add(vo);
        }
        return vos;
    }

    @RequestMapping(value = "/index", method = {RequestMethod.GET, RequestMethod.POST})
    public String Index(Model model){
        model.addAttribute("vos",getNews(0,0,10));
        return "home";
    }

    @RequestMapping(value = "/user/{userId}/", method = {RequestMethod.GET, RequestMethod.POST})
    public String userIndex(Model model,
                            @PathVariable("userId") int userId){ //不同的用户对应不同的页面
        model.addAttribute("vos",getNews(0,0,10));
        return "home";
    }



}
