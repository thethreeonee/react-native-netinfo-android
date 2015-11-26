# react-native-netinfo-android

NetInfo access for android

## Usage (Android)

Make alterations to the following files:

* `android/settings.gradle`

```gradle
...
include ':react-native-netinfo-android'
project(':react-native-netinfo-android').projectDir = new File(settingsDir, '../node_modules/react-native-netinfo-android/android')
```

* `android/app/build.gradle`

```gradle
...
dependencies {
    ...
    compile project(':react-native-netinfo-android')
}
```

* register module (in MainActivity.java)

```java
import io.iir.NetInfoPackage;  // <--- import

public class MainActivity extends Activity implements DefaultHardwareBackBtnHandler {

  ......

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mReactRootView = new ReactRootView(this);

    mReactInstanceManager = ReactInstanceManager.builder()
      .setApplication(getApplication())
      .setBundleAssetName("index.android.bundle")
      .setJSMainModuleName("index.android")
      .addPackage(new MainReactPackage())
      .addPackage(new NetInfoPackage())      // <------- add package
      .setUseDeveloperSupport(BuildConfig.DEBUG)
      .setInitialLifecycleState(LifecycleState.RESUMED)
      .build();

    mReactRootView.startReactApplication(mReactInstanceManager, "ExampleRN", null);

    setContentView(mReactRootView);
  }

  ......

}
```

## Examples

### Basic

```javascript
// require the module
var NetInfoAndroid = require("react-native-netinfo-android");

// get current active network type
NetInfoAndroid.getNetworkType(function(typename) {
  console.log(typename);
});
```

## API

### `getNetworkType(callback)`

Get current active network type ("wifi", "mobile", etc).

`callback` will be invoked once have get network type and passed a single string argument ("wifi", "mobile", etc) which has the same value of [`getTypeName()`](http://developer.android.com/reference/android/net/NetworkInfo.html#getTypeName()).
