var DeviceinformationLoader = function (require, exports, module) {
    var exec = require("cordova/exec");
    
    function Deviceinformation () {};
        
    Deviceinformation.prototype.get = function (successFunc, failFunc) {
        exec(successFunc, failFunc, "Deviceinformation","get",[]);
    };
    
    var deviceinformation = new DeviceInformation();
    module.exports = deviceinformation;
};

DeviceinformationLoader(require, exports, module);

cordova.define("cordova/plugin/Deviceinformation", DeviceinformationLoader);



