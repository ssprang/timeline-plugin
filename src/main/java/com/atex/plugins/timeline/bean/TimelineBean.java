package com.atex.plugins.timeline.bean;

import org.apache.commons.lang.StringEscapeUtils;

import com.polopoly.cm.ContentId;

public class TimelineBean implements Timelineable, TimelineContent{
    private ContentId asset;
    private String name;
    private String lead;
    private long publishingDateTime;
    private ContentId[] linkPath;

    @Override
    public ContentId getAsset() {
        return asset;
    }
    @Override
    public void setAsset(ContentId asset) {
        this.asset = asset;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = StringEscapeUtils.escapeHtml(name);
    }
    @Override
    public String getLead() {
        return lead;
    }
    @Override
    public void setLead(String lead) {
        this.lead = StringEscapeUtils.escapeHtml(lead);
    }
    @Override
    public long getPublishingDateTime() {
        return publishingDateTime;
    }
    @Override
    public void setPublishingDateTime(long publishingDateTime) {
        this.publishingDateTime = publishingDateTime;
    }
    @Override
    public ContentId[] getLinkPath() {
        return linkPath;
    }
    @Override
    public void setLinkPath(ContentId[] linkPath) {
        this.linkPath = linkPath;
    }
}
