package com.example.pashko00710.rssmvpreader.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;

import com.example.pashko00710.rssmvpreader.R;
import com.example.pashko00710.rssmvpreader.injection.IHasComponent;
import com.example.pashko00710.rssmvpreader.injection.components.ActivityComponent;
import com.example.pashko00710.rssmvpreader.ui.presenter.MainActivityPresenterImpl;
import com.example.pashko00710.rssmvpreader.ui.view.IMainActivityView;
import com.example.pashko00710.rssmvpreader.utils.ReadRss;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMainActivityView, IHasComponent<ActivityComponent> {

    @Inject
    MainActivityPresenterImpl presenter;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    Dialog dialog;
    ReadRss readRss;
    Editable text;

    private ActivityComponent mainActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        readRss = new ReadRss(this, recyclerView);
        readRss.execute();
    }
//
//    @OnClick(R.id.fab)
//    public void clickFab() {
////        presenter.infoFab(MainActivity.this);
//            dialog = new Dialog(MainActivity.this);
//            dialog.setContentView(R.layout.dialog_add_url_layout);
//            EditText editTextDialog = (EditText) dialog.findViewById(R.id.dialog_input_text);
//            Button buttonOk = (Button) dialog.findViewById(R.id.dialog_ok);
//            Button buttonCancel = (Button) dialog.findViewById(R.id.dialog_cancel);
//
//            buttonOk.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    text = editTextDialog.getText();
//                    Log.d("here", String.valueOf(TextUtils.isEmpty(text)));
//                    if(!TextUtils.isEmpty(text)) {
//                        if(!errorTextInput(getApplicationContext(), text)) {
////                        addCategory(text);
//                            readRss.addAddressSite(String.valueOf(text));
//                            dialog.dismiss();
//                        }
//                    } else {
//                        Toast.makeText(getApplicationContext(), R.string.emptylist, Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//            });
//
//            buttonCancel.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    dialog.dismiss();
//                }
//            });
//
//            dialog.getWindow().setBackgroundDrawableResource(android.R.color.background_light);
//            dialog.show();
//
//
//    }
//
//    private boolean errorTextInput(Context context, Editable text) {
//        if(text.length() < 2) {
//            Toast.makeText(context, R.string.min_letters, Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(context, R.string.nice, Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        return true;
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

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
