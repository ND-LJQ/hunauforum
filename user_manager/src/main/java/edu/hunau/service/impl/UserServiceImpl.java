package edu.hunau.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.hunau.entity.ForumToken;
import edu.hunau.entity.ForumUser;
import edu.hunau.mapper.ForumTokenMapper;
import edu.hunau.mapper.ForumUserMapper;
import edu.hunau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现类
 *
 * @author ND_LJQ
 * @date 2022/12/17
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ForumUserMapper forumUserMapper;

    @Autowired
    private ForumTokenMapper forumTokenMapper;


//    DELETE-START

    @Override
    public boolean userDelete(ForumUser userInfo) throws Exception {
        return false;
    }

//    INSERT-START

    @Override
    public boolean userInsert(ForumUser userInfo) throws Exception {
        if(this.forumUserMapper.insert(userInfo)==1) {
            return true;
        }
        return false;
    }

    @Override
    public int insertLoginToken(Integer userId,String token) throws Exception {
        ForumToken forumToken = new ForumToken();
        forumToken.setToken(token);
        forumToken.setUserId(userId);
        return this.forumTokenMapper.insert(forumToken);
    }

//    SELECT-START

    @Override
    public PageInfo<ForumUser> queryUserByPage(Integer pageNum, Integer pageSize) throws Exception {
        if(pageNum == null){
            pageNum = 1;
        }
        PageHelper.startPage(pageNum,pageSize);
        List<ForumUser> users = forumUserMapper.selectAll();
        PageInfo<ForumUser> pageInfo = new PageInfo<ForumUser>(users);
        return pageInfo;
    }

    @Override
    public ForumUser queryUserById(Integer userId) throws Exception {
        return  this.forumUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public ForumUser queryUserByEmail(String email) throws Exception {
        return this.forumUserMapper.selectByEmail(email);
    }

    @Override
    public ForumUser queryUserByTel(String tel) throws Exception {
        return this.forumUserMapper.selectByTel(tel);
    }


//    UPDATE-START

    @Override
    public int updateUserInfo(ForumUser userInfo) throws Exception {
        return this.forumUserMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public int updateUserToken(Integer userId) throws Exception {
        return 0;
    }
}
