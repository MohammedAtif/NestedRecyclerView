package sample.zemoso.com.nestedrecyclerview.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import sample.zemoso.com.nestedrecyclerview.R;
import sample.zemoso.com.nestedrecyclerview.fragments.NewsFeedFragment;
import sample.zemoso.com.nestedrecyclerview.utils.Constants;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private FragmentManager fragmentManager;

    //region Lifecycle Methods

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, NewsFeedFragment.newInstance(), Constants.TransactionTag.NewsFeedFragment)
                .commit();
    }

    //endregion

    //region Interface Methods

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.navigation_home:{
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, NewsFeedFragment.newInstance(), Constants.TransactionTag.NewsFeedFragment)
                        .commit();
                break;
            }
            case R.id.navigation_dashboard:{
                break;
            }
            case R.id.navigation_notifications:{
                break;
            }
        }
        return false;
    }

    //endregion
}
