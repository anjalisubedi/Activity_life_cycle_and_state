package com.example.activitylifecyclehomework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton;
    private TextView mTextView;
    private EditText mEdit;
    int counter;
    private static final String MAIN_ACTIVITY_STATE = "state";
    String saveEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.button);
        mTextView = findViewById(R.id.textView);
        mEdit = findViewById(R.id.edit);
        counter = 0;
        mButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        counter++;
        mTextView.setText(""+counter);
    }


}