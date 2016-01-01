/*
 * @(#)AuditLogAction.java 2015-4-4 ����02:45:11 erp-manufacture
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

import com.erp.model.AuditLog;

/**
 * AuditLogAction
 * @author wang
 * @version 1.0
 *
 */
@Component("auditLogAction")
@Scope("prototype")
public class AuditLogAction extends BaseAction {
    
    public static final String UPLOAD_PATH = "/upload/auditLog";
    
    private AuditLog auditLog;

    private List<AuditLog> auditLogList;
    
    private File file;

    private String fileFileName;

    private String fileContentType;
    
    private String content;
    
    public String listAuditLog() {
        auditLogList = auditLogService.list();
        return SUCCESS;
    }

    public String saveAuditLog() {
        auditLog.setDate(new Date());
        auditLog.setUser(loginUser);
        auditLogService.saveOrUpdate(auditLog);
        msg = "success";
        return SUCCESS;
    }

    public String destoryAuditLog() {
        auditLog = auditLogService.getEntityById(auditLog.getId());
        auditLogService.delete(auditLog);
        return SUCCESS;
    }

    public String listAuditLogDetail() {
        auditLog = auditLogService.getEntityById(auditLog.getId());
        return SUCCESS;
    }
    
    public String submitContent(){
        auditLog = auditLogService.getEntityById(auditLog.getId());
        auditLog.setContent(content);
        if (file != null) {
            auditLog.setFileName(fileFileName);
            String realpath = ServletActionContext.getServletContext()
                    .getRealPath(UPLOAD_PATH);
            String uuid = UUID.randomUUID().toString();
            auditLog.setRealFileName(uuid);
            File newFile = new File(realpath, uuid);
            try {
                FileUtils.copyFile(file, newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        auditLogService.saveOrUpdate(auditLog);
        return SUCCESS;
    }

    public String download() {
        auditLog = auditLogService.getEntityById(auditLog.getId());
        file = new File(ServletActionContext.getServletContext().getRealPath(
            UPLOAD_PATH), String.valueOf(auditLog.getRealFileName()));
        try {
            fileFileName = new String(auditLog.getFileName().getBytes(),
                    "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * ����  auditLog
     * @return auditLog
     */
    public AuditLog getAuditLog() {
        return auditLog;
    }

    /**
     * ���� auditLog
     * @param auditLog auditLog
     */
    public void setAuditLog(AuditLog auditLog) {
        this.auditLog = auditLog;
    }

    /**
     * ����  auditLogList
     * @return auditLogList
     */
    public List<AuditLog> getAuditLogList() {
        return auditLogList;
    }

    /**
     * ���� auditLogList
     * @param auditLogList auditLogList
     */
    public void setAuditLogList(List<AuditLog> auditLogList) {
        this.auditLogList = auditLogList;
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
