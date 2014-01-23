package com.atex.plugins.timeline;

import java.util.Locale;

import com.polopoly.cm.client.CMException;
import com.polopoly.model.DescribesModelType;

@DescribesModelType
public interface Timelineable {
    public boolean isTimelineRepresentable = true;

    // TODO: Get image here?
    public TimelineAsset getAsset();

    public String getName() throws CMException;
    
    public String getLead() throws CMException;

    public long getPublishingDateTime() throws CMException;

    //TODO: Remove this
    public Locale getDefaultLocale();
}
