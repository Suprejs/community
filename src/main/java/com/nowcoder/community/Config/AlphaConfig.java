package com.nowcoder.community.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.SimpleTimeZone;

@Configuration//表示这是一个配置类
public class AlphaConfig {

    @Bean//装配了一个已存在的第三方组件SimpleDateFormat对象
    public SimpleDateFormat sdf(){//方法名就是Bean名
        return new SimpleDateFormat();
    }
}
