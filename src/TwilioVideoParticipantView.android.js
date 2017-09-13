/**
 * Component for Twilio Video participant views.
 *
 * Authors:
 *   Jonathan Chang <slycoder@gmail.com>
 */

import {
  requireNativeComponent,
  View
} from 'react-native'
import React from 'react'
import PropTypes from 'prop-types'

const propTypes = {
  ...View.propTypes,
  trackIdentifier: PropTypes.shape({
    /**
     * The participant identifier.
     */
    participantIdentity: PropTypes.string.isRequired,
    /**
     * The participant's video track you want to render in the view.
     */
    videoTrackId: PropTypes.string.isRequired,
    /**
     * Indicate if video feed is enabled.
     */
    enabled: PropTypes.bool.isRequired,
  }),
  isTop: PropTypes.bool,
}

class TwilioRemotePreview extends React.Component {
  componentWillUnmount() {
    this.refs.remoteVideoView.setNativeProps({
      trackIdentifier: {
        participantIdentity: this.props.trackIdentifier.participantIdentity,
        videoTrackId: this.props.trackIdentifier.videoTrackId,
        enabled: false,
      }
    });
  }

  render () {
    return (
      <NativeTwilioRemotePreview ref='remoteVideoView' {...this.props} />
    )
  }
}

TwilioRemotePreview.propTypes = propTypes

const NativeTwilioRemotePreview = requireNativeComponent(
  'RNTwilioRemotePreview',
  TwilioRemotePreview
)

module.exports = TwilioRemotePreview
