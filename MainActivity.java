package com.example.asus.challengeintents;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ImageView ivCall, ivMap, ivMood, ivWeb;
    Button btnCreate;
    final int CREATE_CONTACT = 1;
    String name = "", web = "", map = "", number = "", mood = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivMood = findViewById(R.id.ivMood);
        ivCall = findViewById(R.id.ivCall);
        ivMap = findViewById(R.id.ivMap);
        ivWeb = findViewById(R.id.ivWeb);
        btnCreate = findViewById(R.id.btnCreate);

        ivMood.setVisibility(View.GONE);
        ivCall.setVisibility(View.GONE);
        ivWeb.setVisibility(View.GONE);
        ivMap.setVisibility(View.GONE);


        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.asus.challengeintents.CreateContact.class);
                startActivityForResult(intent, CREATE_CONTACT);
            }
        });

        ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel" + number));
                startActivity(intent);
            }
        });

        ivMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + map));
                startActivity(intent);

            }
        });

        ivWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + web));
                startActivity(intent);

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CREATE_CONTACT)
        {
            if (resultCode == RESULT_OK)
            {
                ivMood.setVisibility(View.VISIBLE);
                ivCall.setVisibility(View.VISIBLE);
                ivWeb.setVisibility(View.VISIBLE);
                ivMap.setVisibility(View.VISIBLE);

                name = data.getStringExtra("name");
                map = data.getStringExtra("map");
                number = data.getStringExtra("number");
                web = data.getStringExtra("web");
                mood = data.getStringExtra("mood");

                if (mood.equals("happy"))
                {
                    ivMood.setImageResource(R.drawable.happy);
                }
                else if (mood.equals("sad"))
                {
                    ivMood.setImageResource(R.drawable.sad);
                }
                else
                {
                    ivMood.setImageResource(R.drawable.ok);
                }
            }
            else
            {
                Toast.makeText(this, "No Data passed through", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
