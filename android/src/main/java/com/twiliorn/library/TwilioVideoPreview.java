/**
 * Component for Twilio Video local views.
 *
 * Authors:
 *   Jonathan Chang <slycoder@gmail.com>
 */

package com.twiliorn.library;

import android.content.Context;


public class TwilioVideoPreview extends RNVideoViewGroup {

    private static final String TAG = "TwilioVideoPreview";

    public TwilioVideoPreview(Context context) {
        super(context);
        this.getSurfaceViewRenderer().setMirror(true);
    }

    public void setEnabled(Boolean enabled) {
        if (enabled) {
            CustomTwilioVideoView.registerThumbnailVideoView(this.getSurfaceViewRenderer());
        } else {
            CustomTwilioVideoView.removeThumbnailVideoView(this.getSurfaceViewRenderer());
        }
    }
}
