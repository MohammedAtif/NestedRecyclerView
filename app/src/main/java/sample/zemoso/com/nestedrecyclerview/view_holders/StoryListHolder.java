package sample.zemoso.com.nestedrecyclerview.view_holders;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

import sample.zemoso.com.nestedrecyclerview.R;

/**
 * @author vin
 * Created on 4/10/17.
 */

public class StoryListHolder extends ViewHolder{

    private RecyclerView storyRecyclerView;

    public StoryListHolder(View itemView) {
        super(itemView);
        storyRecyclerView = itemView.findViewById(R.id.story_recycler_view);
    }

    public RecyclerView getStoryRecyclerView() {
        return storyRecyclerView;
    }
}
