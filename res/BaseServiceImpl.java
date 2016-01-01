/*
 * @(#)${Upper}ServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.${Upper}Dao;
import com.erp.model.${Upper};
import com.erp.service.${Upper}Service;

/**
 * ${Upper}ServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("${Lower}Service")
public class ${Upper}ServiceImpl extends BaseServiceImpl<${Upper}> implements ${Upper}Service {

    @Resource(name = "${Lower}Dao")
    private ${Upper}Dao ${Lower}Dao;

    @Override
    protected BaseDao<${Upper}> getBaseDao() {
        return ${Lower}Dao;
    }

}
