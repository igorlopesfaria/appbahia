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
import br.com.bahiaapp.model.Match;

/**
 * Created by Igor Faria on 27/12/17.
 */
public class MatchListAdapter extends RecyclerView.Adapter<MatchListAdapter.ViewHolder> {
    private List<Match> lMatch;
    private Context context;


    public static class ViewHolder extends RecyclerView.ViewHolder {


        TextView shortNameHomeTXV, shortNameAwayTXV, scoreHomeTXV, scoreAwayTXV;
        ImageView shieldHomeIMG, shieldAwayIMG;


        public ViewHolder(View itemView, int viewType) {
            super(itemView);
            scoreHomeTXV = itemView.findViewById(R.id.scoreHomeTXV);
            scoreAwayTXV = itemView.findViewById(R.id.scoreAwayTXV);
            shieldHomeIMG = itemView.findViewById(R.id.shieldHomeIMG);
            shieldAwayIMG = itemView.findViewById(R.id.shieldAwayIMG);
            shortNameAwayTXV =  itemView.findViewById(R.id.shortNameAwayTXV);
            shortNameHomeTXV = itemView.findViewById(R.id.shortNameHomeTXV);

        }
    }

    public MatchListAdapter(List<Match> lMatch, Context context) {
        this.lMatch = lMatch;
        this.context = context;
    }

    @Override
    public MatchListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MatchListAdapter.ViewHolder viewHolder = null;

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match, parent, false);
        viewHolder = new MatchListAdapter.ViewHolder(v, viewType);
        

        return viewHolder;


    }

    @Override
    public void onBindViewHolder(final MatchListAdapter.ViewHolder holder, final int position) {

        final Match match = lMatch.get(position);


        Picasso.with(context).load(match.getHomeTeam().getShieldIMG()).into(holder.shieldHomeIMG);
        Picasso.with(context).load(match.getAwayTeam().getShieldIMG()).into(holder.shieldAwayIMG);

        holder.scoreHomeTXV.setText(match.getScoreHome()+ "");
        holder.scoreAwayTXV.setText(match.getScoreAway()+ "");

        holder.shortNameHomeTXV.setText(match.getHomeTeam().getShortName());
        holder.shortNameAwayTXV.setText(match.getAwayTeam().getShortName());



    }

    @Override
    public int getItemCount() {
        return lMatch.size();
    }


    private Match getItem(int position) {
        return lMatch.get(position);
    }



}