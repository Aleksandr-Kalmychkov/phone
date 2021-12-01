package com.example.signinup;

import android.os.AsyncTask;

import java.io.IOException;

public class postTask extends AsyncTask {

    @Override
    protected Object doInBackground(Object[] objects) {
        if (objects.length == 3)
        {
            try {
                MyHelper.signInPOST(objects[0].toString(), objects[1].toString(), objects[2].toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (objects.length == 5)
        {
            try {
                MyHelper.signUpPOST(objects[0].toString(), objects[1].toString(), objects[2].toString(), objects[3].toString(), objects[4].toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
