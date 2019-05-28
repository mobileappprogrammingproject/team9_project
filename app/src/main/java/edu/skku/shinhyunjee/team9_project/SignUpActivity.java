package edu.skku.shinhyunjee.team9_project;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class SignUpActivity extends AppCompatActivity {
    private DatabaseReference databaseReference;
    EditText id;
    EditText name;
    EditText birth;
    EditText pw;
    EditText pwc;
    Button btnDone;
    String key;
    int check=0;
    ArrayList<String> data;
    ArrayAdapter<String> arrayAdapter;
    private ValueEventListener checkRegister = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                Iterator<DataSnapshot> child = dataSnapshot.getChildren().iterator();
                while (child.hasNext()) {
                    if (id.getText().toString().equals(child.next().getKey())) {
                        Toast.makeText(getApplicationContext(), "존재하는 아이디 입니다.", Toast.LENGTH_LONG).show();
                        databaseReference.removeEventListener(this);
                        return;
                    }
                }
                makeNewId();
            }

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
        }
    };

    void makeNewId()
    {
        Log.d("ALARM","SUCCESS");
        databaseReference.child(id.getText().toString()).child("name").setValue(name.getText().toString());
        databaseReference.child(id.getText().toString()).child("pw").setValue(pw.getText().toString());
        databaseReference.child(id.getText().toString()).child("birth").setValue(birth.getText().toString());
        Intent result = new Intent();
        Toast.makeText(SignUpActivity.this, "가입이 완료되었습니다", Toast.LENGTH_SHORT).show();
        // 자신을 호출한 Activity로 데이터를 보낸다.
        result.putExtra("id", id.getText().toString());
        setResult(RESULT_OK, result);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        id=findViewById(R.id.id);
        name=findViewById(R.id.name);
        pw=findViewById(R.id.pw);
        pwc=findViewById(R.id.pwc);
        birth=findViewById(R.id.birth);
        btnDone = findViewById(R.id.check);

        databaseReference  = FirebaseDatabase.getInstance().getReference("user_info");

        pwc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = pw.getText().toString();
                String confirm = pwc.getText().toString();

                if( password.equals(confirm) ) {
                    pw.setBackgroundColor(Color.parseColor("#A3E4D7"));
                    pwc.setBackgroundColor(Color.parseColor("#A3E4D7"));
                } else {
                    pw.setBackgroundColor(Color.parseColor("#EC7063"));
                    pwc.setBackgroundColor(Color.parseColor("#EC7063"));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( name.getText().toString().length() == 0 ) {
                    Toast.makeText(SignUpActivity.this, "이름을 입력하세요!", Toast.LENGTH_SHORT).show();
                    name.requestFocus();
                    return;
                }
                if( id.getText().toString().length() == 0 ) {
                    Toast.makeText(SignUpActivity.this, "아이디를 입력하세요!", Toast.LENGTH_SHORT).show();
                    id.requestFocus();
                    return;
                }
                // 비밀번호 입력 확인
                if( pw.getText().toString().length() == 0 ) {
                    Toast.makeText(SignUpActivity.this, "비밀번호를 입력하세요!", Toast.LENGTH_SHORT).show();
                    pw.requestFocus();
                    return;
                }

                // 비밀번호 확인 입력 확인
                if( pwc.getText().toString().length() == 0 ) {
                    Toast.makeText(SignUpActivity.this, "비밀번호 확인을 입력하세요!", Toast.LENGTH_SHORT).show();
                    pwc.requestFocus();
                    return;
                }

                // 비밀번호 일치 확인
                if( !pw.getText().toString().equals(pwc.getText().toString()) ) {
                    Toast.makeText(SignUpActivity.this, "비밀번호가 일치하지 않습니다!", Toast.LENGTH_SHORT).show();
                    pw.setText("");
                    pwc.setText("");
                    pw.requestFocus();
                    return;
                }

                databaseReference.addListenerForSingleValueEvent(checkRegister);

            }
        });

    }
}
