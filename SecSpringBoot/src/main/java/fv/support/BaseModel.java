package fv.support;

import java.io.Serializable;
import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;

public class BaseModel implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final int STATUS_DELETED = 0;
    public static final int STATUS_NORMAL = 1;
    @Field
    protected String id;
    protected Integer startRow;
    protected Integer pageSize;
    protected Integer expired;
    protected Date creationTime;
    protected String createdBy;
    protected String creator;
    protected Date lastUpdateTime;
    protected String lastUpdateBy;
    protected String lastUpdator;

    protected String fuzzySearchText;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getExpired() {
        return expired;
    }

    public void setExpired(Integer expired) {
        this.expired = expired;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public String getLastUpdator() {
        return lastUpdator;
    }

    public void setLastUpdator(String lastUpdator) {
        this.lastUpdator = lastUpdator;
    }

    public String getFuzzySearchText() {
        return fuzzySearchText;
    }

    public void setFuzzySearchText(String fuzzySearchText) {
        this.fuzzySearchText = fuzzySearchText;
    }
}
