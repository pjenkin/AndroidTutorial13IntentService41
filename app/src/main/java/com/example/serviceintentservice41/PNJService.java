package com.example.serviceintentservice41;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

public class PNJService extends Service {
    public PNJService() {
    }

    private static final String TAG = "service42";

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        // throw new UnsupportedOperationException("Not yet implemented");      // boilerplate
        return null;        // return null as this is not to be a bound service
    }

    // Alt + Insert

    /**
     * Called by the system every time a client explicitly starts the service by calling
     * {@link Context#startService}, providing the arguments it supplied and a
     * unique integer token representing the start request.  Do not call this method directly.
     *
     * <p>For backwards compatibility, the default implementation calls
     * {@link #onStart} and returns either {@link #START_STICKY}
     * or {@link #START_STICKY_COMPATIBILITY}.
     *
     * <p class="caution">Note that the system calls this on your
     * service's main thread.  A service's main thread is the same
     * thread where UI operations take place for Activities running in the
     * same process.  You should always avoid stalling the main
     * thread's event loop.  When doing long-running operations,
     * network calls, or heavy disk I/O, you should kick off a new
     * thread, or use {@link AsyncTask}.</p>
     *
     * @param intent  The Intent supplied to {@link Context#startService},
     *                as given.  This may be null if the service is being restarted after
     *                its process has gone away, and it had previously returned anything
     *                except {@link #START_STICKY_COMPATIBILITY}.
     * @param flags   Additional data about this start request.
     * @param startId A unique integer representing this specific request to
     *                start.  Use with {@link #stopSelfResult(int)}.
     * @return The return value indicates what semantics the system should
     * use for the service's current started state.  It may be one of the
     * constants associated with the {@link #START_CONTINUATION_MASK} bits.
     * @see #stopSelfResult(int)
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand called");
//        return super.onStartCommand(intent, flags, startId);        // boilerplate


        // NB although IntentService d'include a Thread of its own by default, Service doesn't...
        // so must declare new Thread and Runnable to run therein, hereunder
        Runnable r = new Runnable()
        {
            // code here grey coloured in AS as in runnable/ready to be in a different thread
            // Alt+Insert and override... pick run method from dialogue

            /**
             * When an object implementing interface <code>Runnable</code> is used
             * to create a thread, starting the thread causes the object's
             * <code>run</code> method to be called in that separately executing
             * thread.
             * <p>
             * The general contract of the method <code>run</code> is that it may
             * take any action whatsoever.
             *
             * @see Thread#run()
             */
            @Override
            public void run() {
                for (int i= 0; i < 5; i++)
                {
                    long futureTime = System.currentTimeMillis() + 5000;
                    while (System.currentTimeMillis() < futureTime)
                    {
                        synchronized (this)
                        {
                            try
                            {
                                wait(futureTime - System.currentTimeMillis());
                                Log.i(TAG, String.format("Service is doing something... %d", i));
                                // useful code (eg download, query &c in here - async in own background thread
                            }
                            catch (Exception exc)
                            {
                                // do nothing with exception at the moment
                            }
                        }
                    }
                }
            }
        };      // end of Runnable
        Thread pnjThreadForService = new Thread(r); // use runnable inside new thread for service
        pnjThreadForService.start();        // Don't forget to start!
        return Service.START_STICKY;
        // sticky d'mean re-start automatically if stopped for some reason
    }

    // Alt + Insert

    /**
     * Called by the system to notify a Service that it is no longer used and is being removed.  The
     * service should clean up any resources it holds (threads, registered
     * receivers, etc) at this point.  Upon return, there will be no more calls
     * in to this Service object and it is effectively dead.  Do not call this method directly.
     */
    @Override
    public void onDestroy() {
//        super.onDestroy();
        Log.i(TAG, "onDestroy called");
    }


}
