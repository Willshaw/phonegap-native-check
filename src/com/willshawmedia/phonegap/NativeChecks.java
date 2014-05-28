package com.willshawmedia.phonegap.NativeChecks;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.provider.Settings.Secure;

/**
 * This class echoes a string called from JavaScript.
 */
public class NativeChecks extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        
        // String message = args.getString(0);
        
        if ( action.equals( "getDeviceID" ) ) {
            this.getDeviceID( callbackContext );
            return true;
        }

        return false;
    }

    private void getDeviceID(CallbackContext callbackContext) {
        
        try {
            // get device ID, hash with GETSOCIALITE
            private String android_id = Secure.getString(
                                            getContext().getContentResolver(),
                                            Secure.ANDROID_ID
                                        ); 
            private String device_id = android_id + "GETSOCIALITE";

            // hash and return string
            MessageDigest digest = MessageDigest.getInstance( "SHA-256" );
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            callbackContext.success( hexString.toString() );
        } catch (IOException e) {
            callbackContext.error( e.getMessage() );
        }

    }

    // private void getVersion:(NSMutableArray *)arguments withDict:(NSMutableDictionary *)options {
    //     NSString* callbackId = [arguments objectAtIndex:0];
        
    //     CDVPluginResult* pluginResult = nil;
    //     NSString* javaScript = nil;
        
    //     @try {
                    
    //         NSString* version = [[[NSBundle mainBundle] infoDictionary] objectForKey:@"CFBundleShortVersionString"];
            
    //         pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:version];
    //         javaScript = [pluginResult toSuccessCallbackString:callbackId];
    //     } @catch (NSException* exception) {
    //         // could not get locale
    //         pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_JSON_EXCEPTION messageAsString:[exception reason]];
    //         javaScript = [pluginResult toErrorCallbackString:callbackId];
    //     }
    //     [self writeJavascript:javaScript];
    // }

    // private void checkFirstRun:(NSMutableArray *)arguments withDict:(NSMutableDictionary *)options {
    //     NSString* callbackId = [arguments objectAtIndex:0];
        
    //     CDVPluginResult* pluginResult = nil;
    //     NSString* javaScript = nil;
        
    //     @try {
            
    //         NSUserDefaults *defaults = [NSUserDefaults standardUserDefaults];
    //         NSString *isFirstRun = @"1";
            
    //         if (![defaults objectForKey:@"firstRun"]) {
    //             [defaults setObject:[NSDate date] forKey:@"firstRun"];
    //         } else {
    //             isFirstRun = @"0";
    //         }
        
    //         pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:isFirstRun];
    //         javaScript = [pluginResult toSuccessCallbackString:callbackId];
    //     } @catch (NSException* exception) {
    //         // could not get locale
    //         pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_JSON_EXCEPTION messageAsString:[exception reason]];
    //         javaScript = [pluginResult toErrorCallbackString:callbackId];
    //     }
    //     [self writeJavascript:javaScript];
    // }

    // private void checkDebug:(NSMutableArray *)arguments withDict:(NSMutableDictionary *)options {
    //     NSString* callbackId = [arguments objectAtIndex:0];
        
    //     CDVPluginResult* pluginResult = nil;
    //     NSString* javaScript = nil;
        
    //     @try {
            
    //         NSString *isDebug = @"0";
    //         #ifdef DEBUG
    //             isDebug = @"1";
    //         #endif
            
    //         pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:isDebug];
    //         javaScript = [pluginResult toSuccessCallbackString:callbackId];
    //     } @catch (NSException* exception) {
    //         // could not get locale
    //         pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_JSON_EXCEPTION messageAsString:[exception reason]];
    //         javaScript = [pluginResult toErrorCallbackString:callbackId];
    //     }
    //     [self writeJavascript:javaScript];
    // }

    // private void checkAdhoc:(NSMutableArray *)arguments withDict:(NSMutableDictionary *)options {
    //     NSString* callbackId = [arguments objectAtIndex:0];
        
    //     CDVPluginResult* pluginResult = nil;
    //     NSString* javaScript = nil;
        
    //     @try {
            
    //         NSString *isAdhoc = @"0";
    // #ifdef ADHOC
    //         isAdhoc = @"1";
    // #endif
            
    //         pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:isAdhoc];
    //         javaScript = [pluginResult toSuccessCallbackString:callbackId];
    //     } @catch (NSException* exception) {
    //         // could not get locale
    //         pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_JSON_EXCEPTION messageAsString:[exception reason]];
    //         javaScript = [pluginResult toErrorCallbackString:callbackId];
    //     }
    //     [self writeJavascript:javaScript];
    // }

    // private void registerPush:(NSMutableArray *)arguments withDict:(NSMutableDictionary *)options {
    //     // Register for push notifications, only if an event has been subscribed to
    //     [
    //      [UIApplication sharedApplication] registerForRemoteNotificationTypes:
    //         UIRemoteNotificationTypeBadge |
    //         UIRemoteNotificationTypeAlert |
    //         UIRemoteNotificationTypeSound
    //      ];
    // }
}