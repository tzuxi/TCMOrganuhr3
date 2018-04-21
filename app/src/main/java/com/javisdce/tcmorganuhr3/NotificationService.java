package com.javisdce.tcmorganuhr3;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.text.format.Time;
import android.widget.Toast;


public class NotificationService extends Service {



    @Override
    public void onCreate(){


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){

        Handler handler = new Handler();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    Time time = new Time();
                    time.setToNow();

                    Intent notifIntent = new Intent(NotificationService.super.getBaseContext(), MainActivity.class);
                    notifIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    PendingIntent notifPendIntent = PendingIntent.getActivity(NotificationService.super.getBaseContext(), 0, notifIntent, 0);



                    NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(NotificationService.super.getBaseContext(), "channel1")
                            .setSmallIcon(R.drawable.ic_action_name)
                            .setContentTitle("Qi: " + getTopic(time.hour))
                            .setContentText(getShort(time.hour))
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                            .setContentIntent(notifPendIntent);


                    //.setDeleteIntent()

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(NotificationService.super.getBaseContext());
                    managerCompat.notify(1, nBuilder.build());
                    try {
                        Thread.sleep(3600000-time.minute*60000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        thread.start();
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy(){
        Toast.makeText(this, "ended", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    private String getTopic(int _hour){
        switch (_hour) {
            case 1:
            case 2:
                return Data.topiceinsbisdrei;
                
            case 3:
            case 4:
                return Data.topicdreibisfünf;
                
            case 5:
            case 6:
                return Data.topicfünfbissieben;
                
            case 7:
            case 8:
                return Data.topicsiebenbisneun;
                
            case 9:
            case 10:
                return Data.topicneunbiself;
                
            case 11:
            case 12:
                return Data.topicelfbisdreizehn;
                
            case 13:
            case 14:
                return Data.topicdreizehnbisfünfzehn;
                
            case 15:
            case 16:
                return Data.topicfünfzehnbissiebzehn;
                
            case 17:
            case 18:
                return Data.topicsiebzehnbisneunzehn;
                
            case 19:
            case 20:
                return Data.topicneunzehnbiseinundzwanzig;
                
            case 21:
            case 22:
                return Data.topiceinundzwanzigbisdreiundzwanzig;
                
            case 23:
            case 24:
                return Data.topicdreiundzwanzigbiseins;
                
            default:
                return null;
        }
    }

    private String getShort(int _hour){
        switch (_hour) {
            case 1:
            case 2:
                return Data.shorteinsbisdrei;

            case 3:
            case 4:
                return Data.shortdreibisfünf;

            case 5:
            case 6:
                return Data.shortfünfbissieben;

            case 7:
            case 8:
                return Data.shortsiebenbisneun;

            case 9:
            case 10:
                return Data.shortneunbiself;

            case 11:
            case 12:
                return Data.shortelfbisdreizehn;

            case 13:
            case 14:
                return Data.shortdreizehnbisfünfzehn;

            case 15:
            case 16:
                return Data.shortfünfzehnbissiebzehn;

            case 17:
            case 18:
                return Data.shortsiebzehnbisneunzehn;

            case 19:
            case 20:
                return Data.shortneunzehnbiseinundzwanzig;

            case 21:
            case 22:
                return Data.shorteinundzwanzigbisdreiundzwanzig;

            case 23:
            case 24:
                return Data.shortdreiundzwanzigbiseins;

            default:
                return null;
        }
    }
}
