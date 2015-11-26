/**
 * @providesModule NetInfoModule
 */

"use strict";

var { NativeModules } = require("react-native");
var nia = NativeModules.NetInfoAndroid;

var NetInfoAndroid = {
  getNetworkType(callback) {
    return nia.networkType(callback);
  }
};

module.exports = NetInfoAndroid;
