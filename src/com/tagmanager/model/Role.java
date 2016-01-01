/*
 * @(#)Role.java 2015-12-6 下午03:09:07 TagManager
 */
package com.tagmanager.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

/**
 * Role
 * @author wyx
 * @version 1.0
 *
 */
@Entity
public class Role {
    private Integer id;

    private String name;

    private String description;

    private List<Right> rightList;

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
     * 返回  rightList
     * @return rightList
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_right", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "right_id"))
    public List<Right> getRightList() {
        return rightList;
    }

    /**
     * 设置 rightList
     * @param rightList rightList
     */
    public void setRightList(List<Right> rightList) {
        this.rightList = rightList;
    }

}
