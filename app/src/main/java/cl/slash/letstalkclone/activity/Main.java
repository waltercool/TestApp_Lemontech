package cl.slash.letstalkclone.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import cl.slash.letstalkclone.adapter.MainDrawerListAdapter;
import cl.slash.letstalkclone.fragment.ConfigurationFragment;
import cl.slash.letstalkclone.fragment.MessageList;
import cl.slash.letstalkclone.obj.MainDrawerListItem;
import letstalkclone.lemontechapp.slash.cl.testapp_lemontech.R;

/**
 * Created by waltercool on 01-09-14.
 */
public class Main extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private static final int    MENU_OPEN_MESSAGES = 10,
                                MENU_CLOSED_MESSAGES = 20,
                                MENU_CONFIGURATION = 30;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureDrawer();
        initializeMainFragment();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initializeMainFragment() {
        Fragment openMessages = new MessageList();
        Bundle args = new Bundle();
        args.putInt(MessageList.TYPE_MESSAGE, MessageList.TYPE_OPEN);
        openMessages.setArguments(args);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.activity_main_fragmentcontainer, openMessages);
        ft.commit();
    }

    private void configureDrawer() {
        ListView drawerList = (ListView)findViewById(R.id.activity_main_drawerList);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.activity_main_drawer);
        ArrayList<MainDrawerListItem> menuItems = new ArrayList<MainDrawerListItem>();
        menuItems.add(new MainDrawerListItem(MENU_OPEN_MESSAGES, "Opened messages", 0));
        menuItems.add(new MainDrawerListItem(MENU_CLOSED_MESSAGES, "Closed messages", 0));
        menuItems.add(new MainDrawerListItem(MENU_CONFIGURATION, "Configuration", 0));

        drawerList.setAdapter(new MainDrawerListAdapter(this, menuItems));
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_navigation_drawer,
                R.string.accessibility_open_main_drawer, R.string.accessibility_close_main_drawer);
        drawerList.setOnItemClickListener(this);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MainDrawerListAdapter adapter = (MainDrawerListAdapter)parent.getAdapter();
        MainDrawerListItem item = adapter.getItem(position);
        Fragment fReplacement = null;
        Bundle args = new Bundle();
        switch (item.getId()) {
            case MENU_OPEN_MESSAGES:
                fReplacement = new MessageList();
                args.putInt(MessageList.TYPE_MESSAGE,MessageList.TYPE_OPEN);
                break;
            case MENU_CLOSED_MESSAGES:
                fReplacement = new MessageList();
                args.putInt(MessageList.TYPE_MESSAGE,MessageList.TYPE_CLOSED);
                break;
            case MENU_CONFIGURATION:
                fReplacement = new ConfigurationFragment();
                break;
        }
        if(fReplacement != null) {
            fReplacement.setArguments(args);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.activity_main_fragmentcontainer, fReplacement);
            ft.commit();
        }
        mDrawerLayout.closeDrawer(Gravity.START);
    }
}
