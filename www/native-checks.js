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
    },
    // return true/false if not installed via Google Play
    checkAdhoc: function( callback, error_callback ) {
        cordova.exec(
            function( isAdhoc ) {
                isAdhoc = parseInt( isAdhoc, 10 );
                callback( isAdhoc );
            }, 
            function( err ) {
                error_callback( err );
                return false;
            },
            "NativeChecks",
            "checkAdhoc",
            []
        );
    }    
};

module.exports = NativeChecks;
