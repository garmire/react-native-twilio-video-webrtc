/**
 * Component for Twilio Video participant views.
 *
 * Authors:
 *   Jonathan Chang <slycoder@gmail.com>
 */

import { requireNativeComponent } from 'react-native'
import PropTypes from 'prop-types'
import React from 'react'

class TwilioRemotePreview extends React.Component {
  static propTypes = {
    trackIdentifier: PropTypes.shape({
      /**
       * The participant identifier.
       */
      participantSid: PropTypes.string.isRequired,
      /**
       * The participant's video track you want to render in the view.
       */
      videoTrackSid: PropTypes.string.isRequired,
      /**
       * Indicate if video feed is enabled.
       */
      enabled: PropTypes.bool.isRequired,
    }),
    isTop: PropTypes.bool,
    trackSid: PropTypes.string,
    renderToHardwareTextureAndroid: PropTypes.string,
    onLayout: PropTypes.string,
    accessibilityLiveRegion: PropTypes.string,
    accessibilityComponentType: PropTypes.string,
    importantForAccessibility: PropTypes.string,
    accessibilityLabel: PropTypes.string,
    nativeID: PropTypes.string,
    testID: PropTypes.string
  }

  remoteVideoView = React.createRef();

  componentWillUnmount() {
    this.remoteVideoView.current.setNativeProps({
      trackIdentifier: {
        participantSid: this.props.trackIdentifier.participantSid,
        videoTrackSid: this.props.trackIdentifier.videoTrackSid,
        enabled: false,
      }
    });
  }

  render () {
    const { trackIdentifier } = this.props
    return <NativeTwilioRemotePreview ref={this.remoteVideoView} trackSid={trackIdentifier && trackIdentifier.videoTrackSid} {...this.props} />
  }
}

const NativeTwilioRemotePreview = requireNativeComponent(
  'RNTwilioRemotePreview',
  TwilioRemotePreview
)

module.exports = TwilioRemotePreview
