/*
 * @(#)TagLocationStatusAction.java 2015-4-4 下午02:45:11 erp-manufacture
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

import com.erp.model.TagLocationStatus;

/**
 * TagLocationStatusAction
 * @author wang
 * @version 1.0
 *
 */
@Component("tagLocationStatusAction")
@Scope("prototype")
public class TagLocationStatusAction extends BaseAction {
    
    public static final String UPLOAD_PATH = "/upload/tagLocationStatus";
    
    private TagLocationStatus tagLocationStatus;

    private List<TagLocationStatus> tagLocationStatusList;
    
    private File file;

    private String fileFileName;

    private String fileContentType;
    
    private String content;
    
    public String listTagLocationStatus() {
        tagLocationStatusList = tagLocationStatusService.list();
        return SUCCESS;
    }

    public String saveTagLocationStatus() {
        tagLocationStatus.setDate(new Date());
        tagLocationStatus.setUser(loginUser);
        tagLocationStatusService.saveOrUpdate(tagLocationStatus);
        msg = "success";
        return SUCCESS;
    }

    public String destoryTagLocationStatus() {
        tagLocationStatus = tagLocationStatusService.getEntityById(tagLocationStatus.getId());
        tagLocationStatusService.delete(tagLocationStatus);
        return SUCCESS;
    }

    public String listTagLocationStatusDetail() {
        tagLocationStatus = tagLocationStatusService.getEntityById(tagLocationStatus.getId());
        return SUCCESS;
    }
    
    public String submitContent(){
        tagLocationStatus = tagLocationStatusService.getEntityById(tagLocationStatus.getId());
        tagLocationStatus.setContent(content);
        if (file != null) {
            tagLocationStatus.setFileName(fileFileName);
            String realpath = ServletActionContext.getServletContext()
                    .getRealPath(UPLOAD_PATH);
            String uuid = UUID.randomUUID().toString();
            tagLocationStatus.setRealFileName(uuid);
            File newFile = new File(realpath, uuid);
            try {
                FileUtils.copyFile(file, newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        tagLocationStatusService.saveOrUpdate(tagLocationStatus);
        return SUCCESS;
    }

    public String download() {
        tagLocationStatus = tagLocationStatusService.getEntityById(tagLocationStatus.getId());
        file = new File(ServletActionContext.getServletContext().getRealPath(
            UPLOAD_PATH), String.valueOf(tagLocationStatus.getRealFileName()));
        try {
            fileFileName = new String(tagLocationStatus.getFileName().getBytes(),
                    "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 返回  tagLocationStatus
     * @return tagLocationStatus
     */
    public TagLocationStatus getTagLocationStatus() {
        return tagLocationStatus;
    }

    /**
     * 设置 tagLocationStatus
     * @param tagLocationStatus tagLocationStatus
     */
    public void setTagLocationStatus(TagLocationStatus tagLocationStatus) {
        this.tagLocationStatus = tagLocationStatus;
    }

    /**
     * 返回  tagLocationStatusList
     * @return tagLocationStatusList
     */
    public List<TagLocationStatus> getTagLocationStatusList() {
        return tagLocationStatusList;
    }

    /**
     * 设置 tagLocationStatusList
     * @param tagLocationStatusList tagLocationStatusList
     */
    public void setTagLocationStatusList(List<TagLocationStatus> tagLocationStatusList) {
        this.tagLocationStatusList = tagLocationStatusList;
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
