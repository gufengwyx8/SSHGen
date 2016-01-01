/*
 * @(#)AuditLog.java 2015-12-6 ����03:14:09 TagManager
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
 * AuditLog
 * @author wyx
 * @version 1.0
 *
 */
@Entity
public class AuditLog {
    private Integer id;

    private String content;

    private Date date;

    private Tag tag;

    private Device device;

    private Integer level;

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
     * ����  content
     * @return content
     */
    @Lob
    public String getContent() {
        return content;
    }

    /**
     * ���� content
     * @param content content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * ����  date
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * ���� date
     * @param date date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * ����  tag
     * @return tag
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    public Tag getTag() {
        return tag;
    }

    /**
     * ���� tag
     * @param tag tag
     */
    public void setTag(Tag tag) {
        this.tag = tag;
    }

    /**
     * ����  device
     * @return device
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    public Device getDevice() {
        return device;
    }

    /**
     * ���� device
     * @param device device
     */
    public void setDevice(Device device) {
        this.device = device;
    }

    /**
     * ����  level
     * @return level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * ���� level
     * @param level level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

}
