package com.nowcoder.community.Srevice;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DiscussPostService {
    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPosts(int UserId, int offset, int limit){
        return discussPostMapper.selectDiscussPosts(UserId, offset, limit);
    }

    public int findDiscussPostRows(int UserId){
        return discussPostMapper.selectDiscussPostRows(UserId);
    }
}
