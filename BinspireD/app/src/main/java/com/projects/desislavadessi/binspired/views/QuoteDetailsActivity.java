package com.projects.desislavadessi.binspired.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.projects.desislavadessi.binspired.R;

public class QuoteDetailsActivity extends Activity {

    private QuoteDetailsFragment mQuoteDetailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_details);

        Intent intent = getIntent();
        String qoute = intent.getStringExtra("QUOTE_AUTHOR");

        mQuoteDetailsFragment = QuoteDetailsFragment.newInstance();
        mQuoteDetailsFragment.setmQuote(qoute);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mQuoteDetailsFragment)
                .commit();
    }
}





