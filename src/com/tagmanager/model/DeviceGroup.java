/*
 * @(#)DeviceGroup.java 2015-12-6 下午02:53:06 TagManager
 */
package com.tagmanager.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 * DeviceGroup
 * @author wyx
 * @version 1.0
 *
 */
@Entity
public class DeviceGroup {
    private Integer id;

    private String name;

    private String description;

    private DeviceGroup parentGroup;

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
     * 返回  parentGroup
     * @return parentGroup
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_group_id")
    public DeviceGroup getParentGroup() {
        return parentGroup;
    }

    /**
     * 设置 parentGroup
     * @param parentGroup parentGroup
     */
    public void setParentGroup(DeviceGroup parentGroup) {
        this.parentGroup = parentGroup;
    }
}
