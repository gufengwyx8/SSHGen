/*
 * @(#)Device.java 2015-12-6 下午02:52:00 TagManager
 */
package com.tagmanager.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 * Device
 * @author wyx
 * @version 1.0
 *
 */
@Entity
public class Device {
    private Integer id;

    private String name;

    private String description;

    private String ip;

    private String port;

    private User admin;
    
    private Date createDate;

    private DeviceGroup deviceGroup;

    /**
     * 返回  id
     * @return id
     */
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    /**
     * 设置 id
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 返回  name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 返回  description
     * @return description
     */
    @Lob
    public String getDescription() {
        return description;
    }

    /**
     * 设置 description
     * @param description description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 返回  ip
     * @return ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置 ip
     * @param ip ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 返回  port
     * @return port
     */
    public String getPort() {
        return port;
    }

    /**
     * 设置 port
     * @param port port
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * 返回  admin
     * @return admin
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    public User getAdmin() {
        return admin;
    }

    /**
     * 设置 admin
     * @param admin admin
     */
    public void setAdmin(User admin) {
        this.admin = admin;
    }

    /**
     * 返回  deviceGroup
     * @return deviceGroup
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_group_id")
    public DeviceGroup getDeviceGroup() {
        return deviceGroup;
    }

    /**
     * 设置 deviceGroup
     * @param deviceGroup deviceGroup
     */
    public void setDeviceGroup(DeviceGroup deviceGroup) {
        this.deviceGroup = deviceGroup;
    }

    /**
     * 返回  createDate
     * @return createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置 createDate
     * @param createDate createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
