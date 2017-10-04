package sample.zemoso.com.nestedrecyclerview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sample.zemoso.com.nestedrecyclerview.R;
import sample.zemoso.com.nestedrecyclerview.utils.Constants;
import sample.zemoso.com.nestedrecyclerview.view_holders.StoryListHolder;
import sample.zemoso.com.nestedrecyclerview.view_holders.StoryViewHolder;

/**
 * @author vin
 * Created on 4/10/17.
 */

public class StoryAdapter extends Adapter<StoryViewHolder> {

    private Context mContext;

    public StoryAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public StoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(StoryViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
