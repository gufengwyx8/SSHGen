/*
 * @(#)DeviceServiceImpl.java 2015-4-4 обнГ02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.DeviceDao;
import com.erp.model.Device;
import com.erp.service.DeviceService;

/**
 * DeviceServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("deviceService")
public class DeviceServiceImpl extends BaseServiceImpl<Device> implements DeviceService {

    @Resource(name = "deviceDao")
    private DeviceDao deviceDao;

    @Override
    protected BaseDao<Device> getBaseDao() {
        return deviceDao;
    }

}
