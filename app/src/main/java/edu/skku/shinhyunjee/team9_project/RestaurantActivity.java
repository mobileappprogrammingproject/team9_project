package edu.skku.shinhyunjee.team9_project;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RestaurantActivity extends AppCompatActivity {
    TextView text;
    private void changeView(int index) {
        ListView menuList=(ListView)findViewById(R.id.menuList);
        TextView textView2 = (TextView) findViewById(R.id.information) ;
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraint);

        switch (index) {
            case 0 :
                menuList.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.INVISIBLE);
                constraintLayout.setVisibility(View.INVISIBLE);
                break;
            case 1 :
                menuList.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.VISIBLE);
                constraintLayout.setVisibility(View.INVISIBLE);
                break ;
            case 2 :
                menuList.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.INVISIBLE) ;
                constraintLayout.setVisibility(View.VISIBLE);
                break ;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        Button call = (Button)findViewById(R.id.call);
        final Drawable drawable = getResources().getDrawable(R.drawable.call);
        final float density = getResources().getDisplayMetrics().density;
        final int width = Math.round(10 * density);
        final int height = Math.round(10 * density);
        drawable.setBounds(0, 0, width, height);
        call.setCompoundDrawables(drawable, null, null, null);
        Intent intent2=getIntent();
        String restaurant=intent2.getStringExtra("Key");
        text=findViewById(R.id.textView);
        text.setText(restaurant);
        changeView(0);
        final Button button1=(Button)findViewById(R.id.menu);
        final Button button2 = (Button) findViewById(R.id.info) ;
        final Button button3=(Button)findViewById(R.id.review);
        button1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                changeView(0) ;
            }
        });
        button1.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    button1.setBackgroundResource(R.drawable.down_lines);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    button1.setBackgroundResource(R.drawable.down_gray_lines);
                    button2.setBackgroundResource(R.drawable.downrightleftlines);
                    button3.setBackgroundResource(R.drawable.down_lines);
                }
                return false;
            }
        });
        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeView(1) ;
            }
        });
        button2.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    button2.setBackgroundResource(R.drawable.downrightleftlines);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    button1.setBackgroundResource(R.drawable.down_lines);
                    button2.setBackgroundResource(R.drawable.down_left_right_gray_lines);
                    button3.setBackgroundResource(R.drawable.down_lines);
                }
                return false;
            }
        });

        button3.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View V){
                changeView(2);
                Button button4=(Button)findViewById(R.id.reviewWR);
                button4.setOnClickListener(new Button.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent intent3=new Intent(RestaurantActivity.this,ReviewActivity.class);
                        startActivity(intent3);
                    }
                });
            }
        });
        button3.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                   button3.setBackgroundResource(R.drawable.down_gray_lines);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    button1.setBackgroundResource(R.drawable.down_lines);
                    button3.setBackgroundResource(R.drawable.down_gray_lines);
                    button2.setBackgroundResource(R.drawable.downrightleftlines);
                }
                return false;
            }
        });
    }
}
