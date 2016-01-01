/*
 * @(#)${Upper}Action.java 2015-4-4 下午02:45:11 erp-manufacture
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

import com.erp.model.${Upper};

/**
 * ${Upper}Action
 * @author wang
 * @version 1.0
 *
 */
@Component("${Lower}Action")
@Scope("prototype")
public class ${Upper}Action extends BaseAction {
    
    public static final String UPLOAD_PATH = "/upload/${Lower}";
    
    private ${Upper} ${Lower};

    private List<${Upper}> ${Lower}List;
    
    private File file;

    private String fileFileName;

    private String fileContentType;
    
    private String content;
    
    public String list${Upper}() {
        ${Lower}List = ${Lower}Service.list();
        return SUCCESS;
    }

    public String save${Upper}() {
        ${Lower}.setDate(new Date());
        ${Lower}.setUser(loginUser);
        ${Lower}Service.saveOrUpdate(${Lower});
        msg = "success";
        return SUCCESS;
    }

    public String destory${Upper}() {
        ${Lower} = ${Lower}Service.getEntityById(${Lower}.getId());
        ${Lower}Service.delete(${Lower});
        return SUCCESS;
    }

    public String list${Upper}Detail() {
        ${Lower} = ${Lower}Service.getEntityById(${Lower}.getId());
        return SUCCESS;
    }
    
    public String submitContent(){
        ${Lower} = ${Lower}Service.getEntityById(${Lower}.getId());
        ${Lower}.setContent(content);
        if (file != null) {
            ${Lower}.setFileName(fileFileName);
            String realpath = ServletActionContext.getServletContext()
                    .getRealPath(UPLOAD_PATH);
            String uuid = UUID.randomUUID().toString();
            ${Lower}.setRealFileName(uuid);
            File newFile = new File(realpath, uuid);
            try {
                FileUtils.copyFile(file, newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ${Lower}Service.saveOrUpdate(${Lower});
        return SUCCESS;
    }

    public String download() {
        ${Lower} = ${Lower}Service.getEntityById(${Lower}.getId());
        file = new File(ServletActionContext.getServletContext().getRealPath(
            UPLOAD_PATH), String.valueOf(${Lower}.getRealFileName()));
        try {
            fileFileName = new String(${Lower}.getFileName().getBytes(),
                    "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 返回  ${Lower}
     * @return ${Lower}
     */
    public ${Upper} get${Upper}() {
        return ${Lower};
    }

    /**
     * 设置 ${Lower}
     * @param ${Lower} ${Lower}
     */
    public void set${Upper}(${Upper} ${Lower}) {
        this.${Lower} = ${Lower};
    }

    /**
     * 返回  ${Lower}List
     * @return ${Lower}List
     */
    public List<${Upper}> get${Upper}List() {
        return ${Lower}List;
    }

    /**
     * 设置 ${Lower}List
     * @param ${Lower}List ${Lower}List
     */
    public void set${Upper}List(List<${Upper}> ${Lower}List) {
        this.${Lower}List = ${Lower}List;
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
