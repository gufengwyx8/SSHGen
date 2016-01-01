/*
 * @(#)Detector.java 2015-12-6 下午03:00:43 TagManager
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
 * Detector
 * @author wyx
 * @version 1.0
 *
 */
@Entity
public class Detector {
    private Integer id;

    private Double locationX;

    private Double locationY;

    private String name;

    private String description;

    private User admin;

    private Date createDate;

    private Office office;

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
     * 返回  locationX
     * @return locationX
     */
    public Double getLocationX() {
        return locationX;
    }

    /**
     * 设置 locationX
     * @param locationX locationX
     */
    public void setLocationX(Double locationX) {
        this.locationX = locationX;
    }

    /**
     * 返回  locationY
     * @return locationY
     */
    public Double getLocationY() {
        return locationY;
    }

    /**
     * 设置 locationY
     * @param locationY locationY
     */
    public void setLocationY(Double locationY) {
        this.locationY = locationY;
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

    /**
     * 返回  office
     * @return office
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    public Office getOffice() {
        return office;
    }

    /**
     * 设置 office
     * @param office office
     */
    public void setOffice(Office office) {
        this.office = office;
    }

}
