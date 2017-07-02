package com.example.incomingcallpro;


import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Data;
//import android.provider.ContactsContract.Contacts;
import android.support.annotation.NonNull;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.content.Context;


/**
 * Created by ivanc on 06/08/17.
 */

public class ContactsLoader {


    public static String getContactCompany(Context context, String contact_ID) {

        String company = null;
        String[] mSelectionArgs = {""};
        mSelectionArgs[0] = contact_ID;

        ContentResolver cr = context.getContentResolver();
//        System.out.println("Contact ID: " + contact_ID);
        Cursor companyCur = cr.query(ContactsContract.Data.CONTENT_URI,
                null, ContactsContract.Data.CONTACT_ID + " = ?", mSelectionArgs, null);
//        System.out.println("cur count: " + String.valueOf(companyCur.getCount()));
        if (companyCur.getCount() > 0) {

            while (companyCur.moveToNext()) {
//                id = companyCur.getString(companyCur.getColumnIndex(ContactsContract.Data.CONTACT_ID));
//                name = companyCur.getString(companyCur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY));
//                System.out.println("ID: " + id + ", Name: " + name + ", Company: " + company+ ", Phone: " + phone);
//                System.out.println("ID: " + id + ", Name: " + name);

                if(companyCur.getString(companyCur.getColumnIndex(ContactsContract.Data.MIMETYPE)).equals(ContactsContract.CommonDataKinds.Organization.CONTENT_ITEM_TYPE))
                {
                    company = companyCur.getString(companyCur.getColumnIndex(ContactsContract.CommonDataKinds.Organization.COMPANY));
                    System.out.println("Company: " + company);
//                    Toast.makeText(context, "ID: " + id + ", Name: " + name + ", Company: " + company, Toast.LENGTH_SHORT).show();
                }
            }
        }
        companyCur.close();
        return company;
    }



    /*
    *
    *
    * Reference : https://stackoverflow.com/questions/3079365/android-retrieve-contact-name-from-phone-number
    *
    *
    *
    *
    * */


    public static String getContactName(Context context, String phoneNumber) {
        ContentResolver cr = context.getContentResolver();
        Uri uri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(phoneNumber));
        Cursor cursor = cr.query(uri, new String[]{ContactsContract.PhoneLookup.DISPLAY_NAME}, null, null, null);
        if (cursor == null) {
            return null;
        }
        String contactName = null;
        if(cursor.moveToFirst()) {
            contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME));
        }

        if(cursor != null && !cursor.isClosed()) {
            cursor.close();
        }

        return contactName;
    }

    public static String getContactID(Context context, String phoneNumber) {
        ContentResolver cr = context.getContentResolver();
        Uri uri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(phoneNumber));
        Cursor cursor = cr.query(uri, new String[]{ContactsContract.PhoneLookup.CONTACT_ID}, null, null, null);
        if (cursor == null) {
            return null;
        }
        String contactID = null;
        if(cursor.moveToFirst()) {
            contactID = cursor.getString(cursor.getColumnIndex(ContactsContract.PhoneLookup.CONTACT_ID));
        }

        if(cursor != null && !cursor.isClosed()) {
            cursor.close();
        }

        return contactID;
    }



/* Trash Bin*/

/*

    public void displayContacts(Context context) {

        String id;
        String name;
        String company;
        String phone;
        String[] mSelectionArgs = {""};
        Uri uri;
        mSelectionArgs[0] = "1".toString();


        */
/*


        https://developer.android.com/guide/topics/providers/content-provider-basics.html

        // Queries the user dictionary and returns results
            mCursor = getContentResolver().query(
                UserDictionary.Words.CONTENT_URI,   // The content URI of the words table
                mProjection,                        // The columns to return for each row
                mSelectionClause                    // Selection criteria
                mSelectionArgs,                     // Selection criteria
                mSortOrder);                        // The sort order for the returned rows

         *//*



        ContentResolver cr = context.getContentResolver();
        Cursor mobileNoCur = cr.query(ContactsContract.Data.CONTENT_URI,
                null, ContactsContract.Contacts.HAS_PHONE_NUMBER + " = ?", mSelectionArgs, null);

        */
/*Cursor mobileNoCur = cr.query(ContactsContract.Data.CONTENT_URI,
                null, null , null, null);*//*


        if (mobileNoCur.getCount() > 0) {

            while (mobileNoCur.moveToNext()) {
                id = mobileNoCur.getString(mobileNoCur.getColumnIndex(ContactsContract.Data.CONTACT_ID));
                name = mobileNoCur.getString(mobileNoCur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY));
//                System.out.println("ID: " + id + ", Name: " + name + ", Company: " + company+ ", Phone: " + phone);
//                System.out.println("ID: " + id + ", Name: " + name);

                if(mobileNoCur.getString(mobileNoCur.getColumnIndex(ContactsContract.Data.MIMETYPE)).equals(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE))
                {
                    //company = mobileNoCur.getString(mobileNoCur.getColumnIndex(ContactsContract.CommonDataKinds.Organization.COMPANY));
                    phone = mobileNoCur.getString(mobileNoCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    //System.out.println("ID: " + id + ", Name: " + name + ", Organization: " + organization);
                    System.out.println("ID: " + id + ", Name: " + name + ", Phone: " + phone);
//                  Toast.makeText(context, "ID: " + id + ", Name: " + name + ", Phone: " + phone, Toast.LENGTH_SHORT).show();
//                    getContactsCompany(context, ContactsContract.Contacts.CONTENT_LOOKUP_URI);
                */
/*    uri = ContactsContract.Data.getContactLookupUri(cr, ContactsContract.Data.CONTENT_URI);
                    if (uri != null) {
                        getContactsCompany(context, uri);
                    }
*//*

//                    getContactCompany(context, id);
                }

               */
/*
                if(mobileNoCur.getString(mobileNoCur.getColumnIndex(ContactsContract.Data.MIMETYPE)).equals(ContactsContract.CommonDataKinds.Organization.CONTENT_ITEM_TYPE))
                {
                    company = mobileNoCur.getString(mobileNoCur.getColumnIndex(ContactsContract.CommonDataKinds.Organization.COMPANY));
                    //System.out.println("ID: " + id + ", Name: " + name + ", Organization: " + organization);
                    System.out.println("ID: " + id + ", Name: " + name + ", Company: " + company);
                    Toast.makeText(context, "ID: " + id + ", Name: " + name + ", Company: " + company, Toast.LENGTH_SHORT).show();
                }

                *//*




            }
        }
        mobileNoCur.close();
    }

*/


}
