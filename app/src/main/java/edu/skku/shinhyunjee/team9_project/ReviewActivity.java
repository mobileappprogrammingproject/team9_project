package edu.skku.shinhyunjee.team9_project;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.sip.SipSession;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReviewActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        Button finish = (Button)findViewById(R.id.Finish);
        finish.setOnClickListener(this);

    }
    public void onClick(View view){
        final Intent intent = new Intent(ReviewActivity.this,RestaurantActivity.class);
        new AlertDialog.Builder(ReviewActivity.this)
                .setTitle("리뷰 작성")
                .setMessage("리뷰 작성이 완료되었습니다.")
                .setNeutralButton("닫기",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dlg, int sumthin) {
                        startActivity(intent);
                    }
                })
                .show();
    }
}
