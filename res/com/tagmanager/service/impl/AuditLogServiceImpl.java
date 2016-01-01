/*
 * @(#)AuditLogServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.AuditLogDao;
import com.erp.model.AuditLog;
import com.erp.service.AuditLogService;

/**
 * AuditLogServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("auditLogService")
public class AuditLogServiceImpl extends BaseServiceImpl<AuditLog> implements AuditLogService {

    @Resource(name = "auditLogDao")
    private AuditLogDao auditLogDao;

    @Override
    protected BaseDao<AuditLog> getBaseDao() {
        return auditLogDao;
    }

}
