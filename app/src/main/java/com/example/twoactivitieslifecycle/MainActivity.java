package com.example.twoactivitieslifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mSend;
    private EditText mSendMsg;
    private TextView mSendTitle, mSendDisplay;

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Log the start of the onCreate() method.
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        mSend = findViewById(R.id.send);
        mSendMsg = findViewById(R.id.sendMsg);
        mSendTitle = findViewById(R.id.sendTitle);
        mSendDisplay = findViewById(R.id.sendDisplay);
        displayReplyMsg();
        mSend.setOnClickListener(this);
    }

    private void displayReplyMsg() {
        String replyMsg;
        Bundle bundle;

        bundle = getIntent().getExtras();

        if(bundle==null)
        {
            mSendTitle.setText("");
            mSendDisplay.setText("");
        }
        else
        {
            replyMsg = bundle.getString("ReplyMsg");
            mSendTitle.setText("Reply Recieved");
            mSendDisplay.setText(replyMsg);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.send)
        {
            String deliverMsg;
            deliverMsg = mSendMsg.getText().toString().trim();
            Intent sendIntent = new Intent(MainActivity.this, SecondActivity.class);
            sendIntent.putExtra("SendMsg",deliverMsg);
            startActivity(sendIntent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }
}