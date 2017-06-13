package com.example.logonrm.appalarme;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void disparar(View view){
        EditText text = (EditText)findViewById(R.id.etTempo);

        int i= Integer.parseInt(text.getText().toString());

        Intent intent = new Intent(this,AlarmeReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(),0,intent,0);

        AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i*1000), pendingIntent);

        Toast.makeText(this.getApplicationContext(),"Alarm set in " + i + " seconds.", Toast.LENGTH_LONG).show();
    }

    public void startService(View view){
        Intent intent = new Intent(this,LoggerService.class);
        startService(intent);
        Toast.makeText(this, "*****Serviço iniciando*****", Toast.LENGTH_SHORT).show();
    }

    public void stopService(View view){
        Intent intent = new Intent(this,LoggerService.class);
        stopService(intent);

        Toast.makeText(this, "*****Serviço encerrando*****", Toast.LENGTH_SHORT).show();
    }
}
