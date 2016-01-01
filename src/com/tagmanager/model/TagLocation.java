/*
 * @(#)TagLocation.java 2015-12-6 ����03:03:28 TagManager
 */
package com.tagmanager.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * TagLocation
 * @author wyx
 * @version 1.0
 *
 */
@Entity
public class TagLocation {
    private Integer id;

    private Tag tag;

    private Detector detector;

    private TagLocationStatus tagLocationStatus;

    private Date date;

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
     * ����  detector
     * @return detector
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detector_id")
    public Detector getDetector() {
        return detector;
    }

    /**
     * ���� detector
     * @param detector detector
     */
    public void setDetector(Detector detector) {
        this.detector = detector;
    }

    /**
     * ����  tagLocationStatus
     * @return tagLocationStatus
     */
    public TagLocationStatus getTagLocationStatus() {
        return tagLocationStatus;
    }

    /**
     * ���� tagLocationStatus
     * @param tagLocationStatus tagLocationStatus
     */
    public void setTagLocationStatus(TagLocationStatus tagLocationStatus) {
        this.tagLocationStatus = tagLocationStatus;
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

}
