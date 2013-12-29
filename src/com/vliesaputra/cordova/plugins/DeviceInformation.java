/*************************************************************************
 * 
 * TBS CONFIDENTIAL
 * __________________
 * 
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of Total Brand Security (TBS) Incorporated and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Total Brand Security (TBS) Incorporated
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Total Brand Security (TBS) Incorporated.
 *
 * @author Veronica Liesaputra (2013)
 */

package com.vliesaputra.cordova.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;

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
    
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
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
