/**
 * Component for Twilio Video participant views.
 * <p>
 * Authors:
 * Jonathan Chang <slycoder@gmail.com>
 */

package com.twiliorn.library;

import androidx.annotation.Nullable;
import android.util.Log;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.bridge.ReadableMap;

import org.webrtc.RendererCommon;


public class TwilioRemotePreviewManager extends SimpleViewManager<TwilioRemotePreview> {

    public static final String REACT_CLASS = "RNTwilioRemotePreview";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(name = "scaleType")
    public void setScaleType(TwilioRemotePreview view, @Nullable String scaleType) {

      if (scaleType != null && scaleType.equals("fit")) {
        view.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FIT);
      } else {
        view.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FILL);
      }
    }

    // @ReactProp(name = "trackSid")
    // public void setTrackId(TwilioRemotePreview view, @Nullable String trackSid) {
    //
    //     Log.i("CustomTwilioVideoView", "Initialize Twilio REMOTE");
    //     Log.i("CustomTwilioVideoView", trackSid);
    //     CustomTwilioVideoView.registerPrimaryVideoView(view.getSurfaceViewRenderer(), trackSid);
    // }

    @Override
    protected TwilioRemotePreview createViewInstance(ThemedReactContext reactContext) {
        return new TwilioRemotePreview(reactContext);
    }

    @ReactProp(name = "trackIdentifier")
    public void setTrackIdentifier(TwilioRemotePreview view, ReadableMap trackIdentifier) {
        view.setTrackIdentifier(trackIdentifier);
    }

    @ReactProp(name = "isTop")
    public void setIsTop(TwilioRemotePreview view, Boolean isTop) {
        view.setIsTop(isTop);
    }
}
