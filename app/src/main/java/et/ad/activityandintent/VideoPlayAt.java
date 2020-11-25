package et.ad.activityandintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.Nullable;

public class VideoPlayAt extends Activity {
    private Button btn;
    private VideoView videoV;
    private Boolean isPlay=false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_play);

        btn =(Button)findViewById(R.id.btnPlayPause);
        videoV =(VideoView)findViewById(R.id.videoV);
        String filePath="android.resource://et.ad.activityandintent/"+R.raw.videoplayback;
        Uri uri =Uri.parse(filePath);
        videoV.setVideoURI(uri);
        videoV.requestFocus();
        MediaController mController = new MediaController(VideoPlayAt.this);
        mController.setAnchorView(videoV);
        videoV.setMediaController(mController);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               isPlay=!isPlay;
               if(isPlay){
                    videoV.start();
                }
               else {
                   videoV.pause();
               }
            }
        });
    }
}
