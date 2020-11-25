package et.ad.activityandintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class SendingMailFromPhone extends Activity {
    private EditText etEmail,etSubject,etMessage;
    private Button btnSendEmail;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sendmailfromphone);
        etEmail =(EditText)findViewById(R.id.etEmail);
        etSubject =(EditText)findViewById(R.id.etSubject);
        etMessage =(EditText)findViewById(R.id.etMessage);
        btnSendEmail=(Button)findViewById(R.id.btnSendEmail);
        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strMail =etEmail.getText().toString().trim();
                String []address =strMail.split(",");
                String subject =etSubject.getText().toString();
                String message =etMessage.getText().toString();

                Intent i = new Intent(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_EMAIL,address);
                i.putExtra(Intent.EXTRA_SUBJECT,subject);
                i.putExtra(Intent.EXTRA_TEXT,message);
                i.setType("plain/text");
                Intent chooser =Intent.createChooser(i,"Choose Main Provider");
                startActivity(chooser);
            }
        });
    }
}
