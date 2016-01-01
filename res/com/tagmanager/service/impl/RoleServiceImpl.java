/*
 * @(#)RoleServiceImpl.java 2015-4-4 обнГ02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.RoleDao;
import com.erp.model.Role;
import com.erp.service.RoleService;

/**
 * RoleServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Resource(name = "roleDao")
    private RoleDao roleDao;

    @Override
    protected BaseDao<Role> getBaseDao() {
        return roleDao;
    }

}
