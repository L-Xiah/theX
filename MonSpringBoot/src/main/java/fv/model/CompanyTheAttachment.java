package fv.model;


import fv.support.BaseModel;

/**
 * 
 */
public class CompanyTheAttachment extends BaseModel {
    private String dataTableId;//数据表ID
    private String dataTableType;//数据表种类
    private String attachmentName;//附件名称
    private String attachmentType;//附件类型


    //外表（或辅助）字段
    private String createdByName;//创建人name
    private String attachmentTypeName;//附件类型

    public String getDataTableId() {
        return dataTableId;
    }

    public void setDataTableId(String dataTableId) {
        this.dataTableId = dataTableId;
    }

    public String getDataTableType() {
        return dataTableType;
    }

    public void setDataTableType(String dataTableType) {
        this.dataTableType = dataTableType;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public String getAttachmentTypeName() {
        return attachmentTypeName;
    }

    public void setAttachmentTypeName(String attachmentTypeName) {
        this.attachmentTypeName = attachmentTypeName;
    }


}