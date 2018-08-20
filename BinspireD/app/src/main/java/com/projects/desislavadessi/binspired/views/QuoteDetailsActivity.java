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
        //String name = intent.getStringExtra("QUOTE_AUTHOR");
        String qoute = intent.getStringExtra("QUOTE_CONTENT");

        mQuoteDetailsFragment = QuoteDetailsFragment.newInstance();
        //mQuoteDetailsFragment.setmQuote(name);
        mQuoteDetailsFragment.setmQuote(qoute);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mQuoteDetailsFragment)
                .commit();
    }
}





