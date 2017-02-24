package com.example.ayush.niki;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.pubnub.api.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ChatAdapter mAdapter;
    ArrayList<Message> messages;
    private EditText msgEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.msgview);
        msgEdit = (EditText) findViewById(R.id.msgEdit);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
       messages  = new ArrayList<>();
    Message test = new Message();
        test.setMessage("Hello! How are you?");
        test.isMe = Boolean.FALSE;
        messages.add(test);
        mAdapter = new ChatAdapter(messages);
        mRecyclerView.setAdapter(mAdapter);


// Subscribe for messages and display them. Can't get this working in time contraint.


/*
        PubNub pubnub = new PubNub(getString(R.string.com_pubnub_publishKey), getString(R.string.com_pubnub_subscribeKey));

        pubnub.subscribe("demo_channel", new Callback() {

                    @Override
                    public void connectCallback(String channel, Object message) {
                        System.out.println("SUBSCRIBE : CONNECT on channel:" + channel
                                + " : " + message.getClass() + " : "
                                + message.toString());
                    }

                    @Override
                    public void disconnectCallback(String channel, Object message) {
                        System.out.println("SUBSCRIBE : DISCONNECT on channel:" + channel
                                + " : " + message.getClass() + " : "
                                + message.toString());
                    }

                    public void reconnectCallback(String channel, Object message) {
                        System.out.println("SUBSCRIBE : RECONNECT on channel:" + channel
                                + " : " + message.getClass() + " : "
                                + message.toString());
                    }

                    @Override
                    public void successCallback(String channel, Object message) {
                        System.out.println("SUBSCRIBE : " + channel + " : "
                                + message.getClass() + " : " + message.toString());
                    }

                    @Override
                    public void errorCallback(String channel, PubnubError error) {
                        System.out.println("SUBSCRIBE : ERROR on channel " + channel
                                + " : " + error.toString());
                    }
                }
        );
    });

*/
}

    public void sendMessage(View view) {
        Log.d("test","test");
        Message testMsg = new Message();
        testMsg.setMessage(msgEdit.getText().toString());
        msgEdit.setText("");
        InputMethodManager imm = (InputMethodManager) getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        testMsg.isMe = Boolean.TRUE;

        messages.add(testMsg);
        mAdapter.notifyDataSetChanged();

        // Publish this to PubNub

       /*
               Pubnub pubnub = new Pubnub(getString(R.string.com_pubnub_publishKey), getString(R.string.com_pubnub_subscribeKey));

        pubnub.publish("demo_channel", "demo_message", new Callback(){
            @Override
            public void successCallback(String channel, Object message) {
               System.out.println(message);
           }
            @Override
            public void errorCallback(String channel, PubnubError error) {
               System.out.println(error);
            }
        });

        */

    }
}
