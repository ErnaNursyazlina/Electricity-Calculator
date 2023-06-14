package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCal, btnClear;
    EditText etName;
    int age, years;
    String name;
    TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCal = findViewById(R.id.btnCal);
        btnClear = (Button) findViewById(R.id.btnClear);
        etName = findViewById(R.id.etName);
        tvOutput = findViewById(R.id.tvOutput);

        btnClear.setOnClickListener(this);
        btnCal.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        if (v == btnClear) {
            etName.setText("");
            tvOutput.setText("");
        }
        else if (v == btnCal)
        {
            name = etName.getText().toString();

            double km = 0.0;

            try {
                km = Double.parseDouble(name);
            } catch (NumberFormatException nex)
            {

                Toast.makeText(this,"Please enter number",Toast.LENGTH_SHORT).show();
            }

            km = Double.parseDouble(name);
            double miles = km * 0.621;

            tvOutput.setText(km + "km is equivalent to " + String.valueOf(miles) + " miles");
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate (R.menu.menu, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                //Toast.makeText(this, "This is about",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;

            case R.id.settings:
                Toast.makeText(this, "This is settings",Toast.LENGTH_LONG).show();
                break;

            case R.id.search:
                Toast.makeText(this, "This is search",Toast.LENGTH_LONG).show();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    }




