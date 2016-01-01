/*
 * @(#)TagDaoImpl.java 2015-4-4 обнГ02:29:05
 * erp-manufacture
 */
package com.erp.dao.impl;

import org.springframework.stereotype.Component;

import com.erp.dao.TagDao;
import com.erp.model.Tag;

/**
 * TagDaoImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("tagDao")
public class TagDaoImpl extends BaseDaoImpl<Tag> implements TagDao {

}
