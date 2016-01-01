/*
 * @(#)TagAction.java 2015-4-4 ����02:45:11 erp-manufacture
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

import com.erp.model.Tag;

/**
 * TagAction
 * @author wang
 * @version 1.0
 *
 */
@Component("tagAction")
@Scope("prototype")
public class TagAction extends BaseAction {
    
    public static final String UPLOAD_PATH = "/upload/tag";
    
    private Tag tag;

    private List<Tag> tagList;
    
    private File file;

    private String fileFileName;

    private String fileContentType;
    
    private String content;
    
    public String listTag() {
        tagList = tagService.list();
        return SUCCESS;
    }

    public String saveTag() {
        tag.setDate(new Date());
        tag.setUser(loginUser);
        tagService.saveOrUpdate(tag);
        msg = "success";
        return SUCCESS;
    }

    public String destoryTag() {
        tag = tagService.getEntityById(tag.getId());
        tagService.delete(tag);
        return SUCCESS;
    }

    public String listTagDetail() {
        tag = tagService.getEntityById(tag.getId());
        return SUCCESS;
    }
    
    public String submitContent(){
        tag = tagService.getEntityById(tag.getId());
        tag.setContent(content);
        if (file != null) {
            tag.setFileName(fileFileName);
            String realpath = ServletActionContext.getServletContext()
                    .getRealPath(UPLOAD_PATH);
            String uuid = UUID.randomUUID().toString();
            tag.setRealFileName(uuid);
            File newFile = new File(realpath, uuid);
            try {
                FileUtils.copyFile(file, newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        tagService.saveOrUpdate(tag);
        return SUCCESS;
    }

    public String download() {
        tag = tagService.getEntityById(tag.getId());
        file = new File(ServletActionContext.getServletContext().getRealPath(
            UPLOAD_PATH), String.valueOf(tag.getRealFileName()));
        try {
            fileFileName = new String(tag.getFileName().getBytes(),
                    "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * ����  tag
     * @return tag
     */
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
     * ����  tagList
     * @return tagList
     */
    public List<Tag> getTagList() {
        return tagList;
    }

    /**
     * ���� tagList
     * @param tagList tagList
     */
    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
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
