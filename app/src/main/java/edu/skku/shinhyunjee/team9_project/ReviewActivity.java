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
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;
import java.util.Map;

public class ReviewActivity extends AppCompatActivity implements View.OnClickListener{
    SharedPreferences loginPref;
    String user, content;
    EditText userName, reviewWrite;

    private DatabaseReference databaseReference;
    String restaurant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        Intent intent2=getIntent();
        restaurant=intent2.getStringExtra("name");
        userName = (EditText)findViewById(R.id.userName);
        reviewWrite = (EditText)findViewById(R.id.reviewWrite);

        loginPref = getSharedPreferences("login", Activity.MODE_PRIVATE);
        final String user=loginPref.getString("login", null);
        Log.d("CHECK",user);
        Button finish = (Button)findViewById(R.id.Finish);
        finish.setOnClickListener(this);

    }
    public void onClick(View view){
        final Intent intent = new Intent(ReviewActivity.this,RestaurantActivity.class);
        user = userName.getText().toString();
        content = reviewWrite.getText().toString();
        new AlertDialog.Builder(ReviewActivity.this)
                .setTitle("리뷰 작성")
                .setMessage("리뷰 작성이 완료되었습니다.")
                .setNeutralButton("닫기",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dlg, int sumthin) {
                        intent.putExtra("name",restaurant);
                        intent.putExtra("reviewUser",user);
                        intent.putExtra("reviewContent",content);
                        startActivity(intent);
                    }
                })
                .show();
    }
}
