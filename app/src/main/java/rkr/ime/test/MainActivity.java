package rkr.ime.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;

import java.util.HashMap;

public class MainActivity extends Activity implements TabHost.TabContentFactory {

    private final HashMap<String, View> tabs = new HashMap<>();
    private static final int[] tabNames = new int[] {R.string.tab_text_1, R.string.tab_text_2};
    private static final int[] tabLayouts = new int[] {R.layout.activity_main_tab1, R.layout.activity_main_tab2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TabHost tabHost = findViewById(android.R.id.tabhost);
        tabHost.setup();
        for (int i=0; i<tabNames.length; i++) {
            String name = getResources().getString(tabNames[i]);

            tabs.put(name, LayoutInflater.from(this).inflate(tabLayouts[i], null));
            tabHost.addTab(tabHost.newTabSpec(name).setIndicator(name).setContent(this));
        }
    }

    @Override
    public View createTabContent(String tag) {
        return tabs.get(tag);
    }
}