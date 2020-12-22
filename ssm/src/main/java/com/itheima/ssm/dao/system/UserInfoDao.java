package com.itheima.ssm.dao.system;

import com.itheima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoDao {

    /**
     * 查询全部
     *
     * @return
     */
    List<UserInfo> findAll();

    /**
     * 根据id查询
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
    UserInfo findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    /**
     * 添加用户
     *
     * @param userInfo
     * @return
     */
    boolean save(UserInfo userInfo);

    /**
     * 删除用户的角色
     *
     * @param userId
     * @return
     */
    boolean deleteRoles(String userId);

    /**
     * 添加用户的角色
     *
     * @param roleId
     * @param userId
     * @return
     */
    boolean saveRoles(@Param("roleId") String roleId, @Param("userId") String userId);
}
