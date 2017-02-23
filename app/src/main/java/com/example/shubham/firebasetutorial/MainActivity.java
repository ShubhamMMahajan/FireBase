package com.example.shubham.firebasetutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.R.attr.key;


public class MainActivity extends AppCompatActivity {
    private Button sendData;
    private EditText key;
    private  EditText value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        key = (EditText) findViewById(R.id.Key);
        value = (EditText) findViewById(R.id.Value);

        sendData = (Button) findViewById(R.id.send_message);


    }

    public void OnClick(View view) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef= database.getReference();
        Log.d("DataRefernce", "" + myRef.getClass());
        String keyInput = key.getText().toString();
        String valueInput = value.getText().toString();

        myRef.setValue("Hi!");
        myRef.child(keyInput).setValue(valueInput);
    }
}
