/*
 * @(#)AuditLog.java 2015-12-6 下午03:14:09 TagManager
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
     * 返回  content
     * @return content
     */
    @Lob
    public String getContent() {
        return content;
    }

    /**
     * 设置 content
     * @param content content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 返回  date
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置 date
     * @param date date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 返回  tag
     * @return tag
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    public Tag getTag() {
        return tag;
    }

    /**
     * 设置 tag
     * @param tag tag
     */
    public void setTag(Tag tag) {
        this.tag = tag;
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

    /**
     * 返回  level
     * @return level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置 level
     * @param level level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

}
