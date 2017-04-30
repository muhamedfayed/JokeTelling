import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.muhammedfayed.joketelling.EndpointsAsyncTask;
import com.example.muhammedfayed.joketelling.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import static android.R.attr.id;
import static com.example.muhammedfayed.joketelling.MainActivity.mProgressbar;


public class MainActivity extends Fragment {

    TextView mJokeText;
    Button mButton;
    AdView mAdView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_main, container, false);

        mJokeText = (TextView) rootView.findViewById(R.id.joke_textview);
        mButton = (Button) rootView.findViewById(R.id.button);
        mAdView = (AdView) rootView.findViewById(R.id.ad_view);


        AdRequest adRequest = new AdRequest.Builder().build();

        mAdView.loadAd(adRequest);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openjoke();
            }
        });

        return rootView;
    }

    public void openjoke() {
        mProgressbar.setVisibility(View.VISIBLE);
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getContext());
        endpointsAsyncTask.execute();

    }


}


