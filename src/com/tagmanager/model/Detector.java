/*
 * @(#)Detector.java 2015-12-6 ����03:00:43 TagManager
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
     * ����  locationX
     * @return locationX
     */
    public Double getLocationX() {
        return locationX;
    }

    /**
     * ���� locationX
     * @param locationX locationX
     */
    public void setLocationX(Double locationX) {
        this.locationX = locationX;
    }

    /**
     * ����  locationY
     * @return locationY
     */
    public Double getLocationY() {
        return locationY;
    }

    /**
     * ���� locationY
     * @param locationY locationY
     */
    public void setLocationY(Double locationY) {
        this.locationY = locationY;
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

    /**
     * ����  office
     * @return office
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    public Office getOffice() {
        return office;
    }

    /**
     * ���� office
     * @param office office
     */
    public void setOffice(Office office) {
        this.office = office;
    }

}
