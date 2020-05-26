package com.example.asus.challengeintents;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CreateContact extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etMap, etWeb, etNumber;
    ImageView ivSad, ivHappy, ivOk;

    @Override
    public void onClick(View v) {

        if (etName.getText().toString().isEmpty() || etMap.getText().toString().isEmpty() || etWeb.getText().toString().isEmpty() || etNumber.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent = new Intent();
            intent.putExtra("name", etName.getText().toString().trim());   //Getting the data from input
            intent.putExtra("number", etNumber.getText().toString().trim());
            intent.putExtra("map", etMap.getText().toString().trim());
            intent.putExtra("web", etWeb.getText().toString().trim());

            if (v.getId() == R.id.ivHappy)
            {
                intent.putExtra("mood", "happy");
            }
            else if ((v.getId() == R.id.ivOk))
            {
                intent.putExtra("mood", "ok");
            }
            else
            {
                intent.putExtra("mood", "sad");
            }
            setResult(RESULT_OK, intent);
            CreateContact.this.finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        etName = findViewById(R.id.etName);
        etMap = findViewById(R.id.etMap);
        etWeb = findViewById(R.id.etWeb);
        etNumber = findViewById(R.id.etNumber);
        ivSad = findViewById(R.id.ivSad);
        ivHappy = findViewById(R.id.ivHappy);
        ivOk = findViewById(R.id.ivOk);

        ivSad.setOnClickListener(this);
        ivHappy.setOnClickListener(this);
        ivOk.setOnClickListener(this);

















        /*ivHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ivSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ivOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

    }
}
