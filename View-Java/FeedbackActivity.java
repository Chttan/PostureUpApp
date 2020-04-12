package com.example.postureup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        GraphView graph = (GraphView) findViewById(R.id.graph);

        GridLabelRenderer gridLabel = graph.getGridLabelRenderer();
        gridLabel.setHorizontalAxisTitle("Hour");
        gridLabel.setVerticalAxisTitle("Improper Posture Time (%)");

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(100);

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(12+(1.0/2.0));


        //Youtube Player
        YoutubeFragment fragment = new YoutubeFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.feed, fragment)
                .addToBackStack(null)
                .commit();

        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.youtube_fragment, youTubePlayerFragment).commit();


    }


}
