/*
 * @(#)DeviceGroupServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.DeviceGroupDao;
import com.erp.model.DeviceGroup;
import com.erp.service.DeviceGroupService;

/**
 * DeviceGroupServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("deviceGroupService")
public class DeviceGroupServiceImpl extends BaseServiceImpl<DeviceGroup> implements DeviceGroupService {

    @Resource(name = "deviceGroupDao")
    private DeviceGroupDao deviceGroupDao;

    @Override
    protected BaseDao<DeviceGroup> getBaseDao() {
        return deviceGroupDao;
    }

}
