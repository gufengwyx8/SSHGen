/*
 * @(#)RightAction.java 2015-4-4 下午02:45:11 erp-manufacture
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

import com.erp.model.Right;

/**
 * RightAction
 * @author wang
 * @version 1.0
 *
 */
@Component("rightAction")
@Scope("prototype")
public class RightAction extends BaseAction {
    
    public static final String UPLOAD_PATH = "/upload/right";
    
    private Right right;

    private List<Right> rightList;
    
    private File file;

    private String fileFileName;

    private String fileContentType;
    
    private String content;
    
    public String listRight() {
        rightList = rightService.list();
        return SUCCESS;
    }

    public String saveRight() {
        right.setDate(new Date());
        right.setUser(loginUser);
        rightService.saveOrUpdate(right);
        msg = "success";
        return SUCCESS;
    }

    public String destoryRight() {
        right = rightService.getEntityById(right.getId());
        rightService.delete(right);
        return SUCCESS;
    }

    public String listRightDetail() {
        right = rightService.getEntityById(right.getId());
        return SUCCESS;
    }
    
    public String submitContent(){
        right = rightService.getEntityById(right.getId());
        right.setContent(content);
        if (file != null) {
            right.setFileName(fileFileName);
            String realpath = ServletActionContext.getServletContext()
                    .getRealPath(UPLOAD_PATH);
            String uuid = UUID.randomUUID().toString();
            right.setRealFileName(uuid);
            File newFile = new File(realpath, uuid);
            try {
                FileUtils.copyFile(file, newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        rightService.saveOrUpdate(right);
        return SUCCESS;
    }

    public String download() {
        right = rightService.getEntityById(right.getId());
        file = new File(ServletActionContext.getServletContext().getRealPath(
            UPLOAD_PATH), String.valueOf(right.getRealFileName()));
        try {
            fileFileName = new String(right.getFileName().getBytes(),
                    "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 返回  right
     * @return right
     */
    public Right getRight() {
        return right;
    }

    /**
     * 设置 right
     * @param right right
     */
    public void setRight(Right right) {
        this.right = right;
    }

    /**
     * 返回  rightList
     * @return rightList
     */
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
