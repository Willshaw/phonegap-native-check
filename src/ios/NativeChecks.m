//
//  NativeChecks.m

#import "NativeChecks.h"
#import <Cordova/CDV.h>

@implementation NativeChecks

- (void) getAppVersion:(CDVInvokedUrlCommand*)command {
    
    CDVPluginResult* pluginResult = nil;
    
    @try {
        NSString* version = [[[NSBundle mainBundle] infoDictionary] objectForKey:@"CFBundleShortVersionString"];
        
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:version];
    } @catch (NSException* exception) {
        // could not get locale
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_JSON_EXCEPTION messageAsString:[exception reason]];
    }
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void) checkFirstRun:(CDVInvokedUrlCommand*)command {
    
    CDVPluginResult* pluginResult = nil;
    
    @try {
        NSUserDefaults *defaults = [NSUserDefaults standardUserDefaults];
        NSString *isFirstRun = @"1";
        
        if (![defaults objectForKey:@"firstRun"]) {
            [defaults setObject:[NSDate date] forKey:@"firstRun"];
        } else {
            isFirstRun = @"0";
        }
    
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:isFirstRun];
    } @catch (NSException* exception) {
        // could not get locale
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_JSON_EXCEPTION messageAsString:[exception reason]];
    }
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void) checkDebug:(CDVInvokedUrlCommand*)command {
    
    CDVPluginResult* pluginResult = nil;
    
    @try {
        
        NSString *isDebug = @"0";
        #ifdef DEBUG
            isDebug = @"1";
        #endif
        
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:isDebug];
    } @catch (NSException* exception) {
        // could not get locale
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_JSON_EXCEPTION messageAsString:[exception reason]];
    }
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void) checkAdhoc:(CDVInvokedUrlCommand*)command {
    
    CDVPluginResult* pluginResult = nil;
    
    @try {
        
        NSString *isAdhoc = @"0";
        
        #ifdef ADHOC
        isAdhoc = @"1";
        #endif
        
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:isAdhoc];
    } @catch (NSException* exception) {
        // could not get locale
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_JSON_EXCEPTION messageAsString:[exception reason]];
    }
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void) getCountryCode:(CDVInvokedUrlCommand*)command {
    
    CDVPluginResult* pluginResult = nil;
    
    @try {
        // try to get country code and reutrn to app
        NSLocale *currentLocale = [NSLocale currentLocale];  // get the current locale.
        NSString *countryCode = [currentLocale objectForKey:NSLocaleCountryCode];
        
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:countryCode];
    } @catch (NSException* exception) {
        // could not get locale
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_JSON_EXCEPTION messageAsString:[exception reason]];
    }
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end