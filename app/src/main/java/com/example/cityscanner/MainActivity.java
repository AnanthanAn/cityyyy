package com.example.cityscanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button mapButton,userButton;
    EditText searchText;
    TextView textView;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapButton = findViewById(R.id.button);
        userButton = findViewById(R.id.userButton);
        searchText = findViewById(R.id.searchText);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);

        textView.setTextSize(50);

        mAuth = FirebaseAuth.getInstance();


        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MapsActivity.class);

                String searchStrng = searchText.getText().toString();
                intent.putExtra("searchTxt",searchStrng);

                startActivity(intent);

            }
        });

        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,UserActivity.class);

                startActivity(intent);

            }
        });


        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                intent.putExtra("ID",1);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() != null){
            progressBar.setVisibility(View.GONE);

        }else{
            Intent intent = new Intent(MainActivity.this,UserActivity.class);
            startActivity(intent
            );
        }
    }
}
