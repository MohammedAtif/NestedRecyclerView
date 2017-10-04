package sample.zemoso.com.nestedrecyclerview.view_holders;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;

import sample.zemoso.com.nestedrecyclerview.R;

/**
 * @author vin
 * Created on 4/10/17.
 */

public class StoryViewHolder extends ViewHolder{

    private ImageView storyImage;

    public StoryViewHolder(View itemView) {
        super(itemView);
        storyImage = itemView.findViewById(R.id.story_image);
    }

    public ImageView getStoryImage() {
        return storyImage;
    }
}
