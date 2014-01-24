package com.atex.plugins.timeline.bean;

import com.polopoly.cm.ContentId;
import com.polopoly.model.DescribesModelType;

@DescribesModelType
public interface Timelineable {
    public ContentId getAsset();
    public String getName();
    public String getLead();
    public long getPublishingDateTime();
    public ContentId[] getLinkPath();
}
