/**
 * Component for Twilio Video local views.
 * <p>
 * Authors:
 * Jonathan Chang <slycoder@gmail.com>
 */

package com.twiliorn.library;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;

public class TwilioVideoPreview extends RNVideoViewGroup {

    private static final String TAG = "TwilioVideoPreview";

    public TwilioVideoPreview(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.getSurfaceViewRenderer().setMirror(true);
        // CustomTwilioVideoView.registerThumbnailVideoView(this.getSurfaceViewRenderer());
        // this.getSurfaceViewRenderer().applyZOrder(true);
    }

    public void setEnabled(Boolean enabled) {
        if (enabled) {
            CustomTwilioVideoView.registerThumbnailVideoView(this.getSurfaceViewRenderer());
        } else {
            CustomTwilioVideoView.removeThumbnailVideoView(this.getSurfaceViewRenderer());
        }
    }
}
