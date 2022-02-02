package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

//AlphaDao的实现类2
@Repository("AlphaDapHibR")
@Primary
public class AlphaDapHibR implements AlphaDao{
    @Override
    public String select() {
        System.out.println("AlphaDapHibhh");
        return "AlphaDapHibR";
    }
}
