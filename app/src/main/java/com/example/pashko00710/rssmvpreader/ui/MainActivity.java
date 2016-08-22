/*
 * Copyright (2015) Alexey Mitutov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.pashko00710.rssmvpreader.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.pashko00710.rssmvpreader.R;
import com.example.pashko00710.rssmvpreader.utils.ReadRss;
import com.example.pashko00710.rssmvpreader.injection.IHasComponent;
import com.example.pashko00710.rssmvpreader.injection.components.ActivityComponent;
import com.example.pashko00710.rssmvpreader.ui.presenter.MainActivityPresenterImpl;
import com.example.pashko00710.rssmvpreader.ui.view.IMainActivityView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements IMainActivityView, IHasComponent<ActivityComponent> {

    @Inject
    MainActivityPresenterImpl presenter;

    RecyclerView recyclerView;

    private ActivityComponent mainActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ReadRss readRss = new ReadRss(this, recyclerView);
        readRss.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public ActivityComponent getComponent() {
        return mainActivityComponent;
    }
}
