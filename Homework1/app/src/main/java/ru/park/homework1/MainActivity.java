package ru.park.homework1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListFragment listFragment;
        final DisplayFragment displayFragment;
        if (savedInstanceState == null) {
            listFragment = new ListFragment();
            displayFragment = new DisplayFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, listFragment, ListFragment.TAG)
                    .commit();
        } else {
            Fragment fragment = getSupportFragmentManager().findFragmentByTag(ListFragment.TAG);
            listFragment = fragment == null ? new ListFragment() : (ListFragment) fragment;

            fragment = getSupportFragmentManager().findFragmentByTag(DisplayFragment.TAG);
            displayFragment = fragment == null ? new DisplayFragment() : (DisplayFragment) fragment;
        }

        listFragment.setCallback(new NumModel.Callback() {
            @Override
            public void invoke(NumModel model) {
                displayFragment.setDisplayNumModel(model);

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, displayFragment, DisplayFragment.TAG)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}
