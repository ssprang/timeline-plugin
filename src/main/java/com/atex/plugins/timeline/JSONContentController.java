package com.atex.plugins.timeline;

import com.polopoly.render.RenderRequest;
import com.polopoly.siteengine.dispatcher.ControllerContext;
import com.polopoly.siteengine.model.TopModel;
import com.polopoly.siteengine.mvc.RenderControllerBase;
import com.polopoly.siteengine.mvc.Renderer;

public class JSONContentController extends RenderControllerBase {

    public Renderer getRenderer(RenderRequest request, TopModel m, Renderer defaultRenderer, ControllerContext context) {
        return new RendererForJSONContent(defaultRenderer);
    }

}
