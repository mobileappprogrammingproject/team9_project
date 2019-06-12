package edu.skku.shinhyunjee.team9_project;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.sip.SipSession;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.ref.Reference;
import java.util.HashMap;
import java.util.Map;

public class ReviewActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences loginPref;
    String name="", content="", score = "";
    EditText reviewWrite; TextView userName;
    private DatabaseReference postReference;
    Integer count = null; Double sum = null;
    TextView restaurantName;

    private DatabaseReference databaseReference;
    String restaurant;
    String[] scores;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        postReference = FirebaseDatabase.getInstance().getReference();
        restaurantName = (TextView)findViewById(R.id.restaurantName);
        userName = (TextView) findViewById(R.id.userName);
        reviewWrite = (EditText)findViewById(R.id.reviewWrite);
        spinner = (Spinner)findViewById(R.id.spinner);

        Intent intent2=getIntent();
        restaurant=intent2.getStringExtra("name");
        restaurantName.setText(restaurant);


        scores = new String[]{"선택","1","2","3","4","5"};
        ArrayAdapter spinner_adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,scores);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinner_adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spinner.getSelectedItemPosition() > 0)
                    score = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        loginPref = getSharedPreferences("login", Activity.MODE_PRIVATE);
        final String user=loginPref.getString("login", null);
        Log.d("CHECK",user);
        userName.setText(user);
        Button finish = (Button)findViewById(R.id.Finish);
        finish.setOnClickListener(this);

        getReviewData(restaurant);

    }
    public void onClick(View view){
        final Intent intent = new Intent(ReviewActivity.this,RestaurantActivity.class);
        name = userName.getText().toString();
        content = reviewWrite.getText().toString();

        if(score.length() == 0){
            Toast.makeText(ReviewActivity.this,"점수를 선택하세요",Toast.LENGTH_LONG).show();
        }
        else if (name.length()==0)
            Toast.makeText(ReviewActivity.this,"이름을 입력하세요",Toast.LENGTH_LONG).show();
        else if (content.length() == 0)
            Toast.makeText(ReviewActivity.this,"내용을 입력하세요",Toast.LENGTH_LONG).show();
        else{
            sum += Double.parseDouble(score);
            postReviewData(restaurant);
            new AlertDialog.Builder(ReviewActivity.this)
                    .setTitle("리뷰 작성")
                    .setMessage("리뷰 작성이 완료되었습니다.")
                    .setNeutralButton("닫기",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dlg, int sumthin) {
                            //intent.putExtra("name",restaurant);
                            //startActivity(intent);
                            finish();
                        }
                    })
                    .show();
        }
    }


    public void getReviewData(String restaurant){
        final ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot rds : dataSnapshot.getChildren()){
                    Log.d("getEvaluations","key: "+ rds.getKey()+" value: "+rds.getValue());
                    if(rds.getKey().equals("cnt")) count = rds.getValue(Integer.class);
                    else if (rds.getKey().equals("sum")) sum = rds.getValue(Double.class);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        postReference.child("restaurant_list").child(restaurant).child("evaluation").addValueEventListener(postListener);

    }

    public void postReviewData(String restaurant){
        count++;
        int cnt = count -1;
        Map<String, Object> childUpdates = new HashMap<>();
        ReviewPost post = new ReviewPost(content, name, Double.parseDouble(score)); // temp star
        Map<String, Object> postValue = post.toMap();
        childUpdates.put("/restaurant_list/"+restaurant+"/evaluation/review_list/"+cnt, postValue);
        childUpdates.put("/restaurant_list/"+restaurant+"/evaluation/cnt",count);
        childUpdates.put("/restaurant_list/"+restaurant+"/evaluation/sum",sum);
        if(count != 0) childUpdates.put("/restaurant_list/"+restaurant+"/star",sum/count);
        postReference.updateChildren(childUpdates);
    }
}
