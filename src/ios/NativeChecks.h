//  NativeChecks
#import <Cordova/CDV.h>

@interface NativeChecks : CDVPlugin

- (void) getAppVersion:(CDVInvokedUrlCommand*)command;
- (void) checkFirstRun:(CDVInvokedUrlCommand*)command;
- (void) checkDebug:(CDVInvokedUrlCommand*)command;
- (void) checkAdhoc:(CDVInvokedUrlCommand*)command;
- (void) getCountryCode:(CDVInvokedUrlCommand*)command;

@end
