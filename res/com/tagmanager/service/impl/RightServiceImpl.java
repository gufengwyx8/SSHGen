/*
 * @(#)RightServiceImpl.java 2015-4-4 обнГ02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.RightDao;
import com.erp.model.Right;
import com.erp.service.RightService;

/**
 * RightServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("rightService")
public class RightServiceImpl extends BaseServiceImpl<Right> implements RightService {

    @Resource(name = "rightDao")
    private RightDao rightDao;

    @Override
    protected BaseDao<Right> getBaseDao() {
        return rightDao;
    }

}
