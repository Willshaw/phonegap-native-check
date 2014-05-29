var NativeChecks = {
    getAppVersion: function( callback, error_callback ) {
        callback( device.uuid );
    }
};

module.exports = NativeChecks;

// var NativeChecks = function() {

//     this.debug = true;
//     this.adhoc = true;

//     this.getVersion = function() {
//         cordova.exec(
//             function( version ) {
//                 return version;
//             },
//             function(err) {},
//             "AppChecks",
//             "getVersion",
//             []
//         );
//     };

//     this.checkFirstRun = function() {
//         cordova.exec(
//             function( isFirstRun ) {
//                 isFirstRun = parseInt( isFirstRun, 10 );
//                 if( isFirstRun && !this.debug ) {
//                     return true;
//                 }
//             },
//             function(err) {},
//             "AppChecks",
//             "checkFirstRun",
//             []
//         );
//     };

//     this.checkDebug = function() {
//         cordova.exec(
//             function( d ) {
//                 d = parseInt( d, 10 );
//                 if( d ) {
//                     this.debug = true; 
//                 } else {
//                     this.debug = false;
//                 }
//             },
//             function(err) {},
//             "AppChecks",
//             "checkDebug",
//             []
//         );
//     };

//     this.isDebug = function() {
//         return this.debug;
//     };

//     this.checkAdhoc = function() {
//         cordova.exec(
//             function( d ) {
//                 d = parseInt( d, 10 );
//                 if( d ) {
//                     this.adhoc = true; 
//                 } else {
//                     this.adhoc = false;
//                 }
//             },
//             function(err) {},
//             "AppChecks",
//             "checkAdhoc",
//             []
//         );
//     };

//     this.isAdhoc = function() {
//         return this.adhoc;
//     };

//     this.registerPush = function() {
//         cordova.exec(
//             function() {},
//             function(err) {},
//             "AppChecks",
//             "registerPush",
//             []
//         );
//     };

//     return this;    
// };
