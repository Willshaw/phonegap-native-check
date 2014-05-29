package com.willshawmedia.phonegap;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
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
            if ( !prefs.getBoolean( "has_run", false ) ) {
                first_run = "1";
                prefs.edit().putBoolean( "has_run", true ).commit();
            }

            callbackContext.success( first_run );
        } catch ( Exception e ) {
            callbackContext.error( e.getMessage() );
        }
    }
}

//     // private void checkDebug:(NSMutableArray *)arguments withDict:(NSMutableDictionary *)options {
//     //     NSString* callbackId = [arguments objectAtIndex:0];
        
//     //     CDVPluginResult* pluginResult = nil;
//     //     NSString* javaScript = nil;
        
//     //     @try {
            
//     //         NSString *isDebug = @"0";
//     //         #ifdef DEBUG
//     //             isDebug = @"1";
//     //         #endif
            
//     //         pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:isDebug];
//     //         javaScript = [pluginResult toSuccessCallbackString:callbackId];
//     //     } @catch (NSException* exception) {
//     //         // could not get locale
//     //         pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_JSON_EXCEPTION messageAsString:[exception reason]];
//     //         javaScript = [pluginResult toErrorCallbackString:callbackId];
//     //     }
//     //     [self writeJavascript:javaScript];
//     // }

//     // private void checkAdhoc:(NSMutableArray *)arguments withDict:(NSMutableDictionary *)options {
//     //     NSString* callbackId = [arguments objectAtIndex:0];
        
//     //     CDVPluginResult* pluginResult = nil;
//     //     NSString* javaScript = nil;
        
//     //     @try {
            
//     //         NSString *isAdhoc = @"0";
//     // #ifdef ADHOC
//     //         isAdhoc = @"1";
//     // #endif
            
//     //         pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:isAdhoc];
//     //         javaScript = [pluginResult toSuccessCallbackString:callbackId];
//     //     } @catch (NSException* exception) {
//     //         // could not get locale
//     //         pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_JSON_EXCEPTION messageAsString:[exception reason]];
//     //         javaScript = [pluginResult toErrorCallbackString:callbackId];
//     //     }
//     //     [self writeJavascript:javaScript];
//     // }

//     // private void registerPush:(NSMutableArray *)arguments withDict:(NSMutableDictionary *)options {
//     //     // Register for push notifications, only if an event has been subscribed to
//     //     [
//     //      [UIApplication sharedApplication] registerForRemoteNotificationTypes:
//     //         UIRemoteNotificationTypeBadge |
//     //         UIRemoteNotificationTypeAlert |
//     //         UIRemoteNotificationTypeSound
//     //      ];
//     // }
