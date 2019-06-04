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
    ArrayList<RestaurantItem> data[] = new ArrayList[12];
    RestaurantAdapter adapter[] = new RestaurantAdapter[12];
    private DatabaseReference mPostReference;
    String[] foodKindName = {"KoreanFood","Pizza","Dessert","Snack","Chicken","ChineseFood","JapaneseFood","nightFood","beef","Hamburger","lunchBox","soup"};
    String[] content = {"한식","피자","카페/디저트","분식","치킨","중국집","돈까스/회/일식","야식","보쌈/족발","패스트푸드","도시락","찜/탕"};
    ArrayList<RestaurantItem> temp = new ArrayList<RestaurantItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_kind);

        mPostReference = FirebaseDatabase.getInstance().getReference();
        for(int i=0;i<12;i++) data[i] = new ArrayList<RestaurantItem>(); // arraylist array initialize

        //set adapter and listview
        mListView=findViewById(R.id.listView);
        for(int k=0;k<12;k++) {
            temp = data[k];
            adapter[k] = new RestaurantAdapter(this, data[k]);
            /*mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                    Intent intent = new Intent(FoodKindActivity.this, RestaurantActivity.class);
                    RestaurantItem ri = temp.get(i);
                    intent.putExtra("name", ri.getName()); //  send a restaurant name to next activity
                    startActivity(intent);
                }
            });*/
        }

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
                        getFirebaseDatabase(0,foodKindName[0],content[0]);
                        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                                Intent intent = new Intent(FoodKindActivity.this, RestaurantActivity.class);
                                RestaurantItem ri = data[0].get(i);
                                intent.putExtra("name", ri.getName()); //  send a restaurant name to next activity
                                intent.putExtra("number",ri.getNumber());
                                startActivity(intent);
                            }
                        });
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
                        getFirebaseDatabase(1,foodKindName[1],content[1]);
                        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                                Intent intent = new Intent(FoodKindActivity.this, RestaurantActivity.class);
                                RestaurantItem ri = data[1].get(i);
                                intent.putExtra("name", ri.getName()); //  send a restaurant name to next activity
                                intent.putExtra("number",ri.getNumber());
                                startActivity(intent);
                            }
                        });
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
                        getFirebaseDatabase(2,foodKindName[2],content[2]);
                        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                                Intent intent = new Intent(FoodKindActivity.this, RestaurantActivity.class);
                                RestaurantItem ri = data[2].get(i);
                                intent.putExtra("name", ri.getName()); //  send a restaurant name to next activity
                                intent.putExtra("number",ri.getNumber());
                                startActivity(intent);
                            }
                        });
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
                        getFirebaseDatabase(3,foodKindName[3],content[3]);
                        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                                Intent intent = new Intent(FoodKindActivity.this, RestaurantActivity.class);
                                RestaurantItem ri = data[3].get(i);
                                intent.putExtra("name", ri.getName()); //  send a restaurant name to next activity
                                intent.putExtra("number",ri.getNumber());
                                startActivity(intent);
                            }
                        });
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
                        getFirebaseDatabase(4,foodKindName[4],content[4]);
                        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                                Intent intent = new Intent(FoodKindActivity.this, RestaurantActivity.class);
                                RestaurantItem ri = data[4].get(i);
                                intent.putExtra("name", ri.getName()); //  send a restaurant name to next activity
                                intent.putExtra("number",ri.getNumber());
                                startActivity(intent);
                            }
                        });
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
                        getFirebaseDatabase(5,foodKindName[5],content[5]);
                        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                                Intent intent = new Intent(FoodKindActivity.this, RestaurantActivity.class);
                                RestaurantItem ri = data[5].get(i);
                                intent.putExtra("name", ri.getName()); //  send a restaurant name to next activity
                                intent.putExtra("number",ri.getNumber());
                                startActivity(intent);
                            }
                        });
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
                        getFirebaseDatabase(6,foodKindName[6],content[6]);
                        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                                Intent intent = new Intent(FoodKindActivity.this, RestaurantActivity.class);
                                RestaurantItem ri = data[6].get(i);
                                intent.putExtra("name", ri.getName()); //  send a restaurant name to next activity
                                intent.putExtra("number",ri.getNumber());

                                startActivity(intent);
                            }
                        });
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
                        getFirebaseDatabase(7,foodKindName[7],content[7]);
                        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                            Intent intent = new Intent(FoodKindActivity.this, RestaurantActivity.class);
                            RestaurantItem ri = data[7].get(i);
                            intent.putExtra("name", ri.getName()); //  send a restaurant name to next activity
                            intent.putExtra("number",ri.getNumber());

                            startActivity(intent);
                        }
                    });
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
                        getFirebaseDatabase(8,foodKindName[8],content[8]);
                        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                                Intent intent = new Intent(FoodKindActivity.this, RestaurantActivity.class);
                                RestaurantItem ri = data[8].get(i);
                                intent.putExtra("name", ri.getName()); //  send a restaurant name to next activity
                                intent.putExtra("number",ri.getNumber());

                                startActivity(intent);
                            }
                        });
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
                        getFirebaseDatabase(9,foodKindName[9],content[9]);
                        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                                Intent intent = new Intent(FoodKindActivity.this, RestaurantActivity.class);
                                RestaurantItem ri = data[9].get(i);
                                intent.putExtra("name", ri.getName()); //  send a restaurant name to next activity
                                intent.putExtra("number",ri.getNumber());

                                startActivity(intent);
                            }
                        });
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
                        getFirebaseDatabase(10,foodKindName[10],content[10]);
                        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                                Intent intent = new Intent(FoodKindActivity.this, RestaurantActivity.class);
                                RestaurantItem ri = data[10].get(i);
                                intent.putExtra("name", ri.getName()); //  send a restaurant name to next activity
                                intent.putExtra("number",ri.getNumber());

                                startActivity(intent);
                            }
                        });
                        break;
                    case R.id.soup:
                        for (int i = 0; i < 12; i++) {
                            mButton[i].setTypeface(null, Typeface.NORMAL);
                            mButton[i].setBackgroundResource(R.drawable.downrightleftlines);
                        }
                        mButton[11].setBackgroundResource(R.drawable.down_left_right_gray_lines);
                        mButton[11].setTypeface(null, Typeface.BOLD);
                        mButton[0].setBackgroundResource(R.drawable.down_lines);
                        getFirebaseDatabase(11,foodKindName[11], content[11]);
                        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                                Intent intent = new Intent(FoodKindActivity.this, RestaurantActivity.class);
                                RestaurantItem ri = data[11].get(i);
                                intent.putExtra("name", ri.getName()); //  send a restaurant name to next activity
                                intent.putExtra("number",ri.getNumber());

                                startActivity(intent);
                            }
                        });
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
                return 0;
                //return Double.valueOf(r2.getEvaluation()[0].getStar()).compareTo(Double.valueOf(r1.getEvaluation()[0].getStar()));
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
                        for(int i=0;i<12;i++) {
                            if (id == R.id.m1) {
                                Collections.sort(data[i], cmpDis);
                                mListView.setAdapter(adapter[i]);
                            } else if (id == R.id.m2) {
                                Collections.sort(data[i], cmpStar);
                                mListView.setAdapter(adapter[i]);
                            }
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
        if (foodKind.equals(mButton[i].getText().toString())) {
            mButton[i].performClick();
            getFirebaseDatabase(i,foodKindName[i], content[i]);
            break;
        }
    }

    }

    //yujin
    public void getFirebaseDatabase(final int num, String child, final String content){
        final ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                data[num].clear();
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    Log.d("getFirebaseDatabase","key: "+ds.getKey());
                    RestaurantPost get = ds.getValue(RestaurantPost.class);
                    RestaurantItem ri = new RestaurantItem(get.name,get.info, get.location,get.business_hours,get.number,get.kind,get.star); // temporary distance 0
                    for(String retval : content.split("/")) {
                        if (get.kind.contains(retval)) {
                            data[num].add(ri);
                        }
                    }
                }
                mListView.setAdapter(adapter[num]);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mPostReference.child("restaurant_list").addValueEventListener(postListener);
    }

}

