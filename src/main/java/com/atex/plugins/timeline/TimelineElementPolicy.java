package com.atex.plugins.timeline;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.atex.plugins.baseline.policy.BaselinePolicy;
import com.polopoly.cm.app.policy.SelectableSubFieldPolicy;
import com.polopoly.cm.client.CMException;
import com.polopoly.model.DescribesModelType;
@DescribesModelType
public class TimelineElementPolicy extends BaselinePolicy {

    private static final Logger LOG = Logger.getLogger(TimelineElementPolicy.class.getName());
    public boolean isUrlBased() {
        try {
            SelectableSubFieldPolicy videoSourceSelect = (SelectableSubFieldPolicy) getChildPolicy("source");
            return ("url".equalsIgnoreCase(videoSourceSelect.getSelectedSubFieldName()));
        } catch (CMException e) {
            LOG.log(Level.WARNING, "Unable to fetch source of timeline feed");
        }
        return true;
    }
}