package com.atex.plugins.timeline;

import com.polopoly.render.CacheInfo;
import com.polopoly.render.RenderException;
import com.polopoly.render.RenderRequest;
import com.polopoly.render.RenderResponse;
import com.polopoly.siteengine.dispatcher.ControllerContext;
import com.polopoly.siteengine.model.TopModel;
import com.polopoly.siteengine.mvc.Renderer;

public class RendererForJSONContent implements Renderer {

    private final Renderer defaultRenderer;

    public RendererForJSONContent(Renderer defaultRenderer)
    {
        this.defaultRenderer = defaultRenderer;
    }

    public void render(TopModel m, RenderRequest req, RenderResponse resp, CacheInfo cacheInfo,
            ControllerContext context) throws RenderException
    {
        resp.setContentType("application/json; charset=UTF-8");
        defaultRenderer.render(m, req, resp, cacheInfo, context);
    }

}