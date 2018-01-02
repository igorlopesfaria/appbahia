package br.com.bahiaapp.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.bahiaapp.R;
import br.com.bahiaapp.model.Match;
import br.com.bahiaapp.model.MatchAction;
import br.com.bahiaapp.model.MatchActionType;

/**
 * Created by Igor Faria on 02/01/18.
 */
public class MatchActionListAdapter extends RecyclerView.Adapter<MatchActionListAdapter.ViewHolder> {
    private List<MatchAction> lMatchAction;
    private Context context;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout homeActionLayout,awayActionLayout;
        TextView titleTXV, descriptionHomeTXV,descriptionAwayTXV,timeHomeTXV,timeAwayTXV,descriptionTXV;
        ImageView typeActionHomeIMG, typeActionAwayIMG;


        public ViewHolder(View itemView, int viewType) {
            super(itemView);
            titleTXV = itemView.findViewById(R.id.titleTXV);
            homeActionLayout = itemView.findViewById(R.id.homeActionLayout);
            awayActionLayout = itemView.findViewById(R.id.awayActionLayout);
            descriptionHomeTXV= itemView.findViewById(R.id.descriptionHomeTXV);
            descriptionAwayTXV= itemView.findViewById(R.id.descriptionAwayTXV);
            typeActionAwayIMG = itemView.findViewById(R.id.typeActionAwayIMG);
            typeActionHomeIMG = itemView.findViewById(R.id.typeActionHomeIMG);
            timeHomeTXV= itemView.findViewById(R.id.timeHomeTXV);
            timeAwayTXV= itemView.findViewById(R.id.timeAwayTXV);
            descriptionTXV= itemView.findViewById(R.id.descriptionTXV);

        }
    }

    public MatchActionListAdapter(List<MatchAction> lMatchAction, Context context) {
        this.lMatchAction = lMatchAction;
        this.context = context;
    }

    @Override
    public MatchActionListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MatchActionListAdapter.ViewHolder viewHolder = null;

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match_action, parent, false);
        viewHolder = new MatchActionListAdapter.ViewHolder(v, viewType);


        return viewHolder;


    }

    @Override
    public void onBindViewHolder(final MatchActionListAdapter.ViewHolder holder, final int position) {

        final MatchAction matchAction = lMatchAction.get(position);
        holder.titleTXV.setText(matchAction.getTitle());
        if(matchAction.isHomeAction()){
            holder.awayActionLayout.setVisibility(View.GONE);
            holder.timeAwayTXV.setVisibility(View.GONE);
            holder.descriptionAwayTXV.setVisibility(View.GONE);
            holder.typeActionAwayIMG.setVisibility(View.GONE);
            holder.descriptionTXV.setVisibility(View.GONE);
            holder.homeActionLayout.setVisibility(View.VISIBLE);
            holder.timeHomeTXV.setVisibility(View.VISIBLE);
            holder.descriptionHomeTXV.setVisibility(View.VISIBLE);
            holder.typeActionHomeIMG.setVisibility(View.VISIBLE);

            holder.timeHomeTXV.setText(matchAction.getTime());
            holder.descriptionHomeTXV.setText(matchAction.getDescription());
            holder.typeActionHomeIMG.setImageDrawable(getCorrectIcon(matchAction.getMatchActionType()));

        }else if(matchAction.isAwayAction()){
            holder.awayActionLayout.setVisibility(View.VISIBLE);
            holder.timeAwayTXV.setVisibility(View.VISIBLE);
            holder.descriptionAwayTXV.setVisibility(View.VISIBLE);
            holder.typeActionAwayIMG.setVisibility(View.VISIBLE);
            holder.descriptionTXV.setVisibility(View.GONE);
            holder.typeActionHomeIMG.setVisibility(View.GONE);
            holder.homeActionLayout.setVisibility(View.GONE);
            holder.timeHomeTXV.setVisibility(View.GONE);
            holder.descriptionHomeTXV.setVisibility(View.GONE);
            holder.timeAwayTXV.setText(matchAction.getTime());
            holder.descriptionAwayTXV.setText(matchAction.getDescription());
            holder.typeActionAwayIMG.setImageDrawable(getCorrectIcon(matchAction.getMatchActionType()));

        }else{
            holder.awayActionLayout.setVisibility(View.GONE);
            holder.timeAwayTXV.setVisibility(View.GONE);
            holder.descriptionAwayTXV.setVisibility(View.GONE);
            holder.typeActionAwayIMG.setVisibility(View.GONE);
            holder.typeActionHomeIMG.setVisibility(View.GONE);
            holder.homeActionLayout.setVisibility(View.GONE);
            holder.timeHomeTXV.setVisibility(View.GONE);
            holder.descriptionHomeTXV.setVisibility(View.GONE);

            holder.descriptionTXV.setVisibility(View.VISIBLE);
            holder.descriptionTXV.setText(matchAction.getDescription());

        }




    }

    private Drawable getCorrectIcon(MatchActionType matchActionType) {
        if(matchActionType== MatchActionType.START_MATCH)
            return ContextCompat.getDrawable(context, R.drawable.icon_start_game);
        else if(matchActionType== MatchActionType.REDCARD)
            return ContextCompat.getDrawable(context, R.drawable.icon_red_card);
        else if(matchActionType== MatchActionType.YELLOW_CARD)
            return ContextCompat.getDrawable(context, R.drawable.icon_yellow_card);
        else if(matchActionType== MatchActionType.GOAL)
            return ContextCompat.getDrawable(context, R.drawable.icon_goal);
        else if(matchActionType== MatchActionType.GOAL_KEEPER)
            return ContextCompat.getDrawable(context, R.drawable.icon_goal_keeper);
        else if(matchActionType== MatchActionType.LINEMAN)
            return ContextCompat.getDrawable(context, R.drawable.icon_lineman);
        else
            return ContextCompat.getDrawable(context, R.drawable.icon_normal);


    }

    @Override
    public int getItemCount() {
        return lMatchAction.size();
    }


    private MatchAction getItem(int position) {
        return lMatchAction.get(position);
    }



}