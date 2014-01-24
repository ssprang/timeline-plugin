package com.atex.plugins.timeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.atex.plugins.baseline.policy.BaselinePolicy;
import com.atex.plugins.timeline.bean.Timelineable;
import com.polopoly.cm.ContentId;
import com.polopoly.cm.client.CMException;
import com.polopoly.cm.collections.ContentList;
import com.polopoly.cm.collections.ContentListProvider;
import com.polopoly.data.DataApi;
import com.polopoly.data.exception.CustomModelException;
import com.polopoly.model.DescribesModelType;
import com.polopoly.model.Model;
import com.polopoly.model.PojoAsModel;

@DescribesModelType
public class FeedPolicy extends BaselinePolicy {

    private static final Logger LOG = Logger.getLogger(FeedPolicy.class.getName());
    private static final String TIMELINE_VARIANT = "com.atex.plugins.timeline.bean.Timelineable";
    private DataApi dataApi;

    public FeedPolicy(DataApi dataApi) {
        this.dataApi = dataApi;
    }

    public List<Timelineable> getFeedables() {
        List<Timelineable> toReturn = new ArrayList<Timelineable>();
        ContentList queues = null;
        try {
            queues = getContentList("sources");
        } catch (CMException e) {
            LOG.log(Level.WARNING, "Unable to fetch PQs in feed", e);
        }
        if (queues == null || queues.size() < 1) {
            return toReturn;
        }
        for (int i = 0; i < queues.size(); i++) {
            try {
                ContentListProvider queue = (ContentListProvider) getCMServer().getPolicy(
                        queues.getEntry(i).getReferredContentId());
                ContentList queueList = queue.getContentList();
                for (int j = 0; j < queueList.size(); j++) {
                    ContentId lookUp = queueList.getEntry(j).getReferredContentId();
                    try {
                        Model teaserableModel = dataApi.get(lookUp, TIMELINE_VARIANT);
                        Timelineable toAdd = (Timelineable) PojoAsModel.unwrapModel(teaserableModel);
                        toReturn.add(toAdd);
                    } catch (CustomModelException e) {
                        LOG.log(Level.INFO, "Encountered id " + lookUp.getContentIdString() 
                                + " not mappable to " + TIMELINE_VARIANT);
                    }
                }
            } catch (CMException e) {
                LOG.log(Level.WARNING, "Unable to fetch data from PQ", e);
            }
        }

        return toReturn;
    }

    public Locale getLocale() {
        return new Locale("en_US");
    }
}
