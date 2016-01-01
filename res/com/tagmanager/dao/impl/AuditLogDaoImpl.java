/*
 * @(#)AuditLogDaoImpl.java 2015-4-4 обнГ02:29:05
 * erp-manufacture
 */
package com.erp.dao.impl;

import org.springframework.stereotype.Component;

import com.erp.dao.AuditLogDao;
import com.erp.model.AuditLog;

/**
 * AuditLogDaoImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("auditLogDao")
public class AuditLogDaoImpl extends BaseDaoImpl<AuditLog> implements AuditLogDao {

}
