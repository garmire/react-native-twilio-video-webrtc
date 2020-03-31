//
//  TwilioVideoLocalView.js
//  Black
//
//  Created by Martín Fernández on 6/13/17.
//
//

import React, { Component } from 'react'
import PropTypes from 'prop-types'
import { requireNativeComponent } from 'react-native'

class TwilioVideoLocalView extends Component {
  static propTypes = {
    /**
     * Indicate if video feed is enabled.
     */
    enabled: PropTypes.bool.isRequired
  }

  localVideoView = React.createRef();

  componentWillUnmount() {
    this.localVideoView.current.setNativeProps({
      enabled: false,
    });
  }

  render () {
    let scalesType = this.props.scaleType === 'fit' ? 1 : 2
    return <RCTTWLocalVideoView ref={this.localVideoView} scalesType={scalesType} {...this.props}>{this.props.children}</RCTTWLocalVideoView>
  }
}

const RCTTWLocalVideoView = requireNativeComponent('RCTTWLocalVideoView', TwilioVideoLocalView)

module.exports = TwilioVideoLocalView
