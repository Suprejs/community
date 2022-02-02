package com.nowcoder.community.dao;
import org.springframework.stereotype.Repository;
//AlphaDao的实现类1
@Repository("AlphaDapHib")
public class AlphaDapHib implements AlphaDao{
    @Override
    public String select() {
        System.out.println("AlphaDapHibhh");
        return "AlphaDapHib";
    }
}
