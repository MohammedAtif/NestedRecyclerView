package sample.zemoso.com.nestedrecyclerview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;
import java.util.List;

import sample.zemoso.com.nestedrecyclerview.R;
import sample.zemoso.com.nestedrecyclerview.interfaces.FeedInteractionListener;
import sample.zemoso.com.nestedrecyclerview.java_beans.FeedData;
import sample.zemoso.com.nestedrecyclerview.utils.Constants;
import sample.zemoso.com.nestedrecyclerview.view_holders.FeedViewHolder;
import sample.zemoso.com.nestedrecyclerview.view_holders.StoryListHolder;

/**
 * @author vin
 * Created on 4/10/17.
 */

public class FeedAdapter extends Adapter<ViewHolder>{

    private Context mContext;
    private List<FeedData> feedDataList;

    private WeakReference<FeedInteractionListener> feedInteractionListener;

    public FeedAdapter(Context mContext, List<FeedData> feedDataList, FeedInteractionListener feedInteractionListener) {
        this.mContext = mContext;
        this.feedDataList = feedDataList;
        this.feedInteractionListener = new WeakReference<>(feedInteractionListener);
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return Constants.HolderType.Story;
        }else{
            return Constants.HolderType.Feed;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == Constants.HolderType.Story){
            View view = LayoutInflater.from(mContext)
                    .inflate(R.layout.story_layout, parent, false);
            return new StoryListHolder(view);
        }else if(viewType == Constants.HolderType.Feed){
            View view = LayoutInflater.from(mContext)
                    .inflate(R.layout.feed_layout, parent, false);
            return new FeedViewHolder(view);
        }else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int adapterPosition = holder.getAdapterPosition();
        if(holder instanceof StoryListHolder){
            feedInteractionListener.get().updateStoryList(((StoryListHolder) holder).getStoryRecyclerView());
        }else if (holder instanceof FeedViewHolder){
            FeedViewHolder viewHolder = (FeedViewHolder) holder;

        }
    }

    @Override
    public int getItemCount() {
        return feedDataList.size();
    }
}
