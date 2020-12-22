package com.itheima.ssm.service.system;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Permission;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface PermissionService {
    /**
     * 分页查询
     *
     * @return
     */
    PageInfo<Permission> findAll(Integer start, Integer pageSize);

    /**
     * 查询全部
     *
     * @return
     */
    List<Permission> findAll();

    /**
     * 添加
     *
     * @param permission
     * @return
     */
    @Transactional(readOnly = false)
    boolean save(Permission permission);
}
