/*
 * @(#)TagLocationStatusServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.TagLocationStatusDao;
import com.erp.model.TagLocationStatus;
import com.erp.service.TagLocationStatusService;

/**
 * TagLocationStatusServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("tagLocationStatusService")
public class TagLocationStatusServiceImpl extends BaseServiceImpl<TagLocationStatus> implements TagLocationStatusService {

    @Resource(name = "tagLocationStatusDao")
    private TagLocationStatusDao tagLocationStatusDao;

    @Override
    protected BaseDao<TagLocationStatus> getBaseDao() {
        return tagLocationStatusDao;
    }

}
