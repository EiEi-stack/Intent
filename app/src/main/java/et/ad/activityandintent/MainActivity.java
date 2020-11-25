package et.ad.activityandintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private RadioGroup rGroup;
    private TextView tvChoose;
    private Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rGroup = (RadioGroup) findViewById(R.id.rGroup);
        tvChoose = (TextView) findViewById(R.id.tvChoose);
        btnGo = (Button) findViewById(R.id.btnGo);

        rGroup.setOnCheckedChangeListener(this);
        btnGo.setOnClickListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rPhoneCall:
                Intent i = new Intent(MainActivity.this, CallPhone.class);
                startActivity(i);
                break;
            case R.id.rSendEmail:
                Intent intent=new Intent(MainActivity.this,SendingMailFromPhone.class);
                startActivity(intent);
                break;
            case R.id.rsendDrawablePics:
                sendPicsFromDrawable();
                break;
            case R.id.rSendSdCardPis:
                sendSDCardPic();
                break;
            case R.id.rVideoPlay:
                Intent intent1=new Intent(MainActivity.this,VideoPlayAt.class);
                startActivity(intent1);
                break;

        }
    }

    private void sendSDCardPic() {
        File f = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String[] arr = f.list();
        ArrayList<Uri> arrlist = new ArrayList<Uri>();
        Uri uri;
        //one.png
        //two.png
        //three.png
        for(String picture:arr){
            uri=Uri.parse("file://"+arr.toString()+"/"+picture);
            arrlist.add(uri);

        }
        Intent i=new Intent(Intent.ACTION_SEND_MULTIPLE);
        i.putExtra(Intent.EXTRA_STREAM,arrlist);
        i.setType("image/*");
        Intent chooser = Intent.createChooser(i,"Choose the Pic");
        startActivity(chooser);
    }

    private void sendPicsFromDrawable() {

        Uri uri = Uri.parse("android.resource://et.ad.activityandintent/drawable/+R.drawable.ic_launcher");
        Intent i = new Intent(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_STREAM, uri);
        i.putExtra(Intent.EXTRA_TEXT, "I am biberkolar, send this from my coolpad!");
        i.setType("image/*");
        Intent chooser = Intent.createChooser(i, "Choose App");
        startActivity(chooser);
    }


    @Override
    public void onClick(View v) {

    }
}
