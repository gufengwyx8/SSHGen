/*
 * @(#)DeviceGroup.java 2015-12-6 ����02:53:06 TagManager
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
     * ����  parentGroup
     * @return parentGroup
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_group_id")
    public DeviceGroup getParentGroup() {
        return parentGroup;
    }

    /**
     * ���� parentGroup
     * @param parentGroup parentGroup
     */
    public void setParentGroup(DeviceGroup parentGroup) {
        this.parentGroup = parentGroup;
    }
}
