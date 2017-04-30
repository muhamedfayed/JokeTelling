import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import com.example.jokeviewactivity.JokeviewActivity;
import com.example.muhammedfayed.joketelling.MainActivity;
import com.example.muhammedfayed.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

import static com.example.muhammedfayed.joketelling.MainActivity.mProgressbar;

/**
 * Created by muhammedfayed on 29/04/17.
 */



public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private Context mContext;

    public EndpointsAsyncTask (Context context){
        mContext = context;
    }

    @Override
    protected String doInBackground(Void... params){
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://jokesapplication-166117.appspot.com/_ah/api/");
            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        mProgressbar.setVisibility(View.GONE);
        Intent intent = new Intent(mContext, JokeviewActivity.class);
        intent.putExtra("joke", result);
        mContext.startActivity(intent);

    }
}

