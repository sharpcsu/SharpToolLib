package com.cus.lib;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class 安装apkAnd卸载 extends Activity {

    private void uninstallSafe() {
        //卸载自己
        // <action android:name="android.intent.action.VIEW" />
        // <action android:name="android.intent.action.DELETE" />
        // <category android:name="android.intent.category.DEFAULT" />
        // <data android:scheme="package" />
        Intent intent = new Intent();
        intent.setAction("android.intent.action.DELETE");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivity(intent);
    }
}
