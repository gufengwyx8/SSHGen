/*
 * @(#)DetectorServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.DetectorDao;
import com.erp.model.Detector;
import com.erp.service.DetectorService;

/**
 * DetectorServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("detectorService")
public class DetectorServiceImpl extends BaseServiceImpl<Detector> implements DetectorService {

    @Resource(name = "detectorDao")
    private DetectorDao detectorDao;

    @Override
    protected BaseDao<Detector> getBaseDao() {
        return detectorDao;
    }

}
