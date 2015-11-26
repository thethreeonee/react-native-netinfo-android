package io.iir;

/**
 * Created by MiincGu on 15/11/26.
 */

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.util.Log;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class NetInfoModule extends ReactContextBaseJavaModule {
    private Context context;

    public NetInfoModule(ReactApplicationContext reactContext) {

        super(reactContext);

        this.context = reactContext;
    }

    @Override
    public String getName() {
        return "NetInfoAndroid";
    }

    @ReactMethod
    public void networkType(Callback successCallback) {
        ConnectivityManager manager = (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo netinfo = manager.getActiveNetworkInfo();

        if (netinfo != null) {
            String typeName = netinfo.getTypeName().toLowerCase();

            successCallback.invoke(typeName);
        } else {
            successCallback.invoke("");
        }

    }
}
