package com.vliesaputra.cordova.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.telephony.TelephonyManager;

public class DeviceInformation extends CordovaPlugin {

    private String checkValue(String str) {
        if ((str == null) || (str.length() == 0)) {
            return "'TM.ERROR'";
        }

        return "'" + str + "'";
    }
    
    public DeviceInformation () {}
    
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if (action.equals("get")) {
                Context context = this.cordova.getActivity().getApplicationContext();
                TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                
                JSONObject r = new JSONObject();

                r.put("deviceID:", checkValue(tm.getDeviceId()));
                r.put("phoneNo:", checkValue(tm.getLine1Number()));
                r.put("netCountry:", checkValue(tm.getNetworkCountryIso()));
                r.put("netName:", checkValue(tm.getNetworkOperatorName()));
                r.put("simCountry:", checkValue(tm.getSimCountryIso()));
                r.put("simName:", checkValue(tm.getSimOperatorName()));

                callbackContext.success(r);
                return true;
            }
            callbackContext.error("Invalid action");
            return false;
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            callbackContext.error(e.getMessage());
            return false;
        }
    }
}
