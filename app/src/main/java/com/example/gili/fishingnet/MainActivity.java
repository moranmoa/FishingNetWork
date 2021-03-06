package com.example.gili.fishingnet;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    //private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Firebase.setAndroidContext(this);
        /*
        Assigning view variables to their respective view in xml
        by findViewByID method
         */
        //toolbar = (Toolbar) findViewById(R.id.tool_bar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        /*
        Creating Adapter and setting that adapter to the viewPager
        setSupportActionBar method takes the toolbar and sets it as
        the default action bar thus making the toolbar work like a normal
        action bar.
         */
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        //setSupportActionBar(toolbar);

        /*
        TabLayout.newTab() method creates a tab view, Now a Tab view is not the view
        which is below the tabs, its the tab itself.
         */
        final TabLayout.Tab home = tabLayout.newTab();
        final TabLayout.Tab reports = tabLayout.newTab();
        final TabLayout.Tab meetings = tabLayout.newTab();
        final TabLayout.Tab dag2 = tabLayout.newTab();
        final TabLayout.Tab chat = tabLayout.newTab();
        final TabLayout.Tab weather = tabLayout.newTab();
        final TabLayout.Tab list = tabLayout.newTab();
        final TabLayout.Tab recycler = tabLayout.newTab();
        final TabLayout.Tab maps = tabLayout.newTab();

        /*
        Setting Title text for our tabs respectively
         */
        home.setText("ראשי");
        reports.setText("דיווחים");
        meetings.setText("מפגשים");
        dag2.setText("דג2");
        chat.setText("צ'אט");
        weather.setText("weather");
        list.setText("list");
        recycler.setText("recycler");
        maps.setText("Maps");


        /*
        Adding the tab view to our tablayout at appropriate positions
        As I want home at first position I am passing home and 0 as argument to
        the tablayout and like wise for other tabs as well
         */
        tabLayout.addTab(home, 0);
        tabLayout.addTab(reports, 1);
        tabLayout.addTab(meetings, 2);
        tabLayout.addTab(dag2, 3);
        //tabLayout.addTab(chat, 4);
        //tabLayout.addTab(weather,5);
        //tabLayout.addTab(list,6);
        //tabLayout.addTab(recycler,7);
        tabLayout.addTab(maps,4);
        //tabLayout.setSelectedTabIndicatorColor(4);

        /*
        TabTextColor sets the color for the title of the tabs, passing a ColorStateList here makes
        tab change colors in different situations such as selected, active, inactive etc

        TabIndicatorColor sets the color for the indiactor below the tabs
         */

        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this, R.drawable.tab_selector));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.indicator));


        /*
        Adding an onPageChangeListener to the viewPager
        1st we add the PageChangeListener and pass a TabLayoutPageChangeListener so that Tabs Selection
        changes when a viewpager page changes.
         */

        viewPager.setClickable(true);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                super.onTabSelected(tab);
                //tab.getIcon().setAlpha(255);
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                super.onTabUnselected(tab);
                //tab.getIcon().setAlpha(127);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        else if (id == R.id.shareApp) {

            Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "דגים");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "https://www.facebook.com/groups/1749175708646262/");
            startActivity(Intent.createChooser(shareIntent, "בחר איפה לשתף את האפליקציה"));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
