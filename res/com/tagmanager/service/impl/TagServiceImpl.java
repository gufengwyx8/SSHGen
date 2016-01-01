/*
 * @(#)TagServiceImpl.java 2015-4-4 обнГ02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.TagDao;
import com.erp.model.Tag;
import com.erp.service.TagService;

/**
 * TagServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("tagService")
public class TagServiceImpl extends BaseServiceImpl<Tag> implements TagService {

    @Resource(name = "tagDao")
    private TagDao tagDao;

    @Override
    protected BaseDao<Tag> getBaseDao() {
        return tagDao;
    }

}
