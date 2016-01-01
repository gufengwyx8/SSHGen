/*
 * @(#)Tag.java 2015-12-6 下午02:49:35 TagManager
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
 * Tag
 * @author wyx
 * @version 1.0
 *
 */
@Entity
public class Tag {
    private Integer id;

    private String name;

    private String description;

    private Date updateDate;

    private User updateUser;

    private Device device;

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
     * 返回  updateDate
     * @return updateDate
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置 updateDate
     * @param updateDate updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回  updateUser
     * @return updateUser
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "update_user_id")
    public User getUpdateUser() {
        return updateUser;
    }

    /**
     * 设置 updateUser
     * @param updateUser updateUser
     */
    public void setUpdateUser(User updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 返回  device
     * @return device
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    public Device getDevice() {
        return device;
    }

    /**
     * 设置 device
     * @param device device
     */
    public void setDevice(Device device) {
        this.device = device;
    }

}
