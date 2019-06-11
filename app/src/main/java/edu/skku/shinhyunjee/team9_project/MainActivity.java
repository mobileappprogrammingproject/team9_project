package edu.skku.shinhyunjee.team9_project;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    SharedPreferences loginPref;

    class BtnOnClickListener implements Button.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(MainActivity.this,FoodKindActivity.class);
            switch (view.getId()){
                case R.id.KoreanFood:
                    intent.putExtra("Key","한식");
                    break;
                case R.id.Pizza:
                    intent.putExtra("Key","피자");
                    break;
                case R.id.Dessert:
                    intent.putExtra("Key","카페/디저트");
                    break;
                case R.id.Snack:
                    intent.putExtra("Key","분식");
                    break;
                case R.id.Chicken:
                    intent.putExtra("Key","치킨");
                    break;
                case R.id.ChineseFood:
                    intent.putExtra("Key","중국집");
                    break;
                case R.id.JapaneseFood:
                    intent.putExtra("Key","돈까스/회/일식");
                    break;
                case R.id.nightFood:
                    intent.putExtra("Key","야식");
                    break;
                case R.id.beef:
                    intent.putExtra("Key","보쌈/족발");
                    break;
                case R.id.Hamburger:
                    intent.putExtra("Key","패스트푸드");
                    break;
                case R.id.lunchBox:
                    intent.putExtra("Key","도시락");
                    break;
                case R.id.soup:
                    intent.putExtra("Key","찜/탕");
                    break;


            }
            startActivity(intent);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.roulette);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(MainActivity.this,RouletteActivity.class);
                startActivity(intent2);
            }
        });
        Button logout=(Button)findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPref = getSharedPreferences("login", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = loginPref.edit();
                editor.remove("login");
                editor.commit();
                Intent intent3 = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent3);
                Toast.makeText(MainActivity.this, "로그아웃되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        BtnOnClickListener oonClickListener = new BtnOnClickListener();

        Button button1=(Button)findViewById(R.id.KoreanFood);
        Button button2=(Button)findViewById(R.id.Pizza);
        Button button3=(Button)findViewById(R.id.Dessert);
        Button button4=(Button)findViewById(R.id.Snack);
        Button button5=(Button)findViewById(R.id.Chicken);
        Button button6=(Button)findViewById(R.id.ChineseFood);
        Button button7=(Button)findViewById(R.id.JapaneseFood);
        Button button8=(Button)findViewById(R.id.nightFood);
        Button button9=(Button)findViewById(R.id.beef);
        Button button10=(Button)findViewById(R.id.Hamburger);
        Button button11=(Button)findViewById(R.id.lunchBox);
        Button button12=(Button)findViewById(R.id.soup);


        button1.setOnClickListener(oonClickListener);
        button2.setOnClickListener(oonClickListener);
        button3.setOnClickListener(oonClickListener);
        button4.setOnClickListener(oonClickListener);
        button5.setOnClickListener(oonClickListener);
        button6.setOnClickListener(oonClickListener);
        button7.setOnClickListener(oonClickListener);
        button8.setOnClickListener(oonClickListener);
        button9.setOnClickListener(oonClickListener);
        button10.setOnClickListener(oonClickListener);
        button11.setOnClickListener(oonClickListener);
        button12.setOnClickListener(oonClickListener);


    }

}
