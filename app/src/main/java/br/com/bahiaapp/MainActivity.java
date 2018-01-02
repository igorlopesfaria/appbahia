package br.com.bahiaapp;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import br.com.bahiaapp.fragment.FeedListFragment;
import br.com.bahiaapp.fragment.MatchListFragment;
import br.com.bahiaapp.model.Feed;

/**
 * Created by Igor Faria on 02/01/18.
 */
public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {


    private Fragment fragment;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        if (savedInstanceState == null) {
            // Add the fragment on initial activity setup
            fragment = FeedListFragment.newInstance();
            changeFragment(fragment, true);
        } else {
            // Or set the fragment from restored state info
            fragment =  getSupportFragmentManager().findFragmentById(android.R.id.content);
        }
    }
    void initialize() {
        toolbar =  findViewById(R.id.toolbar);
        drawerLayout =  findViewById(R.id.drawerLayout);
        navigationView =  findViewById(R.id.navigationView);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);


    }
    public void changeFragment(Fragment fragmentToChange, Boolean hasBack) {

        if(hasBack==true) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragmentToChange,
                            fragmentToChange.getClass().toString())
                    .commit();
        }else{
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container,
                            fragmentToChange, fragmentToChange.getClass().toString())
                    .addToBackStack(null)
                    .commit();

        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.news) {
            FeedListFragment fragment = FeedListFragment.newInstance();
            changeFragment(fragment, true);

        } else if(id == R.id.matches){
            MatchListFragment fragment = MatchListFragment.newInstance();
            changeFragment(fragment, true);

        }


        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
