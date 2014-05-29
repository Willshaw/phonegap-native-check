var NativeChecks = {
    echo: function(str, callback) {
        cordova.exec(callback, function(err) {
            callback('Nothing to echo.',err);
        }, "NativeChecks", "echo", [str]);
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

//     this.getDeviceID = function() {
//         cordova.exec(
//             function( device_id ) {
//                 return device_id;
//             },
//             function(err) {},
//             "AppChecks",
//             "getDeviceID",
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
