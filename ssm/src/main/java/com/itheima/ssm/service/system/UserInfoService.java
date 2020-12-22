package com.itheima.ssm.service.system;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.UserInfo;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface UserInfoService {
    /**
     * 查询所有订单
     *
     * @return 返回订单集合
     */
    PageInfo<UserInfo> findAll(Integer start, Integer pageSize);

    /**
     * 根据ID查询订单
     *
     * @param id
     * @return
     */
    UserInfo findById(String id);

    /**
     * 根据用户名和密码查询
     *
     * @param username
     * @param password
     * @return
     */
    UserInfo login(String username, String password);

    /**
     * 添加
     *
     * @param userInfo
     * @return
     */
    @Transactional(readOnly = false)
    boolean save(UserInfo userInfo);

    /**
     * 添加用户角色（选做一）
     *
     * @param ids
     * @param userId
     */
    @Transactional(readOnly = false)
    void addRoleToUser(String ids, String userId);
}
