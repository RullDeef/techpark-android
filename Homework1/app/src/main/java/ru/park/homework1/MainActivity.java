package ru.park.homework1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> numbers = new ArrayList<>();

    ListFragment listFragment;
    DisplayFragment displayFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            generateNumbers();
            initFragments();

            getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, listFragment, null)
                .commit();
        }
    }

    private void initFragments() {
        listFragment = new ListFragment(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                TextView textView = (TextView) view;
                Integer number = Integer.parseInt(String.valueOf(textView.getText()));
                displayNumber(number);
            }
        });
        listFragment.setAddCallback(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNumber();
            }
        });
        listFragment.feedNumsList(numbers);

        displayFragment = new DisplayFragment();
    }

    private void displayNumber(final @NonNull Integer number) {
        displayFragment.setDisplayNumber(number);

        getSupportFragmentManager()
            .beginTransaction()
            .remove(listFragment)
            .add(R.id.fragment_container, displayFragment, null)
            .addToBackStack(null)
            .commit();
    }

    private void generateNumbers() {
        numbers.clear();
        for (int i = 1; i <= 100; i++)
            numbers.add(i);
    }

    private void appendNumber() {
        numbers.add(numbers.size() + 1);
        listFragment.feedNumsList(numbers);
    }
}
