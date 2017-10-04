package sample.zemoso.com.nestedrecyclerview.java_beans;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import sample.zemoso.com.nestedrecyclerview.utils.Constants;

/**
 * @author vin
 * Created on 4/10/17.
 */

public class FeedData {

    private final static String TAG = FeedData.class.getSimpleName();

    private final int storyId;

    public FeedData(int storyId) {
        this.storyId = storyId;
    }

    public FeedData(JSONObject storyData) {
        int storyId1;
        try {
            storyId1 = storyData.getInt(Constants.JSONKeys.STORY_ID);
        } catch (JSONException e) {
            storyId1 = -1;
            Log.e(TAG, "unable to initialize object", e);
        }
        this.storyId = storyId1;
    }

    public int getStoryId() {
        return storyId;
    }
}
