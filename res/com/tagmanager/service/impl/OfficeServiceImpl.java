/*
 * @(#)OfficeServiceImpl.java 2015-4-4 обнГ02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.OfficeDao;
import com.erp.model.Office;
import com.erp.service.OfficeService;

/**
 * OfficeServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("officeService")
public class OfficeServiceImpl extends BaseServiceImpl<Office> implements OfficeService {

    @Resource(name = "officeDao")
    private OfficeDao officeDao;

    @Override
    protected BaseDao<Office> getBaseDao() {
        return officeDao;
    }

}
