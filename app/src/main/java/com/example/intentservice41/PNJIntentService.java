package com.example.intentservice41;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.support.annotation.Nullable;

public class PNJIntentService extends IntentService {

    private static final String TAG = "intentservice41";
    // max 23 characters - package: com.example.intentservice41 is 27

    // IntentService must: (1) have constructor (2) implement onHandleIntent

    public PNJIntentService()        // constructor, as required
    {
        super("PNJIntentService");
    }



    // Alt+Insert - Overrides
    /**
     * This method is invoked on the worker thread with a request to process.
     * Only one Intent is processed at a time, but the processing happens on a
     * worker thread that runs independently from other application logic.
     * So, if this code takes a long time, it will hold up other requests to
     * the same IntentService, but it will not hold up anything else.
     * When all requests have been handled, the IntentService stops itself,
     * so you should not call {@link #stopSelf}.
     *
     * @param intent The value passed to {@link
     *               Context#startService(Intent)}.
     *               This may be null if the service is being restarted after
     *               its process has gone away; see
     *               {@link Service#onStartCommand}
     *               for details.
     */
    @Override
//    protected void onHandleIntent(@androidx.annotation.Nullable Intent intent) {
    // TODO: would be nice to have Intent as Nullable but won't import at mo https://stackoverflow.com/a/55228286/11365317
    protected void onHandleIntent(Intent intent) {      // simpler signature hand-written

            // NB
        // do-ing code of service in here
        Log.i(TAG,"The service has started running");
    }
}
