import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.muhammedfayed.joketelling.EndpointsAsyncTask;
import com.example.muhammedfayed.joketelling.R;

public class MainActivity extends AppCompatActivity {

    TextView mJokeText;
    Button mButton;
    public static ProgressBar mProgressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mJokeText = (TextView) findViewById(R.id.joke_textview);
        mButton = (Button) findViewById(R.id.button);
        mProgressbar = (ProgressBar) findViewById(R.id.progressBar);


    }

    public void openJoke(View view) {
        mProgressbar.setVisibility(View.VISIBLE);
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(this);
        endpointsAsyncTask.execute();


    }
}
