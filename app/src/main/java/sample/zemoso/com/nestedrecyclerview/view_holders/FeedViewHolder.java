package sample.zemoso.com.nestedrecyclerview.view_holders;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

import sample.zemoso.com.nestedrecyclerview.R;

/**
 * @author vin
 * Created on 4/10/17.
 */

public class FeedViewHolder extends ViewHolder{

    private TextView count;

    public FeedViewHolder(View itemView) {
        super(itemView);
        count = itemView.findViewById(R.id.feed_text);
    }

    public TextView getCount() {
        return count;
    }
}
