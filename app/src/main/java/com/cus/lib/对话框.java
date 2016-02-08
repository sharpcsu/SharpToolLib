package com.cus.lib;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class 对话框 extends Activity{
    /**
     *弹出更新对话框
     */
    private void showUpdateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("有新版本");
        builder.setMessage("mDesc");

        //builder.setCancelable(false);// 能不能取消, 最好不用
        builder.setPositiveButton("立即更新", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setNegativeButton("下次再说", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        // 取消对话框时的回调
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {

            }
        });

        // builder.show();
        AlertDialog dialog = builder.create();
        dialog.show();
    }//showUpdateDialog
}
