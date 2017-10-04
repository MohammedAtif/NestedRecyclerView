package sample.zemoso.com.nestedrecyclerview.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import sample.zemoso.com.nestedrecyclerview.R;
import sample.zemoso.com.nestedrecyclerview.adapters.FeedAdapter;
import sample.zemoso.com.nestedrecyclerview.adapters.StoryAdapter;
import sample.zemoso.com.nestedrecyclerview.interfaces.FeedInteractionListener;
import sample.zemoso.com.nestedrecyclerview.java_beans.FeedData;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeedFragment extends Fragment implements FeedInteractionListener{

    private final static String TAG = NewsFeedFragment.class.getSimpleName();

    private Context mContext;

    private RecyclerView feedView, storyView;
    private FeedAdapter feedAdapter;
    private StoryAdapter storyAdapter;
    private List<FeedData> feedDataList;

    //region Lifecycle Methods

    public NewsFeedFragment() {
        // Required empty public constructor
    }

    public static NewsFeedFragment newInstance() {
        return new NewsFeedFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        feedDataList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_feed, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        feedView = view.findViewById(R.id.feed_recycler_view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        feedAdapter = new FeedAdapter(mContext, feedDataList, this);
        storyAdapter = new StoryAdapter(mContext);
        feedView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        feedView.setItemAnimator(new DefaultItemAnimator());
        feedView.setAdapter(feedAdapter);
        getFeedData();
    }

    //endregion

    //region Public Methods


    //endregion

    //region Private Methods


    //endregion

    //region Server Interaction

    private void getFeedData(){
        Log.i(TAG, "Response received from server");
        for(int i=0;  i<32; i++){
            feedDataList.add(new FeedData(new JSONObject()));
        }
        Log.d(TAG, "total list size "+feedDataList.size());
        feedAdapter.notifyDataSetChanged();
    }

    //endregion

    //region Interface Methods

    @Override
    public boolean updateStoryList(RecyclerView storyRecyclerView) {
        if(storyView == null || !storyView.equals(storyRecyclerView)){
            storyView = storyRecyclerView;
            storyView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            storyView.setItemAnimator(new DefaultItemAnimator());
            storyView.setAdapter(storyAdapter);
            return true;
        }
        return false;
    }

    //endregion
}
