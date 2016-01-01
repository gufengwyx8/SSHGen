/*
 * @(#)DeviceAction.java 2015-4-4 ����02:45:11 erp-manufacture
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

import com.erp.model.Device;

/**
 * DeviceAction
 * @author wang
 * @version 1.0
 *
 */
@Component("deviceAction")
@Scope("prototype")
public class DeviceAction extends BaseAction {
    
    public static final String UPLOAD_PATH = "/upload/device";
    
    private Device device;

    private List<Device> deviceList;
    
    private File file;

    private String fileFileName;

    private String fileContentType;
    
    private String content;
    
    public String listDevice() {
        deviceList = deviceService.list();
        return SUCCESS;
    }

    public String saveDevice() {
        device.setDate(new Date());
        device.setUser(loginUser);
        deviceService.saveOrUpdate(device);
        msg = "success";
        return SUCCESS;
    }

    public String destoryDevice() {
        device = deviceService.getEntityById(device.getId());
        deviceService.delete(device);
        return SUCCESS;
    }

    public String listDeviceDetail() {
        device = deviceService.getEntityById(device.getId());
        return SUCCESS;
    }
    
    public String submitContent(){
        device = deviceService.getEntityById(device.getId());
        device.setContent(content);
        if (file != null) {
            device.setFileName(fileFileName);
            String realpath = ServletActionContext.getServletContext()
                    .getRealPath(UPLOAD_PATH);
            String uuid = UUID.randomUUID().toString();
            device.setRealFileName(uuid);
            File newFile = new File(realpath, uuid);
            try {
                FileUtils.copyFile(file, newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        deviceService.saveOrUpdate(device);
        return SUCCESS;
    }

    public String download() {
        device = deviceService.getEntityById(device.getId());
        file = new File(ServletActionContext.getServletContext().getRealPath(
            UPLOAD_PATH), String.valueOf(device.getRealFileName()));
        try {
            fileFileName = new String(device.getFileName().getBytes(),
                    "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * ����  device
     * @return device
     */
    public Device getDevice() {
        return device;
    }

    /**
     * ���� device
     * @param device device
     */
    public void setDevice(Device device) {
        this.device = device;
    }

    /**
     * ����  deviceList
     * @return deviceList
     */
    public List<Device> getDeviceList() {
        return deviceList;
    }

    /**
     * ���� deviceList
     * @param deviceList deviceList
     */
    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
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
