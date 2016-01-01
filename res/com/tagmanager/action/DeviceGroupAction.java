/*
 * @(#)DeviceGroupAction.java 2015-4-4 下午02:45:11 erp-manufacture
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

import com.erp.model.DeviceGroup;

/**
 * DeviceGroupAction
 * @author wang
 * @version 1.0
 *
 */
@Component("deviceGroupAction")
@Scope("prototype")
public class DeviceGroupAction extends BaseAction {
    
    public static final String UPLOAD_PATH = "/upload/deviceGroup";
    
    private DeviceGroup deviceGroup;

    private List<DeviceGroup> deviceGroupList;
    
    private File file;

    private String fileFileName;

    private String fileContentType;
    
    private String content;
    
    public String listDeviceGroup() {
        deviceGroupList = deviceGroupService.list();
        return SUCCESS;
    }

    public String saveDeviceGroup() {
        deviceGroup.setDate(new Date());
        deviceGroup.setUser(loginUser);
        deviceGroupService.saveOrUpdate(deviceGroup);
        msg = "success";
        return SUCCESS;
    }

    public String destoryDeviceGroup() {
        deviceGroup = deviceGroupService.getEntityById(deviceGroup.getId());
        deviceGroupService.delete(deviceGroup);
        return SUCCESS;
    }

    public String listDeviceGroupDetail() {
        deviceGroup = deviceGroupService.getEntityById(deviceGroup.getId());
        return SUCCESS;
    }
    
    public String submitContent(){
        deviceGroup = deviceGroupService.getEntityById(deviceGroup.getId());
        deviceGroup.setContent(content);
        if (file != null) {
            deviceGroup.setFileName(fileFileName);
            String realpath = ServletActionContext.getServletContext()
                    .getRealPath(UPLOAD_PATH);
            String uuid = UUID.randomUUID().toString();
            deviceGroup.setRealFileName(uuid);
            File newFile = new File(realpath, uuid);
            try {
                FileUtils.copyFile(file, newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        deviceGroupService.saveOrUpdate(deviceGroup);
        return SUCCESS;
    }

    public String download() {
        deviceGroup = deviceGroupService.getEntityById(deviceGroup.getId());
        file = new File(ServletActionContext.getServletContext().getRealPath(
            UPLOAD_PATH), String.valueOf(deviceGroup.getRealFileName()));
        try {
            fileFileName = new String(deviceGroup.getFileName().getBytes(),
                    "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 返回  deviceGroup
     * @return deviceGroup
     */
    public DeviceGroup getDeviceGroup() {
        return deviceGroup;
    }

    /**
     * 设置 deviceGroup
     * @param deviceGroup deviceGroup
     */
    public void setDeviceGroup(DeviceGroup deviceGroup) {
        this.deviceGroup = deviceGroup;
    }

    /**
     * 返回  deviceGroupList
     * @return deviceGroupList
     */
    public List<DeviceGroup> getDeviceGroupList() {
        return deviceGroupList;
    }

    /**
     * 设置 deviceGroupList
     * @param deviceGroupList deviceGroupList
     */
    public void setDeviceGroupList(List<DeviceGroup> deviceGroupList) {
        this.deviceGroupList = deviceGroupList;
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
