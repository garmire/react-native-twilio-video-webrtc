/**
 * Component for Twilio Video participant views.
 * <p>
 * Authors:
 * Jonathan Chang <slycoder@gmail.com>
 */

package com.twiliorn.library;

import android.content.Context;
import android.util.Log;


import com.facebook.react.bridge.ReadableMap;

public class TwilioRemotePreview extends RNVideoViewGroup {

    private static final String TAG = "TwilioRemotePreview";

    public TwilioRemotePreview(Context context) {
        super(context);
    }

    public void setTrackIdentifier(ReadableMap trackIdentifier) {
        String participantSid = trackIdentifier.getString("participantSid");
        String videoTrackSid = trackIdentifier.getString("videoTrackSid");
        Boolean enabled = trackIdentifier.getBoolean("enabled");

        if (enabled) {
            CustomTwilioVideoView.registerRemoteVideoView(this.getSurfaceViewRenderer(), participantSid, videoTrackSid);
        } else {
            CustomTwilioVideoView.removeRemoteVideoView(this.getSurfaceViewRenderer(), participantSid, videoTrackSid);
        }
    }
}
