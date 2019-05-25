package edu.skku.shinhyunjee.team9_project;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FoodKindActivity extends AppCompatActivity {
    ListView mListView;
    Button[] mButton = new Button[12];
    ArrayList<RestaurantItem> data;
    RestaurantAdapter adapter;
    private DatabaseReference mPostReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_kind);

        mPostReference = FirebaseDatabase.getInstance().getReference();

        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.KoreanFood:
                        mButton[0].setTypeface(null, Typeface.BOLD);
                        for (int i = 0; i < 12; i++) {
                            if (i != 0)
                                mButton[i].setTypeface(mButton[i].getTypeface(), Typeface.NORMAL);
                            mButton[i].setBackgroundResource(R.drawable.downrightleftlines);
                        }
                        mButton[0].setBackgroundResource(R.drawable.down_gray_lines);
                        mButton[0].setTypeface(null, Typeface.BOLD);
                        mButton[11].setBackgroundResource(R.drawable.down_lines);
                        break;
                    case R.id.Pizza:
                        for (int i = 0; i < 12; i++) {
                            mButton[i].setTypeface(null, Typeface.NORMAL);
                            mButton[i].setBackgroundResource(R.drawable.downrightleftlines);
                        }
                        mButton[1].setBackgroundResource(R.drawable.down_left_right_gray_lines);
                        mButton[1].setTypeface(null, Typeface.BOLD);
                        mButton[0].setBackgroundResource(R.drawable.down_lines);
                        mButton[11].setBackgroundResource(R.drawable.down_lines);
                        break;
                    case R.id.Dessert:
                        for (int i = 0; i < 12; i++) {
                            mButton[i].setTypeface(null, Typeface.NORMAL);
                            mButton[i].setBackgroundResource(R.drawable.downrightleftlines);
                        }
                        mButton[2].setBackgroundResource(R.drawable.down_left_right_gray_lines);
                        mButton[2].setTypeface(null, Typeface.BOLD);
                        mButton[0].setBackgroundResource(R.drawable.down_lines);
                        mButton[11].setBackgroundResource(R.drawable.down_lines);
                        break;
                    case R.id.Snack:
                        for (int i = 0; i < 12; i++) {
                            mButton[i].setTypeface(null, Typeface.NORMAL);
                            mButton[i].setBackgroundResource(R.drawable.downrightleftlines);
                        }
                        mButton[3].setBackgroundResource(R.drawable.down_left_right_gray_lines);
                        mButton[3].setTypeface(null, Typeface.BOLD);
                        mButton[0].setBackgroundResource(R.drawable.down_lines);
                        mButton[11].setBackgroundResource(R.drawable.down_lines);
                        break;
                    case R.id.Chicken:
                        for (int i = 0; i < 12; i++) {
                            mButton[i].setTypeface(null, Typeface.NORMAL);
                            mButton[i].setBackgroundResource(R.drawable.downrightleftlines);
                        }
                        mButton[4].setBackgroundResource(R.drawable.down_left_right_gray_lines);
                        mButton[4].setTypeface(null, Typeface.BOLD);
                        mButton[0].setBackgroundResource(R.drawable.down_lines);
                        mButton[11].setBackgroundResource(R.drawable.down_lines);
                        break;
                    case R.id.ChineseFood:
                        for (int i = 0; i < 12; i++) {
                            mButton[i].setTypeface(null, Typeface.NORMAL);
                            mButton[i].setBackgroundResource(R.drawable.downrightleftlines);
                        }
                        mButton[5].setBackgroundResource(R.drawable.down_left_right_gray_lines);
                        mButton[5].setTypeface(null, Typeface.BOLD);
                        mButton[0].setBackgroundResource(R.drawable.down_lines);
                        mButton[11].setBackgroundResource(R.drawable.down_lines);
                        break;
                    case R.id.JapaneseFood:
                        for (int i = 0; i < 12; i++) {
                            mButton[i].setTypeface(null, Typeface.NORMAL);
                            mButton[i].setBackgroundResource(R.drawable.downrightleftlines);
                        }
                        mButton[6].setBackgroundResource(R.drawable.down_left_right_gray_lines);
                        mButton[6].setTypeface(null, Typeface.BOLD);
                        mButton[0].setBackgroundResource(R.drawable.down_lines);
                        mButton[11].setBackgroundResource(R.drawable.down_lines);
                        break;
                    case R.id.nightFood:
                        for (int i = 0; i < 12; i++) {
                            mButton[i].setTypeface(null, Typeface.NORMAL);
                            mButton[i].setBackgroundResource(R.drawable.downrightleftlines);
                        }
                        mButton[7].setBackgroundResource(R.drawable.down_left_right_gray_lines);
                        mButton[7].setTypeface(null, Typeface.BOLD);
                        mButton[0].setBackgroundResource(R.drawable.down_lines);
                        mButton[11].setBackgroundResource(R.drawable.down_lines);
                        break;
                    case R.id.beef:
                        for (int i = 0; i < 12; i++) {
                            mButton[i].setTypeface(null, Typeface.NORMAL);
                            mButton[i].setBackgroundResource(R.drawable.downrightleftlines);
                        }
                        mButton[8].setBackgroundResource(R.drawable.down_left_right_gray_lines);
                        mButton[8].setTypeface(null, Typeface.BOLD);
                        mButton[0].setBackgroundResource(R.drawable.down_lines);
                        mButton[11].setBackgroundResource(R.drawable.down_lines);
                        break;
                    case R.id.Hamburger:
                        for (int i = 0; i < 12; i++) {
                            mButton[i].setTypeface(null, Typeface.NORMAL);
                            mButton[i].setBackgroundResource(R.drawable.downrightleftlines);
                        }
                        mButton[9].setBackgroundResource(R.drawable.down_left_right_gray_lines);
                        mButton[9].setTypeface(null, Typeface.BOLD);
                        mButton[0].setBackgroundResource(R.drawable.down_lines);
                        mButton[11].setBackgroundResource(R.drawable.down_lines);
                        break;
                    case R.id.lunchBox:
                        for (int i = 0; i < 12; i++) {
                            mButton[i].setTypeface(null, Typeface.NORMAL);
                            mButton[i].setBackgroundResource(R.drawable.downrightleftlines);
                        }
                        mButton[10].setBackgroundResource(R.drawable.down_left_right_gray_lines);
                        mButton[10].setTypeface(null, Typeface.BOLD);
                        mButton[0].setBackgroundResource(R.drawable.down_lines);
                        mButton[11].setBackgroundResource(R.drawable.down_lines);
                        break;
                    case R.id.soup:
                        for (int i = 0; i < 12; i++) {
                            mButton[i].setTypeface(null, Typeface.NORMAL);
                            mButton[i].setBackgroundResource(R.drawable.downrightleftlines);
                        }
                        mButton[11].setBackgroundResource(R.drawable.down_left_right_gray_lines);
                        mButton[11].setTypeface(null, Typeface.BOLD);
                        mButton[0].setBackgroundResource(R.drawable.down_lines);
                        break;
                }
            }
        };

        final Comparator<RestaurantItem> cmpDis = new Comparator<RestaurantItem>() {
            @Override
            public int compare(RestaurantItem r1, RestaurantItem r2) {

                return Double.valueOf(r1.getDis()).compareTo(Double.valueOf(r2.getDis()));
            }
        };
        final Comparator<RestaurantItem> cmpStar = new Comparator<RestaurantItem>() {
            @Override
            public int compare(RestaurantItem r1, RestaurantItem r2) {

                return Double.valueOf(r2.getStar()).compareTo(Double.valueOf(r1.getStar()));
            }
        };

        Intent intent=getIntent();
        String foodKind=intent.getStringExtra("Key");


        Button select = (Button)findViewById(R.id.select);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(),view);
                getMenuInflater().inflate(R.menu.option_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int id=menuItem.getItemId();
                        if(id==R.id.m1){
                            Collections.sort(data,cmpDis);
                            mListView.setAdapter(adapter);
                        }
                        else if(id==R.id.m2){
                            Collections.sort(data,cmpStar);
                            mListView.setAdapter(adapter);
                        }

                        return false;
                    }
                });
                popupMenu.show();

            }
        });

        mButton[0]=(Button)findViewById(R.id.KoreanFood);
        mButton[1]=(Button)findViewById(R.id.Pizza);
        mButton[2]=(Button)findViewById(R.id.Dessert);
        mButton[3]=(Button)findViewById(R.id.Snack);
        mButton[4]=(Button)findViewById(R.id.Chicken);
        mButton[5]=(Button)findViewById(R.id.ChineseFood);
        mButton[6]=(Button)findViewById(R.id.JapaneseFood);
        mButton[7]=(Button)findViewById(R.id.nightFood);
        mButton[8]=(Button)findViewById(R.id.beef);
        mButton[9]=(Button)findViewById(R.id.Hamburger);
        mButton[10]=(Button)findViewById(R.id.lunchBox);
        mButton[11]=(Button)findViewById(R.id.soup);

        for(int i=0;i<12;i++) {
            mButton[i].setOnClickListener(onClickListener);
    }
        for(int i=0;i<12;i++) {
        if (foodKind.equals(mButton[i].getText().toString()))
            mButton[i].performClick();
    }



        mListView=findViewById(R.id.listView);
        data=new ArrayList<RestaurantItem>();

        // getFirebaseDatabase에 의해 사라짐
        RestaurantItem r1=new RestaurantItem("밥톨이",3.4,"돈까스/회/일식",1.2);
        data.add(r1);
        RestaurantItem r2=new RestaurantItem("야미",4.7,"돈까스/회/일식",2.5);
        data.add(r2);


        adapter = new RestaurantAdapter(this,data);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(FoodKindActivity.this, RestaurantActivity.class);
                intent.putExtra("Key",data.get(i).getName());
                startActivity(intent);
            }
        });

        getFirebaseDatabase();

    }

    //yujin
    public void getFirebaseDatabase(){
        final ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                data.clear();
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    Log.d("getFirebaseDatabase","key: "+ds.getKey());
                    RestaurantPost get = ds.getValue(RestaurantPost.class);
                    RestaurantItem ri = new RestaurantItem(get.name,get.star,"content",0); // temporary distance 0
                    data.add(ri);
                }
                mListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mPostReference.child("FoodKind").child("KoreanFood").addValueEventListener(postListener);
    }

}
