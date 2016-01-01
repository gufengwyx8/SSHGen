/*
 * @(#)RoleAction.java 2015-4-4 下午02:45:11 erp-manufacture
 */
package com.erp.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.erp.model.Role;

/**
 * RoleAction
 * @author wang
 * @version 1.0
 *
 */
@Component("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction {
    
    public static final String UPLOAD_PATH = "/upload/role";
    
    private Role role;

    private List<Role> roleList;
    
    private File file;

    private String fileFileName;

    private String fileContentType;
    
    private String content;
    
    public String listRole() {
        roleList = roleService.list();
        return SUCCESS;
    }

    public String saveRole() {
        role.setDate(new Date());
        role.setUser(loginUser);
        roleService.saveOrUpdate(role);
        msg = "success";
        return SUCCESS;
    }

    public String destoryRole() {
        role = roleService.getEntityById(role.getId());
        roleService.delete(role);
        return SUCCESS;
    }

    public String listRoleDetail() {
        role = roleService.getEntityById(role.getId());
        return SUCCESS;
    }
    
    public String submitContent(){
        role = roleService.getEntityById(role.getId());
        role.setContent(content);
        if (file != null) {
            role.setFileName(fileFileName);
            String realpath = ServletActionContext.getServletContext()
                    .getRealPath(UPLOAD_PATH);
            String uuid = UUID.randomUUID().toString();
            role.setRealFileName(uuid);
            File newFile = new File(realpath, uuid);
            try {
                FileUtils.copyFile(file, newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        roleService.saveOrUpdate(role);
        return SUCCESS;
    }

    public String download() {
        role = roleService.getEntityById(role.getId());
        file = new File(ServletActionContext.getServletContext().getRealPath(
            UPLOAD_PATH), String.valueOf(role.getRealFileName()));
        try {
            fileFileName = new String(role.getFileName().getBytes(),
                    "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 返回  role
     * @return role
     */
    public Role getRole() {
        return role;
    }

    /**
     * 设置 role
     * @param role role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * 返回  roleList
     * @return roleList
     */
    public List<Role> getRoleList() {
        return roleList;
    }

    /**
     * 设置 roleList
     * @param roleList roleList
     */
    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
    
    /**
     * 返回  file
     * @return file
     */
    public File getFile() {
        return file;
    }

    /**
     * 设置 file
     * @param file file
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * 返回  fileFileName
     * @return fileFileName
     */
    public String getFileFileName() {
        return fileFileName;
    }

    /**
     * 设置 fileFileName
     * @param fileFileName fileFileName
     */
    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    /**
     * 返回  fileContentType
     * @return fileContentType
     */
    public String getFileContentType() {
        return fileContentType;
    }

    /**
     * 设置 fileContentType
     * @param fileContentType fileContentType
     */
    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }
    
    /**
     * 返回  fileContentType
     * @return fileContentType
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置 fileContentType
     * @param fileContentType fileContentType
     */
    public void setContent(String content) {
        this.content = content;
    }

}
