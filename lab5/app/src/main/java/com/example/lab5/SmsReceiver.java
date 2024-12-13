package com.example.lab5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import java.util.ArrayList;

public class SmsReceiver extends BroadcastReceiver {

    public static final String SMS_MESSAGE_ADDRESS_KEY = "addresses";
    public static final String SMS_FORWARD_BROADCAST_RECEIVER = "com.example.lab5.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {
        String queryString = "Are you OK?".toLowerCase();

        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Object[] pdus = (Object[]) bundle.get("pdus");
            SmsMessage[] messages = new SmsMessage[pdus.length];
            for (int i = 0; i < pdus.length; i++){
                if (Build.VERSION.SDK_INT >= 23){
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i], "");
                } else{
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }

                ArrayList<String> addresses = new ArrayList<>();

                for (SmsMessage message : messages){
                    if (message.getMessageBody().toLowerCase().contains(queryString)){
                        addresses.add(message.getOriginatingAddress());
                    }
                }

                if (addresses.size() > 0){
                    if (!MainActivity.isRunning){

                    }else{
                        Intent iForwardBroadcastReceiver = new Intent(SMS_FORWARD_BROADCAST_RECEIVER);
                        iForwardBroadcastReceiver.putStringArrayListExtra(SMS_MESSAGE_ADDRESS_KEY, addresses);
                        context.sendBroadcast(iForwardBroadcastReceiver);
                    }
                }
            }

            String format = bundle.getString("format");

            ArrayList<String> addresses = new ArrayList<>();

            if (pdus != null) {
                for (Object pdu : pdus) {
                    SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdu, format);
                    addresses.add(smsMessage.getOriginatingAddress());
                }

                // Use LocalBroadcastManager to send data to MainActivity
                Intent broadcastIntent = new Intent(SMS_FORWARD_BROADCAST_RECEIVER);
                broadcastIntent.putStringArrayListExtra(SMS_MESSAGE_ADDRESS_KEY, addresses);
                LocalBroadcastManager.getInstance(context).sendBroadcast(broadcastIntent);
            }
        }
    }
}
