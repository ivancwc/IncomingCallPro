package com.example.incomingcallpro;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

/**
 * Created by ivanc on 06/07/17.
 */

public class PhoneStateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        intent.setFlags(Intent.FLAG_RECEIVER_FOREGROUND);

        try {
//            System.out.println("Receiver start");
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
//                Toast.makeText(context,"Incoming Call State",Toast.LENGTH_SHORT).show();
//                Toast.makeText(context,"Incoming Call Number is "+incomingNumber,Toast.LENGTH_SHORT).show();
                ContactsLoader cl = new ContactsLoader();
                String contactName;
                String contactID;
                String company;
                contactName = cl.getContactName(context, incomingNumber);
                contactID = cl.getContactID(context, incomingNumber);
                company = cl.getContactCompany(context, contactID);
                System.out.println("Contact Name of " + incomingNumber + ": " + contactName + " Contact ID: " + contactID + " Company: " + company);
                Toast.makeText(context,"Caller's Company: "+ company ,Toast.LENGTH_SHORT).show();

            }
//            if ((state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK))){
//                Toast.makeText(context,"Call Received State",Toast.LENGTH_SHORT).show();
//            }
//            if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)){
//                Toast.makeText(context,"Call Idle State",Toast.LENGTH_SHORT).show();
//            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}



