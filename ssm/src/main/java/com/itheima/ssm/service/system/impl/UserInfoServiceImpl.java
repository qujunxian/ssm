package com.itheima.ssm.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.ssm.dao.system.UserInfoDao;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.system.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public PageInfo<UserInfo> findAll(Integer start, Integer pageSize) {
        PageHelper.startPage(start, pageSize);
        List<UserInfo> all = userInfoDao.findAll();
        return new PageInfo<>(all);
    }

    @Override
    public UserInfo findById(String id) {
        UserInfo userInfo = userInfoDao.findById(id);
        return userInfo;
    }

    @Override
    public UserInfo login(String username, String password) {
        return userInfoDao.findByUsernameAndPassword(username, password);
    }

    @Override
    public boolean save(UserInfo userInfo) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        userInfo.setId(id);
        return userInfoDao.save(userInfo);
    }

    /**
     * 附加业务
     * 给user添加role
     * @param ids
     * @param userId
     */
    @Override
    public void addRoleToUser(String ids, String userId) {
        //对中间表的操作
        //先删除用户的所有的角色信息
        userInfoDao.deleteRoles(userId);
        //判断ids是否为null
        if (ids != null) {
            String[] roleIds = ids.split(",");
            //遍历添加用户的拥有的角色信息
            for (String roleId : roleIds) {
                userInfoDao.saveRoles(roleId, userId);
            }
        }
    }
}
