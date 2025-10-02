package com.example.openurl;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class OpenUrlPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("openUrl".equals(action)) {
            String url = args.getString(0);
            this.openUrl(url, callbackContext);
            return true;
        }
        return false;
    }

    private void openUrl(String url, CallbackContext callbackContext) {
        try {
            if (url != null && url.length() > 0) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                cordova.getActivity().startActivity(intent);
                callbackContext.success("URL deschis cu succes: " + url);
            } else {
                callbackContext.error("URL invalid sau gol");
            }
        } catch (Exception e) {
            callbackContext.error("Eroare la deschiderea URL-ului: " + e.getMessage());
        }
    }
}
