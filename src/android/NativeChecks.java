package com.willshawmedia.phonegap;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ApplicationInfo;
import android.content.SharedPreferences;

public class NativeChecks extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ( action.equals( "getAppVersion" ) ) {
            this.getAppVersion( callbackContext );
            return true;
        } else if ( action.equals( "checkFirstRun" ) ) {
            this.checkFirstRun( callbackContext );
            return true;
        } else if ( action.equals( "checkDebug" ) ) {
            this.checkDebug( callbackContext );
            return true;
        } else if ( action.equals( "checkAdhoc" ) ) {
            this.checkDebug( callbackContext );
            return true;
        }
        return false;
    }

    private void getAppVersion( CallbackContext callbackContext ) {
        try {
            PackageManager packageManager = this.cordova.getActivity().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                                        this.cordova.getActivity().getPackageName(),
                                        0
                                    );

            callbackContext.success( packageInfo.versionCode );
        } catch ( Exception e ) {
            callbackContext.error( e.getMessage() );
        }
    }

    private void checkFirstRun( CallbackContext callbackContext ) {
        try {
            SharedPreferences prefs = this.cordova.getActivity().getSharedPreferences(
                                        "com.willshawmedia.PluginCheck", 
                                        0
                                    );

            String first_run = "0";

            // if app has run, return false
            if ( prefs.getBoolean( "first_time", true ) ) {
                first_run = "1";
                prefs.edit().putBoolean( "first_time", false ).commit();
            }

            callbackContext.success( first_run );
        } catch ( Exception e ) {
            callbackContext.error( e.getMessage() );
        }
    }

    private void checkDebug( CallbackContext callbackContext ) {
        try {            
            PackageManager packageManager = this.cordova.getActivity().getPackageManager();
            String debug_value;
            ApplicationInfo appInfo = packageManager.getApplicationInfo(
                                                        this.cordova.getActivity().getPackageName(), 
                                                        PackageManager.GET_META_DATA
                                                    );
            
            if ( ( appInfo.flags & ApplicationInfo.FLAG_DEBUGGABLE ) != 0 ) {
                debug_value = "1";
            } else {
                debug_value = "0";
            }

            callbackContext.success( debug_value );
        } catch ( Exception e ) {
            // callbackContext.error( e.getMessage() + " : " + e.getCause() );
            callbackContext.error( "An error has become the application" );
        }
    }

    private void checkAdhoc( CallbackContext callbackContext ) {
        try {            
            PackageManager packageManager = this.cordova.getActivity().getPackageManager();
            String adhoc_value;
            String installer = packageManager.getInstallerPackageName( "com.willshawmedia.pluginCheck" );
            
            if ( installer == null ) {
                adhoc_value = "1";
            } else {
                adhoc_value = "0";
            }

            callbackContext.success( adhoc_value );
        } catch ( Exception e ) {
            // callbackContext.error( e.getMessage() + " : " + e.getCause() );
            callbackContext.error( "An error has become the application" );
        }
    }
}
