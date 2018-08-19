package com.projects.desislavadessi.binspired.views;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.projects.desislavadessi.binspired.R;
import com.projects.desislavadessi.binspired.uxstructure.Navigatable;


public class QuoteListActivity extends Activity implements Navigatable {

    private QuoteListFragment mQuotesListFragment;
    private boolean mIsPhone;
    private QuoteDetailsFragment mQuotesDetailsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_list);

        mQuotesListFragment = QuoteListFragment.newInstance();
        mQuotesListFragment.setNavigator(this);

        mIsPhone =
                findViewById(R.id.content_details) == null;

        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction();

        transaction
                .replace(R.id.content, mQuotesListFragment);

        if (!mIsPhone) {
            mQuotesDetailsFragment = QuoteDetailsFragment.newInstance();
            transaction.replace(R.id.content_details, mQuotesDetailsFragment);
        }

        transaction.commit();
    }

    @Override
    public void navigateWith(String quote) {
        if (mIsPhone) {
            Intent intent = new Intent(
                    this,
                    QuoteDetailsActivity.class
            );

            intent.putExtra("QUOTE_AUTHOR", quote);

            startActivity(intent);
        } else {
            mQuotesDetailsFragment.setmQuote(quote);
        }
    }
}
