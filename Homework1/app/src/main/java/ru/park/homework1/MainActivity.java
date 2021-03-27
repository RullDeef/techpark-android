package ru.park.homework1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressWarnings("FieldCanBeLocal")
    private ListFragment listFragment;

    private DisplayFragment displayFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NumModelRepository.initRepo(savedInstanceState);

        if (savedInstanceState != null) {
            listFragment = (ListFragment) getSupportFragmentManager()
                    .findFragmentByTag(ListFragment.TAG);
        } else {
            listFragment = new ListFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, listFragment, ListFragment.TAG)
                    .commit();
        }

        listFragment.setCallback(new NumModel.Callback() {
            @Override
            public void invoke(NumModel model) {
                displayFragment = (DisplayFragment) getSupportFragmentManager()
                        .findFragmentByTag(DisplayFragment.TAG);
                if (displayFragment == null)
                    displayFragment = new DisplayFragment();
                displayFragment.setDisplayNumModel(model);

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, displayFragment, DisplayFragment.TAG)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        NumModelRepository.saveRepo(outState);
    }
}
