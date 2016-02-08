package com.cus.lib;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 *获取电话号码信息
 */
public class 获取电话号码信息 {

    /**
     * 获取所有的号码信息
     * @param context
     * @return
     */
    public static ArrayList<PhoneInfo> getAllPhone(Context context) {
        ContentResolver resolver = context.getContentResolver();
        // content://com.android.contacts/raw_contacts
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] projection = new String[] { ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID };
        Cursor cursor = resolver.query(uri, projection, null, null, null);
        ArrayList<PhoneInfo> list = new ArrayList<PhoneInfo>();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String number = cursor.getString(0);
                String name = cursor.getString(1);
                int id = cursor.getInt(2);
                PhoneInfo info = new PhoneInfo(number, name, id);
                list.add(info);
            }
            cursor.close();
        }
        return list;
    }

    /**
     * 获取联系人图片
     * @param context
     * @param id 联系人id
     * @return
     */
    public static Bitmap getContactPhoto(Context context, int id) {
        ContentResolver resolver = context.getContentResolver();
        Uri contactUri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI,
                String.valueOf(id));
        InputStream inputStream = ContactsContract.Contacts.openContactPhotoInputStream(resolver,
                contactUri);
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        if(inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bitmap;
    }
}

class PhoneInfo {
    public String mNumber;
    public String mName;
    public int mId;
    public PhoneInfo(String number, String name, int id) {
        super();
        mNumber = number;
        mName = name;
        mId = id;
    }
    public PhoneInfo() {
        super();
    }
}