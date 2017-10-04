package sample.zemoso.com.nestedrecyclerview.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sample.zemoso.com.nestedrecyclerview.R;
import sample.zemoso.com.nestedrecyclerview.view_holders.StoryViewHolder;

/**
 * @author vin
 * Created on 4/10/17.
 */

public class StoryAdapter extends Adapter<StoryViewHolder> {

    private Context mContext;

    private int colors[] = {
            Color.YELLOW,
            Color.RED,
            Color.GREEN,
            Color.BLUE
    };

    public StoryAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public StoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.story_layout, parent, false);
        return new StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StoryViewHolder holder, int position) {
        int adapterPosition = holder.getAdapterPosition();
        holder.getStoryImage().setBackgroundColor(colors[(adapterPosition % colors.length)]);
    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
