var NativeChecks = {

        var debug = true,
            adhoc = true;

        this.getVersion = function() {
            cordova.exec(
                function( version ) {
                    return version;
                },
                function(err) {},
                "AppChecks",
                "getVersion",
                []
            );
        };

        this.getDeviceID = function() {
            cordova.exec(
                function( device_id ) {
                    return device_id;
                },
                function(err) {},
                "AppChecks",
                "getDeviceID",
                []
            );
            
        };

        this.checkFirstRun = function() {
            cordova.exec(
                function( isFirstRun ) {
                    isFirstRun = parseInt( isFirstRun );
                    if( isFirstRun && !debug ) {
                        return true;
                    }
                },
                function(err) {},
                "AppChecks",
                "checkFirstRun",
                []
            );
        }

        this.checkDebug = function() {
            cordova.exec(
                function( d ) {
                    d = parseInt( d );
                    if( d ) {
                        debug = true; 
                    } else {
                        debug = false;
                    }
                },
                function(err) {},
                "AppChecks",
                "checkDebug",
                []
            );
        };

        this.isDebug = function() {
            return debug;
        };

        this.checkAdhoc = function() {
            cordova.exec(
                function( d ) {
                    d = parseInt( d );
                    if( d ) {
                        adhoc = true; 
                    } else {
                        adhoc = false;
                    }
                },
                function(err) {},
                "AppChecks",
                "checkAdhoc",
                []
            );
        };

        this.isAdhoc = function() {
            return adhoc;
        };

        this.registerPush = function() {
            cordova.exec(
                function() {},
                function(err) {},
                "AppChecks",
                "registerPush",
                []
            );
        };
        
        return this;
    });

    
};
