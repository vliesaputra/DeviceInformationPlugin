var deviceinformation = {
    get : function (successFunc, failFunc) {
        cordova.exec(successFunc, failFunc, 
                     "Deviceinformation","get",[]);
    }
};
module.exports = deviceinformation;