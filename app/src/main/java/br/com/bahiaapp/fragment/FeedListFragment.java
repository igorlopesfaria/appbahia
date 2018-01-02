package br.com.bahiaapp.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import br.com.bahiaapp.MainActivity;
import br.com.bahiaapp.R;
import br.com.bahiaapp.Util;
import br.com.bahiaapp.adapter.FeedListAdapter;
import br.com.bahiaapp.listener.RecyclerItemClickListener;
import br.com.bahiaapp.model.Feed;

/**
 * Created by Igor Faria on 02/01/18.
 */
public class FeedListFragment extends Fragment implements  SwipeRefreshLayout.OnRefreshListener{


    private List<Feed> lFeed;
    private RecyclerView feedRecyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private LinearLayout noItemLayout;
    private TextView noItemTXV;
    private LinearLayoutManager linearLayoutManager;
    private FeedListAdapter feedListAdapter;
    public static FeedListFragment newInstance() {
        FeedListFragment fragment = new FeedListFragment();
        return fragment;
    }
    public FeedListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);

        linearLayoutManager = new LinearLayoutManager(getActivity());
        feedRecyclerView.setLayoutManager(linearLayoutManager);
        feedRecyclerView.setHasFixedSize(true);
        feedRecyclerView.setItemAnimator(new DefaultItemAnimator());
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_red_dark, R.color.colorPrimary, android.R.color.holo_red_dark, R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(this);

        
        setAdapter(getFeedFromDB());

        feedRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Feed feed = lFeed.get(position);
                        ((MainActivity)getActivity()).changeFragment(FeedDetailFragment.newInstance( feed), false);
                    }
                })
        );


    }

    private void init(View view) {
        feedRecyclerView =  view.findViewById(R.id.feedRecyclerView);
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        noItemLayout=  view.findViewById(R.id.noItemLayout);
        noItemTXV=  view.findViewById(R.id.noItemTXV);
    }

    @Override
    public void onRefresh() {
        Handler delayHandler = new Handler();
        delayHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }

        }, 1000);

    }

    public List<Feed> getFeedFromDB() {
        //lFeed = new FeedDAO(getContext()).findAll();
        lFeed = Util.mockFeed();
        return lFeed;
    }

    private void setAdapter(List<Feed> lFeed) {
        if(lFeed==null || lFeed.size()==0) {
            noItemLayout.setVisibility(View.VISIBLE);
            notifyScreen(getString(R.string.no_news));
        }else {
            noItemLayout.setVisibility(View.GONE);
        }

        feedListAdapter = new FeedListAdapter(lFeed,getActivity());
        feedRecyclerView.setAdapter(feedListAdapter);
    }

    private void notifyScreen(String message) {
        noItemLayout.setVisibility(View.VISIBLE);
        noItemTXV.setText(message);
    }

}
