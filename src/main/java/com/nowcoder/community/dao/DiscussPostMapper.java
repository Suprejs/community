package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    //为了实现分页查询，返回的应该是帖子的集合，集合中是各个帖子对象

    //统计总的帖子数,@Param注解为参数其别名
    //如果只有一个参数且使用if动态sql，必须起别名
    int selectDiscussPostRows(@Param("userId") int userId);

    //分页数据在数据库的起始行号与数据数
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);




}
