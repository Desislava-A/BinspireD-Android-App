package com.projects.desislavadessi.binspired.views;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projects.desislavadessi.binspired.R;

public class QuoteDetailsFragment extends Fragment {
    private String mQuote;
    private TextView mQuoteTextView;


    public QuoteDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quote_details, container, false);
        mQuoteTextView = view.findViewById(R.id.tv_quote);
        mQuoteTextView.setText(mQuote);

        return view;
    }

    public static QuoteDetailsFragment newInstance() {
        return new QuoteDetailsFragment();
    }

    public void setmQuote(String quote) {
        mQuote = quote;
        if (mQuoteTextView == null) {
            return;
        }

        mQuoteTextView.setText(quote);
    }
}
