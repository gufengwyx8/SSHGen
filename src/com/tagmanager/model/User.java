/*
 * @(#)User.java 2013-4-10 下午12:51:27 Order
 */
package com.tagmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * User
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class User {

    private Integer id;

    private String name;

    private String password;

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
     * 返回  password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置 password
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User)) {
            return false;
        }
        User u = (User) o;
        return this.getId().equals(u.getId());
    }

    @Override
    public int hashCode() {
        return this.getId() * 31;
    }

}
