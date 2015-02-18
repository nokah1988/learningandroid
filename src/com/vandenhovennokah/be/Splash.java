
package com.vandenhovennokah.be;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity {
    
    MediaPlayer ourSong;
    
    @Override
    protected void onCreate(Bundle NokahLoveBacon) {
        
        //To change body of generated methods, choose Tools | Templates.
        super.onCreate(NokahLoveBacon);
        setContentView(R.layout.splash);
        ourSong = MediaPlayer.create(Splash.this, R.raw.titanic);
        ourSong.start();
        
        Thread timer;
        timer = new Thread() {
            
            public void run() {
                try {
                    sleep(25000);                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent openStartingPoint = new Intent("com.vandenhovennokah.be.STARTINGPOINT");
                    startActivity(openStartingPoint);
                }
            }        
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        //To change body of generated methods, choose Tools | Templates.
        super.onPause();
        ourSong.release();        
        finish();
    }
}
