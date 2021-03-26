package ru.park.homework1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    private ListFragment listFragment;
    private DisplayFragment displayFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            listFragment = new ListFragment();
            displayFragment = new DisplayFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, listFragment, ListFragment.TAG)
                    .commit();
        } else {
            Fragment fragment = getSupportFragmentManager().findFragmentByTag(ListFragment.TAG);
            if (fragment != null)
                listFragment = (ListFragment) fragment;
            else
                listFragment = new ListFragment();

            fragment = getSupportFragmentManager().findFragmentByTag(DisplayFragment.TAG);
            if (fragment != null) {
                displayFragment = (DisplayFragment) fragment;
                // load displayed model from bundle

            }
            else
                displayFragment = new DisplayFragment();
        }

        listFragment.setCallback(new ListFragment.Callback() {
            @Override
            public void invoke(NumModel model) {
                displayNumModel(model);
            }
        });
    }

    private void displayNumModel(final @NonNull NumModel model) {
        displayFragment.setDisplayNumModel(model);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, displayFragment, DisplayFragment.TAG)
                .addToBackStack(null)
                .commit();
    }
}
