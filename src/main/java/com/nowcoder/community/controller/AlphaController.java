package com.nowcoder.community.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {
//    @RequestMapping("/hello")
//    @ResponseBody
//    public String sayHello(){
//        return "hello spring boot";
//    }
    @RequestMapping("/http")//浏览器请求，服务器响应的一些底层代码
    public void http(HttpServletRequest request, HttpServletResponse response){
        //获取请求
        System.out.println(request.getMethod());//请求方式
        System.out.println(request.getServletPath());//请求路径
        Enumeration<String> enumeration = request.getHeaderNames();//获取包含很多内容的请求行的key，得到的是一个迭代器
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);//通过键key获取值value
            System.out.println(name + ":" + value);
        }
        System.out.println(request.getParameter("code"));//获取请求参数，参数名叫code

        //返回相应数据
        response.setContentType("text/html;charset = utf-8");//设置服务器给浏览器返回数据的类型,返回网页文本
        //通过response封装的流向浏览器输出相应内容
        try (PrintWriter pw = response.getWriter();){
            pw.write("<hi>牛客网</hi>");//返回一个一级标题
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/students", method = RequestMethod.GET)//指定路径，允许的访问方法
    @ResponseBody//对相应的封装，该注解修饰方法的返回值即为对浏览器的响应
    public String students(@RequestParam(name = "current", required = false, defaultValue = "1") int current,
                           @RequestParam(name = "limit", required = false, defaultValue = "10") int limit){
                            //该注解用于描述浏览器参数current和limit
                            //浏览器发出请求后，将该方法将自动接收两参数
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }

    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)//指定路径,参数id包含在路径中，允许的访问方法
    @ResponseBody//对相应的封装，该注解修饰方法的返回值即为对浏览器的响应
    public String student(@PathVariable("id") int id) {
        System.out.println(id);
        return "student";
    }

    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String savaStudent(String name, int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }
    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    //@ResponseBody 向浏览器返回html数据，不需要添加该注解
    public ModelAndView getTeacher(){//向浏览器返回的是Model和View两份数据
        ModelAndView mav = new ModelAndView();//实例化数据
        mav.addObject("name", "张三");//向mav中传递动态值
        mav.addObject("age", "23");//向mav中传递动态值
        mav.setViewName("/demo/view");//设置模板的路径和名字,template级路径不用写，需要写下级的demo路径，view为模板名字，不用写html后缀
        return mav;
    }

    @RequestMapping(path = "/school",method = RequestMethod.GET)
    //@ResponseBody 向浏览器返回html数据，不需要添加该注解
    public String getSchool(Model model){//向浏览器返回的是Model和View两份数据
        model.addAttribute("name", "电子科技大学");//向mav中传递动态值
        model.addAttribute("age", "65");//向mav中传递动态值
        return "/demo/view";
    }

    //响应异步请求
    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody//不加该注解默认返回为html，加了则可以返回其他类型
    public Map<String,Object> getEmp(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age",23);
        map.put("salary",1000000);
        return map;
    }

    //查询所有员工
    @RequestMapping(path = "/emps", method = RequestMethod.GET)
    @ResponseBody//不加该注解默认返回为html，加了则可以返回其他类型
    public List<Map<String,Object>> getEmps(){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age",23);
        map.put("salary",1000000);
        list.add(map);
        map = new HashMap<>();
        map.put("name","李四");
        map.put("age",24);
        map.put("salary",2000000);
        list.add(map);
        return list;
    }
}
