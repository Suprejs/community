package com.nowcoder.community.controller;

import com.nowcoder.community.Srevice.DiscussPostService;
import com.nowcoder.community.Srevice.UserService;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller//Controller的访问路径可以省略
public class HomeController {
    @Autowired
    DiscussPostService discussPostService;
    @Autowired
    UserService userService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)//服务器向浏览器相应html
    public String getIndexPage(Model model, Page page){
        //方法调用前，方法会自动的实例化Model和Page并把Page装入Model，故不用通过addAttribute装入
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");
        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());//Controller调用的是Service层而非dao层
        List<Map<String, Object>>  discussposts = new ArrayList<>();
        if(list != null){
            for(DiscussPost post : list){
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                map.put("user", userService.findUserById(post.getUserId()));
                discussposts.add(map);
            }
        }
        model.addAttribute("discussposts", discussposts);
        return "/index";
    }
}
