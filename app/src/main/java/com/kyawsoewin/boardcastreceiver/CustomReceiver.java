package com.kyawsoewin.boardcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import static com.kyawsoewin.boardcastreceiver.MainActivity.ACTION_CUSTOM_BROADCAST;

public class CustomReceiver extends BroadcastReceiver {
    private SendData sendData;

    public CustomReceiver(){

    }

    public CustomReceiver(SendData sendData) {
        this.sendData = sendData;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        String toastMessage;
        switch (intentAction) {
            case Intent.ACTION_POWER_CONNECTED:
                toastMessage = "Power connected!";
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                toastMessage = "Power disconnected!";
                break;
            case ACTION_CUSTOM_BROADCAST:
                toastMessage = "Custom Broadcast Received";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + intentAction);
        }
        if (sendData != null) {
            sendData.send(toastMessage);
        }

        Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
    }
}
