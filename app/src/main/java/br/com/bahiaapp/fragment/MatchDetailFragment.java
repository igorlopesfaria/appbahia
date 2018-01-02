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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.bahiaapp.R;
import br.com.bahiaapp.Util;
import br.com.bahiaapp.adapter.MatchActionListAdapter;
import br.com.bahiaapp.adapter.MatchListAdapter;
import br.com.bahiaapp.listener.RecyclerItemClickListener;
import br.com.bahiaapp.model.Feed;
import br.com.bahiaapp.model.Match;
import br.com.bahiaapp.model.MatchAction;

/**
 * Created by Igor Faria on 02/01/18.
 */

public class MatchDetailFragment extends Fragment implements  SwipeRefreshLayout.OnRefreshListener{


    public static final String ARG_MATCH = "matchDetailed";
    private List<MatchAction> lMatchAction;
    private RecyclerView feedRecyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private LinearLayout noItemLayout;
    private TextView noItemTXV;
    private LinearLayoutManager linearLayoutManager;
    private MatchActionListAdapter matchActionListAdapter;
    private Match matchDetailed;
    private TextView scoreHomeTXV, scoreAwayTXV, shortNameHomeTXV, shortNameAwayTXV;
    private ImageView shieldHomeIMG, shieldAwayIMG;
    public static MatchDetailFragment newInstance(Match match) {
        MatchDetailFragment fragment = new MatchDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_MATCH, match);
        fragment.setArguments(args);return fragment;
    }
    public MatchDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match_detail, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            matchDetailed = (Match) getArguments().getSerializable(ARG_MATCH);
        }

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        detail(matchDetailed);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        feedRecyclerView.setLayoutManager(linearLayoutManager);
        feedRecyclerView.setHasFixedSize(true);
        feedRecyclerView.setItemAnimator(new DefaultItemAnimator());
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_red_dark, R.color.colorPrimary, android.R.color.holo_red_dark, R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(this);


        setAdapter(getMatchActionFromDB());



    }

    private void detail(Match matchDetailed) {
        Picasso.with(getActivity()).load(matchDetailed.getHomeTeam().getShieldIMG()).into(shieldHomeIMG);
        Picasso.with(getActivity()).load(matchDetailed.getAwayTeam().getShieldIMG()).into(shieldAwayIMG);

        scoreHomeTXV.setText(matchDetailed.getScoreHome()+ "");
        scoreAwayTXV.setText(matchDetailed.getScoreAway()+ "");

        shortNameHomeTXV.setText(matchDetailed.getHomeTeam().getShortName());
        shortNameAwayTXV.setText(matchDetailed.getAwayTeam().getShortName());
    }

    private void init(View view) {
        feedRecyclerView =  view.findViewById(R.id.feedRecyclerView);
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        noItemLayout=  view.findViewById(R.id.noItemLayout);
        noItemTXV=  view.findViewById(R.id.noItemTXV);


        scoreHomeTXV = view.findViewById(R.id.scoreHomeTXV);
        scoreAwayTXV = view.findViewById(R.id.scoreAwayTXV);
        shieldHomeIMG = view.findViewById(R.id.shieldHomeIMG);
        shieldAwayIMG = view.findViewById(R.id.shieldAwayIMG);
        shortNameAwayTXV =  view.findViewById(R.id.shortNameAwayTXV);
        shortNameHomeTXV = view.findViewById(R.id.shortNameHomeTXV);
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

    public List<MatchAction> getMatchActionFromDB() {
        lMatchAction = Util.mockMatchAction();
        return lMatchAction;
    }

    private void setAdapter(List<MatchAction> lMatchAction) {
        if(lMatchAction==null || lMatchAction.size()==0) {
            noItemLayout.setVisibility(View.VISIBLE);
            notifyScreen(getString(R.string.no_news));
        }else {
            noItemLayout.setVisibility(View.GONE);
        }

        matchActionListAdapter = new MatchActionListAdapter(lMatchAction,getActivity());
        feedRecyclerView.setAdapter(matchActionListAdapter);
    }

    private void notifyScreen(String message) {
        noItemLayout.setVisibility(View.VISIBLE);
        noItemTXV.setText(message);
    }

}
