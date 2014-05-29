package com.willshawmedia.phonegap;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class NativeChecks extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ( action.equals( "getAppVersion" ) ) {
            this.getAppVersion( callbackContext );
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

//     // }

//     // private void checkFirstRun:(NSMutableArray *)arguments withDict:(NSMutableDictionary *)options {
//     //     NSString* callbackId = [arguments objectAtIndex:0];
        
//     //     CDVPluginResult* pluginResult = nil;
//     //     NSString* javaScript = nil;
        
//     //     @try {
            
//     //         NSUserDefaults *defaults = [NSUserDefaults standardUserDefaults];
//     //         NSString *isFirstRun = @"1";
            
//     //         if (![defaults objectForKey:@"firstRun"]) {
//     //             [defaults setObject:[NSDate date] forKey:@"firstRun"];
//     //         } else {
//     //             isFirstRun = @"0";
//     //         }
        
//     //         pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:isFirstRun];
//     //         javaScript = [pluginResult toSuccessCallbackString:callbackId];
//     //     } @catch (NSException* exception) {
//     //         // could not get locale
//     //         pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_JSON_EXCEPTION messageAsString:[exception reason]];
//     //         javaScript = [pluginResult toErrorCallbackString:callbackId];
//     //     }
//     //     [self writeJavascript:javaScript];
//     // }

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
}
