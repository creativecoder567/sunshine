package com.example.sarath.sunshine;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class UserInput extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinFacing,spinBHK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);

        spinFacing = (Spinner)findViewById(R.id.spinFacing);
        spinBHK = (Spinner)findViewById(R.id.spinBHK);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this,R.array.spacing,android.R.layout.simple_spinner_item);
        spinFacing.setAdapter(arrayAdapter);
        spinFacing.setOnItemSelectedListener(this);

        ArrayAdapter arrayAdapter1 = ArrayAdapter.createFromResource(this,R.array.BHK,android.R.layout.simple_spinner_item);
        spinBHK.setAdapter(arrayAdapter1);
        spinBHK.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView myText = (TextView)view;
        Toast.makeText(this, "you selected "+myText.getText(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
