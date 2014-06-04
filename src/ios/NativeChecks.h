//
//  AppChecks
//  socialite-pw-build
//
//  Created by Peter Williamson on 11/10/2013.
//
//

#import <Cordova/CDVPlugin.h>

@interface AppChecks : CDVPlugin

- (void) getVersion:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
- (void) checkFirstRun:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
- (void) checkDebug:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
- (void) checkAdhoc:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;

@end
