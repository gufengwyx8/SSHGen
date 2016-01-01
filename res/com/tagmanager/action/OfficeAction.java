/*
 * @(#)OfficeAction.java 2015-4-4 ����02:45:11 erp-manufacture
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

import com.erp.model.Office;

/**
 * OfficeAction
 * @author wang
 * @version 1.0
 *
 */
@Component("officeAction")
@Scope("prototype")
public class OfficeAction extends BaseAction {
    
    public static final String UPLOAD_PATH = "/upload/office";
    
    private Office office;

    private List<Office> officeList;
    
    private File file;

    private String fileFileName;

    private String fileContentType;
    
    private String content;
    
    public String listOffice() {
        officeList = officeService.list();
        return SUCCESS;
    }

    public String saveOffice() {
        office.setDate(new Date());
        office.setUser(loginUser);
        officeService.saveOrUpdate(office);
        msg = "success";
        return SUCCESS;
    }

    public String destoryOffice() {
        office = officeService.getEntityById(office.getId());
        officeService.delete(office);
        return SUCCESS;
    }

    public String listOfficeDetail() {
        office = officeService.getEntityById(office.getId());
        return SUCCESS;
    }
    
    public String submitContent(){
        office = officeService.getEntityById(office.getId());
        office.setContent(content);
        if (file != null) {
            office.setFileName(fileFileName);
            String realpath = ServletActionContext.getServletContext()
                    .getRealPath(UPLOAD_PATH);
            String uuid = UUID.randomUUID().toString();
            office.setRealFileName(uuid);
            File newFile = new File(realpath, uuid);
            try {
                FileUtils.copyFile(file, newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        officeService.saveOrUpdate(office);
        return SUCCESS;
    }

    public String download() {
        office = officeService.getEntityById(office.getId());
        file = new File(ServletActionContext.getServletContext().getRealPath(
            UPLOAD_PATH), String.valueOf(office.getRealFileName()));
        try {
            fileFileName = new String(office.getFileName().getBytes(),
                    "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * ����  office
     * @return office
     */
    public Office getOffice() {
        return office;
    }

    /**
     * ���� office
     * @param office office
     */
    public void setOffice(Office office) {
        this.office = office;
    }

    /**
     * ����  officeList
     * @return officeList
     */
    public List<Office> getOfficeList() {
        return officeList;
    }

    /**
     * ���� officeList
     * @param officeList officeList
     */
    public void setOfficeList(List<Office> officeList) {
        this.officeList = officeList;
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
