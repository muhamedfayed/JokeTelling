package com.example.jokeviewactivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class JokeviewActivity extends AppCompatActivity {

    TextView jokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokeview);

        if(isConnectedToInternet()) {

            jokeTextView = (TextView) findViewById(R.id.textView);

            Intent intent = getIntent();
            String joke = intent.getStringExtra("joke");

            if (joke != null)
                jokeTextView.setText(joke);
            else {
                Toast.makeText(getApplicationContext(), "Problem in getting joke,Please try again", Toast.LENGTH_LONG).show();
                finish();
            }
        }else {
            Toast.makeText(getApplicationContext(), "Please check your internet connection.", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    public boolean isConnectedToInternet(){
        ConnectivityManager connectivity = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null)
        {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED)
                    {
                        return true;
                    }

        }
        return false;
    }
}
