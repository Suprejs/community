package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

//@MapperScan({"com.nowcoder.community.dao"})
//@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)//在测试代码中使用main的配置类
public class MapperTests {
    @Autowired
    public UserMapper usermapper;//自动注入

    @Autowired
    public DiscussPostMapper discussPostMapper;

    @Test
    public void selectTest(){
        User user = usermapper.selectById(111);
        System.out.println(user);

        user = usermapper.selectByName("liubei");
        System.out.println(user);

        user = usermapper.selectByEmail("nowcoder111@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setActivationCode("jdbc");
        user.setCreateTime(new Date());
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setEmail("1048496726@qq.com");
        user.setUsername("suprejs");
        user.setId(1);
        user.setPassword("123456");
        user.setSalt("abc");
        user.setStatus(1);
        usermapper.insertUser(user);
        User user1 = usermapper.selectByName("suprejs");
        System.out.println(user1);
    }

    @Test
    public void testUpdate(){
        int rows = usermapper.updateHeader(150, "http://www.nowcoder.com/101.png");
        System.out.println(rows);//返回值为修改的行数
        rows = usermapper.updatePassword(150, "123456");
        System.out.println(rows);
        rows = usermapper.updateStatus(150, 1);
        System.out.println(rows);

    }

    @Test
    public void testSelectPosts(){

        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);

        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for(DiscussPost pd : list){
            System.out.println(pd);
        }
    }


}
