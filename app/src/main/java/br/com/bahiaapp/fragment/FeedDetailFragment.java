package br.com.bahiaapp.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.bahiaapp.R;
import br.com.bahiaapp.model.Feed;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedDetailFragment extends Fragment {


    private static final String ARG_FEED = "feed" ;
    private TextView titleTXV, shortDescriptionTXV, datePublishedTXV, textCompleateTXV;
    private ImageView photoIMG;
    private Feed feedDetailed;
    public static FeedDetailFragment newInstance(Feed feed) {
        FeedDetailFragment fragment = new FeedDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_FEED, feed);
        fragment.setArguments(args);
        return fragment;
    }

    
    public FeedDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            feedDetailed = (Feed) getArguments().getSerializable(ARG_FEED);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        detail();
    }

    private void detail() {
        datePublishedTXV.setText(feedDetailed.getDatePublished());
        titleTXV.setText(feedDetailed.getTitle());
    

        Picasso.with(getActivity()).load(feedDetailed.getImageUrl()).into(photoIMG);
        shortDescriptionTXV.setText(feedDetailed.getShortDescription());
        textCompleateTXV.setText(Html.fromHtml(feedDetailed.getTextCompleate()));

    }

    private void init(View view) {
        photoIMG = view.findViewById(R.id.photoIMG);
        titleTXV =  view.findViewById(R.id.titleTXV);
        shortDescriptionTXV = view.findViewById(R.id.shortDescriptionTXV);
        datePublishedTXV = view.findViewById(R.id.datePublishedTXV);
        textCompleateTXV = view.findViewById(R.id.textCompleateTXV);
    }
}
