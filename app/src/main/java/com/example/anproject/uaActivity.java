package com.example.anproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class uaActivity extends AppCompatActivity {
    TextView facebookTextView, twitterTextView, instagramTextView, youtubeTextView, linkedinTextView, websiteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ua);

        facebookTextView = findViewById(R.id.fbID);
        twitterTextView = findViewById(R.id.twtrID);
        instagramTextView = findViewById(R.id.gramID);
        youtubeTextView = findViewById(R.id.ytID);
        linkedinTextView = findViewById(R.id.LinkedInID);
        websiteTextView = findViewById(R.id.mailID);


        facebookTextView.setMovementMethod(LinkMovementMethod.getInstance());
        twitterTextView.setMovementMethod(LinkMovementMethod.getInstance());
        instagramTextView.setMovementMethod(LinkMovementMethod.getInstance());
        youtubeTextView.setMovementMethod(LinkMovementMethod.getInstance());
        linkedinTextView.setMovementMethod(LinkMovementMethod.getInstance());
        websiteTextView.setMovementMethod(LinkMovementMethod.getInstance());


        facebookTextView.setOnClickListener(createLinkClickListener(getString(R.string.fb_link)));
        twitterTextView.setOnClickListener(createLinkClickListener(getString(R.string.twitter_link)));
        instagramTextView.setOnClickListener(createLinkClickListener(getString(R.string.instagram_link)));
        youtubeTextView.setOnClickListener(createLinkClickListener(getString(R.string.youtube_link)));
        linkedinTextView.setOnClickListener(createLinkClickListener(getString(R.string.linkedin_link)));
        websiteTextView.setOnClickListener(createLinkClickListener(getString(R.string.web_link)));
    }

    private View.OnClickListener createLinkClickListener(final String url) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(myIntent);
            }
        };
    }
}
