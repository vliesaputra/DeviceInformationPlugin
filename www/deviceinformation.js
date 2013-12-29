cordova.define("cordova/plugin/deviceinformation",
  function(require, exports, module) {
    var exec = require("cordova/exec");
    var DeviceInformation = function () {};

    var DeviceInformationError = function(code, message) {
        this.code = code || null;
        this.message = message || '';
    };

    DeviceInformation.NO_TELEPHONE_NUMBER = 0;

    DeviceInformation.prototype.get = function(success,fail) {
        exec(success,fail,"DeviceInformation",
            "get",[]);
    };

    var deviceInformation = new DeviceInformation();
    module.exports = deviceInformation;
});

if(!window.plugins) {
    window.plugins = {};
}
if (!window.plugins.deviceInformation) {
    window.plugins.deviceInformation = cordova.require("cordova/plugin/deviceinformation");
}
