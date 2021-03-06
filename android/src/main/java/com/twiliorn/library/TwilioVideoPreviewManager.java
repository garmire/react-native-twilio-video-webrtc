/**
 * Component for Twilio Video local views.
 * <p>
 * Authors:
 * Jonathan Chang <slycoder@gmail.com>
 */

package com.twiliorn.library;

import androidx.annotation.Nullable;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;

import org.webrtc.RendererCommon;

import static com.twiliorn.library.RNVideoViewGroup.Events.ON_FRAME_DIMENSIONS_CHANGED;

public class TwilioVideoPreviewManager extends SimpleViewManager<TwilioVideoPreview> {

    public static final String REACT_CLASS = "RNTwilioVideoPreview";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(name = "scaleType")
    public void setScaleType(TwilioVideoPreview view, @Nullable String scaleType) {
      if (scaleType != null && scaleType.equals("fit")) {
        view.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FIT);
      } else {
        view.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FILL);
      }
    }

    @Override
    @Nullable
    public Map getExportedCustomDirectEventTypeConstants() {
        Map<String, Map<String, String>> map = MapBuilder.of(
                ON_FRAME_DIMENSIONS_CHANGED, MapBuilder.of("registrationName", ON_FRAME_DIMENSIONS_CHANGED)
        );

        return map;
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
