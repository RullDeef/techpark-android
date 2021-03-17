package ru.park.homework1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public MainActivity() {
        super();

        listFragment.setCallback(new ListFragment.Callback() {
            @Override
            public void invoke(int number, int color) {
                displayNumber(number, color);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(null);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
            .beginTransaction()
            .add(R.id.fragment_container, listFragment, null)
            .commit();
    }

    private void displayNumber(final @NonNull Integer number, int color) {
        displayFragment.setDisplayNumber(number, color);

        getSupportFragmentManager()
            .beginTransaction()
            .remove(listFragment)
            .add(R.id.fragment_container, displayFragment, null)
            .addToBackStack(null)
            .commit();
    }

    private ListFragment listFragment = new ListFragment();
    private DisplayFragment displayFragment = new DisplayFragment();
}
