package com.adida.aka.broadcastreceiverlisten2app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener{
    private static final
        String ACTION_ADD
            =  "com.adida.aka.broadcastreceiverlistener2app.ACTION_ADD";
    private static final String Key_A = "Num_A";
    private static final String Key_B = "Num_B";
    private Button mBtnAdd;
    private EditText mEdtNumberA, mEdtNumberB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        handlerEvents();
    }

    private void handlerEvents() {
        mBtnAdd.setOnClickListener(this);
    }

    private void initView() {
        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mEdtNumberA = (EditText) findViewById(R.id.edt_number_a);
        mEdtNumberB = (EditText) findViewById(R.id.edt_number_b);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:
                sendBroadcastAdd();
                break;
            default:
                break;
        }
    }

    /**
     * send broadcast receiver
     */
    private void sendBroadcastAdd() {
        Intent intent = new Intent();
        intent.setAction(ACTION_ADD);
        Bundle bundle = new Bundle();
        int numA = Integer.parseInt(mEdtNumberA.getText().toString().trim());
        int numB = Integer.parseInt(mEdtNumberB.getText().toString().trim());
        bundle.putInt(Key_A, numA);
        bundle.putInt(Key_B, numB);
        intent.putExtras(bundle);
        sendBroadcast(intent);
    }
}
