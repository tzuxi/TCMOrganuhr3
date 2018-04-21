package com.javisdce.tcmorganuhr3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView output, next_active, now_active, next_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = findViewById(R.id.output);
        next_active = findViewById(R.id.next_active);
        now_active = findViewById(R.id.now_active);
        next_time = findViewById(R.id.next_time);

        final Intent intent = new Intent(this, NotificationService.class);
        startService(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final Thread thread = new Thread(new Runnable() {
            Handler handler = new Handler();
            Time time = new Time();
            @Override
            public void run() {
                while(true){
                    time.setToNow();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            switch (time.hour) {
                                case 1:
                                case 2:
                                    output.setText(Data.einsbisdrei);
                                    now_active.setText(Data.topiceinsbisdrei);
                                    next_active.setText(Data.topicdreibisfünf);
                                    next_time.setText("um 3 Uhr");
                                    break;
                                case 3:
                                case 4:
                                    output.setText(Data.dreibisfünf);
                                    now_active.setText(Data.topicdreibisfünf);
                                    next_active.setText(Data.topicfünfbissieben);
                                    next_time.setText("um 5 Uhr");
                                    break;
                                case 5:
                                case 6:
                                    output.setText(Data.fünfbissieben);
                                    now_active.setText(Data.topicfünfbissieben);
                                    next_active.setText(Data.topicsiebenbisneun);
                                    next_time.setText("um 7 Uhr");
                                    break;
                                case 7:
                                case 8:
                                    output.setText(Data.siebenbisneun);
                                    now_active.setText(Data.topicsiebenbisneun);
                                    next_active.setText(Data.topicneunbiself);
                                    next_time.setText("um 9 Uhr");
                                    break;
                                case 9:
                                case 10:
                                    output.setText(Data.neunbiself);
                                    now_active.setText(Data.topicneunbiself);
                                    next_active.setText(Data.topicelfbisdreizehn);
                                    next_time.setText("um 11 Uhr");
                                    break;
                                case 11:
                                case 12:
                                    output.setText(Data.elfbisdreizehn);
                                    now_active.setText(Data.topicelfbisdreizehn);
                                    next_active.setText(Data.topicdreizehnbisfünfzehn);
                                    next_time.setText("um 13 Uhr");
                                    break;
                                case 13:
                                case 14:
                                    output.setText(Data.dreizehnbisfünfzehn);
                                    now_active.setText(Data.topicdreizehnbisfünfzehn);
                                    next_active.setText(Data.topicfünfzehnbissiebzehn);
                                    next_time.setText("um 15 Uhr");
                                    break;
                                case 15:
                                case 16:
                                    output.setText(Data.fünfzehbissiebzehn);
                                    now_active.setText(Data.topicfünfzehnbissiebzehn);
                                    next_active.setText(Data.topicsiebzehnbisneunzehn);
                                    next_time.setText("um 17 Uhr");
                                    break;
                                case 17:
                                case 18:
                                    output.setText(Data.siebzehnbisneunzehn);
                                    now_active.setText(Data.topicsiebzehnbisneunzehn);
                                    next_active.setText(Data.topicneunzehnbiseinundzwanzig);
                                    next_time.setText("um 19 Uhr");
                                    break;
                                case 19:
                                case 20:
                                    output.setText(Data.neunzehnbiseinundzwanzig);
                                    now_active.setText(Data.topicneunzehnbiseinundzwanzig);
                                    next_active.setText(Data.topiceinundzwanzigbisdreiundzwanzig);
                                    next_time.setText("um 21 Uhr");
                                    break;
                                case 21:
                                case 22:
                                    output.setText(Data.einundzwanzigbisdreiundzwanzig);
                                    now_active.setText(Data.topiceinundzwanzigbisdreiundzwanzig);
                                    next_active.setText(Data.topicdreiundzwanzigbiseins);
                                    next_time.setText("um 23 Uhr");
                                    break;
                                case 23:
                                case 24:
                                    output.setText(Data.dreiundzwanzigbiseins);
                                    now_active.setText(Data.topicdreiundzwanzigbiseins);
                                    next_active.setText(Data.topiceinsbisdrei);
                                    next_time.setText("um 1 Uhr");
                                    break;
                            }
                        }
                    });
                    try {
                        Thread.sleep(3600000-time.minute*60000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
}
