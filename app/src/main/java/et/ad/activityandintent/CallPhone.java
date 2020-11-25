package et.ad.activityandintent;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

public class CallPhone extends Activity implements View.OnClickListener {
    private EditText etPhoneInsert;
    private Button btnCall, btnCheckBill;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_phone);
        btnCall = (Button) findViewById(R.id.btnCall);
        btnCheckBill = (Button) findViewById(R.id.btnCheckBill);
        etPhoneInsert = (EditText) findViewById(R.id.etPhoneInput);

        btnCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCall:
                String str = etPhoneInsert.getText().toString().trim();
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + str));
                    startActivity(i);
                break;
            case R.id.btnCheckBill:
                String code = Uri.encode("#");
                String st ="*124"+code;
                Intent intent = new Intent((Intent.ACTION_DIAL));
                intent.setData(Uri.parse("tel:"+st));
                startActivity(intent);
                break;
        }

    }
}
