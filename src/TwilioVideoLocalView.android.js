/**
 * Component for Twilio Video local views.
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
  /**
   * Indicate if video feed is enabled.
   */
  enabled: PropTypes.bool.isRequired,
  isTop: PropTypes.bool,
}

class TwilioVideoPreview extends React.Component {

  localVideoView = React.createRef();

  componentWillUnmount() {
    this.localVideoView.current.setNativeProps({
      enabled: false,
    });
  }

  render () {
    return (
      <NativeTwilioVideoPreview ref={this.localVideoView} {...this.props} />
    )
  }
}

TwilioVideoPreview.propTypes = propTypes

const NativeTwilioVideoPreview = requireNativeComponent(
  'RNTwilioVideoPreview',
  TwilioVideoPreview
)

module.exports = TwilioVideoPreview
