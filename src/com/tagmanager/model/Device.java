/*
 * @(#)Device.java 2015-12-6 ����02:52:00 TagManager
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
     * ����  id
     * @return id
     */
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    /**
     * ���� id
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * ����  name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * ���� name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ����  description
     * @return description
     */
    @Lob
    public String getDescription() {
        return description;
    }

    /**
     * ���� description
     * @param description description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * ����  ip
     * @return ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * ���� ip
     * @param ip ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * ����  port
     * @return port
     */
    public String getPort() {
        return port;
    }

    /**
     * ���� port
     * @param port port
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * ����  admin
     * @return admin
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    public User getAdmin() {
        return admin;
    }

    /**
     * ���� admin
     * @param admin admin
     */
    public void setAdmin(User admin) {
        this.admin = admin;
    }

    /**
     * ����  deviceGroup
     * @return deviceGroup
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_group_id")
    public DeviceGroup getDeviceGroup() {
        return deviceGroup;
    }

    /**
     * ���� deviceGroup
     * @param deviceGroup deviceGroup
     */
    public void setDeviceGroup(DeviceGroup deviceGroup) {
        this.deviceGroup = deviceGroup;
    }

    /**
     * ����  createDate
     * @return createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * ���� createDate
     * @param createDate createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
