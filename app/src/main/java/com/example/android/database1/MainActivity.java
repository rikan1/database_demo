package com.example.android.database1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper mydb;
    EditText mname, msurname, mmark;
    Button madd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new DatabaseHelper(this);
        mname= (EditText)findViewById(R.id.name_in);
        msurname =(EditText)findViewById(R.id.surname_in);
        mmark= (EditText)findViewById(R.id.marks_in);
        madd=(Button)findViewById(R.id.button);
        addData();
    }
    public void addData(){
        madd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              boolean isinserted=  mydb.insertData(mname.getText().toString(),
                        msurname.getText().toString(),
                        mmark.getText().toString());
                if(isinserted==true)
                    Toast.makeText(MainActivity.this,"Data added sucessfully",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data couldn't added",Toast.LENGTH_LONG).show();

            }
        });
    }
}
