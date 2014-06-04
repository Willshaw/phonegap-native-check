//
//  AppChecks.m
//  socialite-pw-build
//
//  Created by Peter Williamson on 11/10/2013.
//
//

#import "AppChecks.h"
#import <Cordova/CDVPluginResult.h>

@implementation AppChecks

- (void) getVersion:(NSMutableArray *)arguments withDict:(NSMutableDictionary *)options {
    NSString* callbackId = [arguments objectAtIndex:0];
    
    CDVPluginResult* pluginResult = nil;
    NSString* javaScript = nil;
    
    @try {
                
        NSString* version = [[[NSBundle mainBundle] infoDictionary] objectForKey:@"CFBundleShortVersionString"];
        
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:version];
        javaScript = [pluginResult toSuccessCallbackString:callbackId];
    } @catch (NSException* exception) {
        // could not get locale
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_JSON_EXCEPTION messageAsString:[exception reason]];
        javaScript = [pluginResult toErrorCallbackString:callbackId];
    }
    [self writeJavascript:javaScript];
}

- (void) checkFirstRun:(NSMutableArray *)arguments withDict:(NSMutableDictionary *)options {
    NSString* callbackId = [arguments objectAtIndex:0];
    
    CDVPluginResult* pluginResult = nil;
    NSString* javaScript = nil;
    
    @try {
        
        NSUserDefaults *defaults = [NSUserDefaults standardUserDefaults];
        NSString *isFirstRun = @"1";
        
        if (![defaults objectForKey:@"firstRun"]) {
            [defaults setObject:[NSDate date] forKey:@"firstRun"];
        } else {
            isFirstRun = @"0";
        }
    
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:isFirstRun];
        javaScript = [pluginResult toSuccessCallbackString:callbackId];
    } @catch (NSException* exception) {
        // could not get locale
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_JSON_EXCEPTION messageAsString:[exception reason]];
        javaScript = [pluginResult toErrorCallbackString:callbackId];
    }
    [self writeJavascript:javaScript];
}

- (void) checkDebug:(NSMutableArray *)arguments withDict:(NSMutableDictionary *)options {
    NSString* callbackId = [arguments objectAtIndex:0];
    
    CDVPluginResult* pluginResult = nil;
    NSString* javaScript = nil;
    
    @try {
        
        NSString *isDebug = @"0";
        #ifdef DEBUG
            isDebug = @"1";
        #endif
        
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:isDebug];
        javaScript = [pluginResult toSuccessCallbackString:callbackId];
    } @catch (NSException* exception) {
        // could not get locale
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_JSON_EXCEPTION messageAsString:[exception reason]];
        javaScript = [pluginResult toErrorCallbackString:callbackId];
    }
    [self writeJavascript:javaScript];
}

- (void) checkAdhoc:(NSMutableArray *)arguments withDict:(NSMutableDictionary *)options {
    NSString* callbackId = [arguments objectAtIndex:0];
    
    CDVPluginResult* pluginResult = nil;
    NSString* javaScript = nil;
    
    @try {
        
        NSString *isAdhoc = @"0";
#ifdef ADHOC
        isAdhoc = @"1";
#endif
        
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:isAdhoc];
        javaScript = [pluginResult toSuccessCallbackString:callbackId];
    } @catch (NSException* exception) {
        // could not get locale
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_JSON_EXCEPTION messageAsString:[exception reason]];
        javaScript = [pluginResult toErrorCallbackString:callbackId];
    }
    [self writeJavascript:javaScript];
}

@end