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
    private ArrayAdapter<String> mQuotesAdapter;
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




        /*

        mQuotesAdapter.add("Antoine de Saint-Exupéry");
        mQuotesAdapter.add("Budha");
        mQuotesAdapter.add("Eckhart Tolle");
        mQuotesAdapter.add("Marilyn Monroe");

        */

        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String quote = mQuotesAdapter.getItem(position);
        mNavigator.navigateWith(quote);
    }

    public static QuoteListFragment newInstance() {
        return new QuoteListFragment();
    }

    public void setNavigator(Navigatable navigator) {
        mNavigator = navigator;
    }
}
