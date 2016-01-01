/*
 * @(#)TagLocationAction.java 2015-4-4 ����02:45:11 erp-manufacture
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

import com.erp.model.TagLocation;

/**
 * TagLocationAction
 * @author wang
 * @version 1.0
 *
 */
@Component("tagLocationAction")
@Scope("prototype")
public class TagLocationAction extends BaseAction {
    
    public static final String UPLOAD_PATH = "/upload/tagLocation";
    
    private TagLocation tagLocation;

    private List<TagLocation> tagLocationList;
    
    private File file;

    private String fileFileName;

    private String fileContentType;
    
    private String content;
    
    public String listTagLocation() {
        tagLocationList = tagLocationService.list();
        return SUCCESS;
    }

    public String saveTagLocation() {
        tagLocation.setDate(new Date());
        tagLocation.setUser(loginUser);
        tagLocationService.saveOrUpdate(tagLocation);
        msg = "success";
        return SUCCESS;
    }

    public String destoryTagLocation() {
        tagLocation = tagLocationService.getEntityById(tagLocation.getId());
        tagLocationService.delete(tagLocation);
        return SUCCESS;
    }

    public String listTagLocationDetail() {
        tagLocation = tagLocationService.getEntityById(tagLocation.getId());
        return SUCCESS;
    }
    
    public String submitContent(){
        tagLocation = tagLocationService.getEntityById(tagLocation.getId());
        tagLocation.setContent(content);
        if (file != null) {
            tagLocation.setFileName(fileFileName);
            String realpath = ServletActionContext.getServletContext()
                    .getRealPath(UPLOAD_PATH);
            String uuid = UUID.randomUUID().toString();
            tagLocation.setRealFileName(uuid);
            File newFile = new File(realpath, uuid);
            try {
                FileUtils.copyFile(file, newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        tagLocationService.saveOrUpdate(tagLocation);
        return SUCCESS;
    }

    public String download() {
        tagLocation = tagLocationService.getEntityById(tagLocation.getId());
        file = new File(ServletActionContext.getServletContext().getRealPath(
            UPLOAD_PATH), String.valueOf(tagLocation.getRealFileName()));
        try {
            fileFileName = new String(tagLocation.getFileName().getBytes(),
                    "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * ����  tagLocation
     * @return tagLocation
     */
    public TagLocation getTagLocation() {
        return tagLocation;
    }

    /**
     * ���� tagLocation
     * @param tagLocation tagLocation
     */
    public void setTagLocation(TagLocation tagLocation) {
        this.tagLocation = tagLocation;
    }

    /**
     * ����  tagLocationList
     * @return tagLocationList
     */
    public List<TagLocation> getTagLocationList() {
        return tagLocationList;
    }

    /**
     * ���� tagLocationList
     * @param tagLocationList tagLocationList
     */
    public void setTagLocationList(List<TagLocation> tagLocationList) {
        this.tagLocationList = tagLocationList;
    }
    
    /**
     * ����  file
     * @return file
     */
    public File getFile() {
        return file;
    }

    /**
     * ���� file
     * @param file file
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * ����  fileFileName
     * @return fileFileName
     */
    public String getFileFileName() {
        return fileFileName;
    }

    /**
     * ���� fileFileName
     * @param fileFileName fileFileName
     */
    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    /**
     * ����  fileContentType
     * @return fileContentType
     */
    public String getFileContentType() {
        return fileContentType;
    }

    /**
     * ���� fileContentType
     * @param fileContentType fileContentType
     */
    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }
    
    /**
     * ����  fileContentType
     * @return fileContentType
     */
    public String getContent() {
        return content;
    }

    /**
     * ���� fileContentType
     * @param fileContentType fileContentType
     */
    public void setContent(String content) {
        this.content = content;
    }

}
