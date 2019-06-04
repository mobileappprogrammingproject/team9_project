package edu.skku.shinhyunjee.team9_project;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.sip.SipSession;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;

public class ReviewActivity extends AppCompatActivity implements View.OnClickListener{
    SharedPreferences loginPref;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        loginPref = getSharedPreferences("login", Activity.MODE_PRIVATE);
        final String user=loginPref.getString("login", null);
        Log.d("CHECK",user);
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
