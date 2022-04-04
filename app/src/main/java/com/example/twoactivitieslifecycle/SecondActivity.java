package com.example.twoactivitieslifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String EXTRA_REPLY = SecondActivity.class.getSimpleName();
    private ImageView mBack;
    private Button mReply;
    private EditText mReplyMsg;
    private TextView mReplyDisplay;
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);




        mBack = findViewById(R.id.back);
        mReply = findViewById(R.id.reply);
        mReplyMsg = findViewById(R.id.replyMsg);
        mReplyDisplay = findViewById(R.id.replyDisplay);
        displayRecievedMsg();
        mBack.setOnClickListener(this);
        mReply.setOnClickListener(this);
    }

    private void displayRecievedMsg() {
        String recievedMsg;
        Bundle bundle;
        bundle = getIntent().getExtras();


        if (bundle==null)
        {
            mReplyDisplay.setText("");
        }
        else
        {
            recievedMsg = bundle.getString("SendMsg");
            mReplyDisplay.setText(recievedMsg);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.back:
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.reply:
                String storeReplyMsg;

                storeReplyMsg = mReplyMsg.getText().toString().trim();

                Intent replyIntent = new Intent(SecondActivity.this, MainActivity.class);
                replyIntent.putExtra("ReplyMsg", storeReplyMsg);
                startActivity(replyIntent);
                break;
        }
    }


    public void returnReply(View view) {
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        Log.d(LOG_TAG, "End SecondActivity");
        finish();
    }


}