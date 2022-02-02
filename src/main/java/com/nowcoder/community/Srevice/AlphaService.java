package com.nowcoder.community.Srevice;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class AlphaService {

    public AlphaService() {
        System.out.println("Cons");
    }
    @PostConstruct//该注解表示该初始化方法将在构造器后自动调用
    public void init(){
        System.out.println("AutoCons");
    }

    @PreDestroy//该注解表示该方法在对象销毁前会代用
    public void destory(){
        System.out.println("Destory");
    }
}
