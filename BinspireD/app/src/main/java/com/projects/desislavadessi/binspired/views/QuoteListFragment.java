package com.projects.desislavadessi.binspired.views;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.projects.desislavadessi.binspired.R;
import com.projects.desislavadessi.binspired.models.Quote;
import com.projects.desislavadessi.binspired.uxstructure.Navigatable;

import java.text.Collator;
import java.util.List;

public class QuoteListFragment extends Fragment implements AdapterView.OnItemClickListener {

    private Navigatable mNavigator;

    private ListView mQuotesListView;
    private ArrayAdapter<Quote> mQuotesAdapter;


    private FirebaseFirestore mDB;


    public QuoteListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quote_list, container, false);

        mDB = FirebaseFirestore.getInstance();

        mQuotesListView = view.findViewById(R.id.lv_quote);
        mQuotesAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1);

        mQuotesListView.setAdapter(mQuotesAdapter);
        mQuotesListView.setOnItemClickListener(this);

        /*
        mDB.collection("quotes")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        List<Quote> quoutesList =task.getResult().
                                toObjects(Quote.class);
                        for (Quote quote:quoutesList
                             ) {
                            mQuotesAdapter.add(quote.author);
                        }
                    }
                });
                */


        mDB.collection("quotes")
        .get()
        .addOnCompleteListener(task -> {
            List<Quote> quoutesList =task.getResult().
            toObjects(Quote.class);
            for (Quote quoteItem : quoutesList) {
            mQuotesAdapter.add(quoteItem);
                  }
          });


        /*
        Quote marilynMonroe =  new Quote("Marilyn Monroe", "We should all start to live before we get too old." );
        mDB.collection("quotes")
                .add(marilynMonroe);

        Quote buddha = new Quote("Buddha","May all beings have happy minds.");
        mDB.collection("quotes")
                .add(buddha);

                */

        /*

        mQuotesAdapter.add("Antoine de Saint-Exupéry");
        mQuotesAdapter.add("Eckhart Tolle");
        mQuotesAdapter.add("Marilyn Monroe");

        */

        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String quote = mQuotesAdapter.getItem(position).quoteText;
        mNavigator.navigateWith(quote);
    }

    public static QuoteListFragment newInstance() {
        return new QuoteListFragment();
    }

    public void setNavigator(Navigatable navigator) {
        mNavigator = navigator;
    }
}
