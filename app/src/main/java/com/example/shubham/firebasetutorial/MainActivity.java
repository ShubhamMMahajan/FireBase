package com.example.shubham.firebasetutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.R.attr.key;
import static android.R.attr.value;


public class MainActivity extends AppCompatActivity {

    private EditText updateKey;
    private  EditText updateValue;

    private Button sendData;

    ArrayList data = new ArrayList();

    private EditText addKey;
    private EditText addValue;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef= database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateKey = (EditText) findViewById(R.id.Key);
        updateValue = (EditText) findViewById(R.id.Value);

        sendData = (Button) findViewById(R.id.update_child);

        addKey = (EditText) findViewById(R.id.addKey);
        addValue = (EditText) findViewById(R.id.addValue);


        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    data.add(child);
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("Error", "" + databaseError);
            }
        });
    }

            public void OnClick(View view) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef= database.getReference();



        String keyInput = updateKey.getText().toString();
        String valueInput = updateValue.getText().toString();

        myRef.setValue("Hi!");
        //Log.d("DataRefernce", "" + myRef.child().getClass());
        myRef.child(keyInput).setValue(valueInput);
    }

    public void onChild(View view) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef= database.getReference();
        String keyInput = addKey.getText().toString();
        DatabaseReference child = myRef.child(keyInput);
        data.add(child);

        DatabaseReference addChild = (DatabaseReference) data.get(data.size() - 1);


        String valueInput = addValue.getText().toString();

        addChild.setValue(valueInput);

    }

}
