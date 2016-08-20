package info.hossainkhan.recyclerviewdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RecyclerViewWrapContentFixDemoFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private SimpleListAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_view_with_fix, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        ActionBar supportActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(R.string.title_with_relative_layout_wrapper_fix);
        }

        // Partial code from https://developer.android.com/training/material/lists-cards.html#RecyclerView

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Disabled nested scrolling since Parent scrollview will scroll the content.
        mRecyclerView.setNestedScrollingEnabled(false);

        // specify an adapter (see also next example)
        mAdapter = new SimpleListAdapter(DataSetProvider.generateDataset());
        mRecyclerView.setAdapter(mAdapter);
    }
}
