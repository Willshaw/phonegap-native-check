var NativeChecks = {
    getAppVersion: function( callback, error_callback ) {
        cordova.exec(
            callback, 
            error_callback, 
            "NativeChecks", 
            "getAppVersion", 
            []
        );
    },
    // returns false on error
    checkFirstRun: function( callback, error_callback ) {
        cordova.exec(
            function( isFirstRun ) {
                isFirstRun = parseInt( isFirstRun, 10 );
                callback( isFirstRun );
            }, 
            function( err ) {
                error_callback( err );
                return false;
            }, 
            "NativeChecks", 
            "checkFirstRun", 
            []
        );
    },
    // return true/false for DEBUG (USB) build
    checkDebug: function( callback, error_callback ) {
        cordova.exec(
            function( isDebug ) {
                isDebug = parseInt( isDebug, 10 );
                callback( isDebug );
            }, 
            function( err ) {
                error_callback( err );
                return false;
            },
            "NativeChecks",
            "checkDebug",
            []
        );
    }
};

module.exports = NativeChecks;

// var NativeChecks = function() {

//     this.debug = true;
//     this.adhoc = true;


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
