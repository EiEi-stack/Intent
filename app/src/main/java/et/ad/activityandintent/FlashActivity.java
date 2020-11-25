package et.ad.activityandintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class FlashActivity extends AppCompatActivity {
    MediaPlayer mp =new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        TextView tvSlide = findViewById(R.id.tvSlide);
        tvSlide.setSelected(true);
        mp=MediaPlayer.create(this,R.raw.videoplayback);
        mp.start();
        Thread td = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    mp.pause();
                    Intent intent=new Intent(FlashActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        td.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
    }
}
