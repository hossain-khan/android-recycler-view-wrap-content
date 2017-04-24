package info.hossainkhan.recyclerviewdemo;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String GITHUB_PROJECT_URL = "https://github.com/amardeshbd/android-recycler-view-wrap-content";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Select a demo view from navigation bar to test " +
                "`RecyclerView` wrap_content issue inside `ScrollView`.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.demo_without_fix) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            //You can then add a fragment using the add() method, specifying the fragment to add and the view in which to insert it. For example:
            RecyclerViewWrapContentIssueDemoFragment fragment = new RecyclerViewWrapContentIssueDemoFragment();

            fragmentTransaction.replace(R.id.content_fragment, fragment);
            fragmentTransaction.commit();

            Toast.makeText(this, String.format(getString(R.string.selected_demo_type), getString(R.string.title_no_fix_applied)), Toast.LENGTH_SHORT).show();
        } else if (id == R.id.demo_with_fix) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            //You can then add a fragment using the add() method, specifying the fragment to add and the view in which to insert it. For example:
            RecyclerViewWrapContentFixDemoFragment fragment = new RecyclerViewWrapContentFixDemoFragment();

            fragmentTransaction.replace(R.id.content_fragment, fragment);
            fragmentTransaction.commit();

            Toast.makeText(this, String.format(getString(R.string.selected_demo_type), getString(R.string.title_with_relative_layout_wrapper_fix)), Toast.LENGTH_SHORT).show();
        } else if (id == R.id.demo_with_nested_scrollview_fix) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            //You can then add a fragment using the add() method, specifying the fragment to add and the view in which to insert it. For example:
            RecyclerViewNestedScrollviewFixDemoFragment fragment = new RecyclerViewNestedScrollviewFixDemoFragment();

            fragmentTransaction.replace(R.id.content_fragment, fragment);
            fragmentTransaction.commit();

            Toast.makeText(this, String.format(getString(R.string.selected_demo_type), getString(R.string.title_with_nestedscrollview_fix)), Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_share) {
            // https://developer.android.com/training/sharing/send.html
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Checkout sample project on RecyclerView wrap content workaround: " + GITHUB_PROJECT_URL);
            sendIntent.setType("text/plain");
            startActivity(Intent.createChooser(sendIntent, "Share..."));

        } else if (id == R.id.nav_send) {
            String url = GITHUB_PROJECT_URL;
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
