/**
 * Component for Twilio Video participant views.
 *
 * Authors:
 *   Jonathan Chang <slycoder@gmail.com>
 */

package com.twiliorn.library;

import android.content.Context;

import com.facebook.react.bridge.ReadableMap;

public class TwilioRemotePreview extends RNVideoViewGroup {

    private static final String TAG = "TwilioRemotePreview";

    public TwilioRemotePreview(Context context) {
        super(context);
    }

    public void setTrackIdentifier(ReadableMap trackIdentifier) {
        String participantIdentity = trackIdentifier.getString("participantIdentity");
        Boolean enabled = trackIdentifier.getBoolean("enabled");

        if (enabled) {
            CustomTwilioVideoView.registerRemoteVideoView(this.getSurfaceViewRenderer(), participantIdentity);
        } else {
            CustomTwilioVideoView.removeRemoteVideoView(this.getSurfaceViewRenderer());
        }
    }
}
