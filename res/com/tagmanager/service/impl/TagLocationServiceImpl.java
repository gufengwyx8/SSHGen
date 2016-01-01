/*
 * @(#)TagLocationServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.TagLocationDao;
import com.erp.model.TagLocation;
import com.erp.service.TagLocationService;

/**
 * TagLocationServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("tagLocationService")
public class TagLocationServiceImpl extends BaseServiceImpl<TagLocation> implements TagLocationService {

    @Resource(name = "tagLocationDao")
    private TagLocationDao tagLocationDao;

    @Override
    protected BaseDao<TagLocation> getBaseDao() {
        return tagLocationDao;
    }

}
