/*
 * @(#)DetectorAction.java 2015-4-4 ����02:45:11 erp-manufacture
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

import com.erp.model.Detector;

/**
 * DetectorAction
 * @author wang
 * @version 1.0
 *
 */
@Component("detectorAction")
@Scope("prototype")
public class DetectorAction extends BaseAction {
    
    public static final String UPLOAD_PATH = "/upload/detector";
    
    private Detector detector;

    private List<Detector> detectorList;
    
    private File file;

    private String fileFileName;

    private String fileContentType;
    
    private String content;
    
    public String listDetector() {
        detectorList = detectorService.list();
        return SUCCESS;
    }

    public String saveDetector() {
        detector.setDate(new Date());
        detector.setUser(loginUser);
        detectorService.saveOrUpdate(detector);
        msg = "success";
        return SUCCESS;
    }

    public String destoryDetector() {
        detector = detectorService.getEntityById(detector.getId());
        detectorService.delete(detector);
        return SUCCESS;
    }

    public String listDetectorDetail() {
        detector = detectorService.getEntityById(detector.getId());
        return SUCCESS;
    }
    
    public String submitContent(){
        detector = detectorService.getEntityById(detector.getId());
        detector.setContent(content);
        if (file != null) {
            detector.setFileName(fileFileName);
            String realpath = ServletActionContext.getServletContext()
                    .getRealPath(UPLOAD_PATH);
            String uuid = UUID.randomUUID().toString();
            detector.setRealFileName(uuid);
            File newFile = new File(realpath, uuid);
            try {
                FileUtils.copyFile(file, newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        detectorService.saveOrUpdate(detector);
        return SUCCESS;
    }

    public String download() {
        detector = detectorService.getEntityById(detector.getId());
        file = new File(ServletActionContext.getServletContext().getRealPath(
            UPLOAD_PATH), String.valueOf(detector.getRealFileName()));
        try {
            fileFileName = new String(detector.getFileName().getBytes(),
                    "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * ����  detector
     * @return detector
     */
    public Detector getDetector() {
        return detector;
    }

    /**
     * ���� detector
     * @param detector detector
     */
    public void setDetector(Detector detector) {
        this.detector = detector;
    }

    /**
     * ����  detectorList
     * @return detectorList
     */
    public List<Detector> getDetectorList() {
        return detectorList;
    }

    /**
     * ���� detectorList
     * @param detectorList detectorList
     */
    public void setDetectorList(List<Detector> detectorList) {
        this.detectorList = detectorList;
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
