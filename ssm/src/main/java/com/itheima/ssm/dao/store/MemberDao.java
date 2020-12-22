package com.itheima.ssm.dao.store;

import com.itheima.ssm.domain.Member;

public interface MemberDao {
    /**
     * 根据id查询订单信息
     *
     * @param id
     * @return
     */
    Member findById(String id);
}
