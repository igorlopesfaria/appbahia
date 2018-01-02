package br.com.bahiaapp.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import br.com.bahiaapp.R;
import br.com.bahiaapp.model.Feed;

/**
 * Created by Igor Faria on 02/01/18.
 */
public class FeedListAdapter extends RecyclerView.Adapter<FeedListAdapter.ViewHolder> {

    private static final int TYPE_HEADER = 0 ;
    private static final int TYPE_ITEM = 1;
    private List<Feed> lFeed;
    private Context context;


    public static class ViewHolder extends RecyclerView.ViewHolder {


        TextView titleTXV, shortDescriptionTXV, datePublishedTXV;
        CardView mainInfoCard;
        ImageView photoIMG;


        public ViewHolder(View itemView, int viewType) {
            super(itemView);

            photoIMG = itemView.findViewById(R.id.photoIMG);
            mainInfoCard = itemView.findViewById(R.id.mainInfoCard);
            titleTXV =  itemView.findViewById(R.id.titleTXV);
            shortDescriptionTXV = itemView.findViewById(R.id.shortDescriptionTXV);
            datePublishedTXV = itemView.findViewById(R.id.datePublishedTXV);

        }
    }

    public FeedListAdapter(List<Feed> lFeed, Context context) {
        this.lFeed = lFeed;
        this.context = context;
    }

    @Override
    public FeedListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FeedListAdapter.ViewHolder viewHolder = null;

        if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed, parent, false);
            viewHolder = new FeedListAdapter.ViewHolder(v, viewType);
        } else if (viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_header, parent, false);
            viewHolder = new FeedListAdapter.ViewHolder(v, viewType);
        }

        return viewHolder;


    }

    @Override
    public void onBindViewHolder(final FeedListAdapter.ViewHolder holder, final int position) {

        final Feed feed = lFeed.get(position);

        if(TYPE_HEADER != position) {
            holder.datePublishedTXV.setText(feed.getDatePublished());
            holder.titleTXV.setText(feed.getTitle());
        }

        Picasso.with(context).load(feed.getImageUrl()).into(holder.photoIMG);
        holder.shortDescriptionTXV.setText(feed.getShortDescription());




    }


    @Override
    public int getItemCount() {
        return lFeed.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    private Feed getItem(int position) {
        return lFeed.get(position);
    }



}