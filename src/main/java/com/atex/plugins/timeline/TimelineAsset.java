package com.atex.plugins.timeline;

import javax.servlet.http.HttpServletRequest;

/**
 * Represents a timeline asset
 * "media":"http://twitter.com/ArjunaSoriano/status/164181156147900416",
 * "thumbnail":"optional-32x32px.jpg",
 * "credit":"Credit Name Goes Here",
 * "caption":"Caption text goes here"
 * @author sarasprang
 *
 */
public interface TimelineAsset {
    public String getMediaURL(HttpServletRequest request);
    public String getThumbnailURL(HttpServletRequest request);
    public String getCredit();
    public String getCaption();
}
