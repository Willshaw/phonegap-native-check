Phonegap Native Checks
======================

Plugin to lookup simple native information from a Phonegap app

### Install/Remove

Use the cordova CLI:

#### Install

```cordova plugin add https://github.com/willshaw/phonegap-native-check.git```

#### Remove 

```cordova plugin remove com.willshawmedia.phonegap.NativeChecks```

### Methods

 - **getAppVersion** returns app version, set in AndroidManifest.xml or Xcode build settings
 - **checkFirstRun** checks for a flag in native preferences, returns true if not there and sets it
 - **checkDebug** checks for ```if_def IS_DEBUG``` in iOS and USB connection in Android
 - **checkAdhoc** checks for ```if_def IS_ADHOC``` in iOS and a blank installer package name in Android
 - **getCountryCode** returns the 2 digit country code based on Locale
