package com.atex.plugins.timeline.bean;

import com.polopoly.cm.ContentId;

public interface TimelineContent {
    public void setAsset(ContentId asset);
    public void setName(String name);
    public void setLead(String lead);
    public void setPublishingDateTime(long publishingDate);
    public void setLinkPath(ContentId[] linkPath);
}
