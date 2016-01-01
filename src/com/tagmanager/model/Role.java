/*
 * @(#)Role.java 2015-12-6 ����03:09:07 TagManager
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
     * ����  rightList
     * @return rightList
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_right", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "right_id"))
    public List<Right> getRightList() {
        return rightList;
    }

    /**
     * ���� rightList
     * @param rightList rightList
     */
    public void setRightList(List<Right> rightList) {
        this.rightList = rightList;
    }

}
