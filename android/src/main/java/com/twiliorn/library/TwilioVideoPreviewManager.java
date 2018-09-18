/**
 * Component for Twilio Video local views.
 * <p>
 * Authors:
 * Jonathan Chang <slycoder@gmail.com>
 */

package com.twiliorn.library;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;


public class TwilioVideoPreviewManager extends SimpleViewManager<TwilioVideoPreview> {

    public static final String REACT_CLASS = "RNTwilioVideoPreview";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected TwilioVideoPreview createViewInstance(ThemedReactContext reactContext) {
        return new TwilioVideoPreview(reactContext);
    }

    @ReactProp(name = "enabled")
    public void setEnabled(TwilioVideoPreview view, Boolean enabled) {
        view.setEnabled(enabled);
    }

    @ReactProp(name = "isTop")
    public void setIsTop(TwilioVideoPreview view, Boolean isTop) {
        view.setIsTop(isTop);
    }
}
