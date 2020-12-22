package com.itheima.ssm.service.system;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Role;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface RoleService {
    /**
     * 分页查询所有
     *
     * @return
     */
    PageInfo<Role> findAll(Integer start, Integer pageSize);

    /**
     * 查询所有
     *
     * @return
     */
    List<Role> findAll();

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Role findById(String id);

    /**
     * 添加
     *
     * @param role
     * @return
     */
    @Transactional(readOnly = false)
    boolean save(Role role);

    /**
     * 管理角色权限
     *
     * @param ids
     * @param roleId
     */
    @Transactional(readOnly = false)
    void addPermissionToRole(String ids, String roleId);
}
