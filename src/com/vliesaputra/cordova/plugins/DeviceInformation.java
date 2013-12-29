package com.vliesaputra.cordova.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.telephony.TelephonyManager;

public class DeviceInformation extends CordovaPlugin {

    private String checkValue (String str) {
        if ((str == null) || (str.length() == 0)) {
            return "'TM.ERROR'";
        }
        
        return "'" + str + "'";
    }
    
    private String getDetails (TelephonyManager tm) {
        if (tm == null) {
            return null;
        }
        
        String str = "{" +
                        "deviceID:" + checkValue(tm.getDeviceId()) + "," +
                        "phoneNo:" + checkValue(tm.getLine1Number()) + "," +
                        "netCountry:" + checkValue(tm.getNetworkCountryIso()) + "," +
                        "netName:" + checkValue(tm.getNetworkOperatorName()) + "," +
                        "simCountry:" + checkValue(tm.getSimCountryIso()) + "," +
                        "simName:" + checkValue(tm.getSimOperatorName()) +
                    "}";
        return str;
    }
    
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("get")) {
            TelephonyManager tm =
                (TelephonyManager)this.cordova.getActivity().getSystemService(Context.TELEPHONY_SERVICE);
            String result = getDetails(tm);
            if (result != null) {
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, result));
                return true;
            }
        }
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR));
        return false;
    }
}
