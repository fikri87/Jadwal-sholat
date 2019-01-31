package info.blogbasbas.carimasjid.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import info.blogbasbas.carimasjid.R;

public class AlarmNotifikasi extends Service {

    @SuppressLint("ResourceType")
    MediaPlayer mediaPlayer;

    public AlarmNotifikasi() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer = MediaPlayer.create(AlarmNotifikasi.this,R.raw.adzan);
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        Toast.makeText(this, "service onDestroy", Toast.LENGTH_SHORT).show();

    }
}
