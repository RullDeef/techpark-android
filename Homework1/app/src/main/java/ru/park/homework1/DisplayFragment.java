package ru.park.homework1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DisplayFragment extends Fragment {

    public DisplayFragment() {
        super(R.layout.display_fragment);
    }

    public void setDisplayNumber(int number, int color) {
        this.number = number;
        this.color = color;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        TextView textView = view.findViewById(R.id.text_view);
        textView.setText(String.valueOf(number));
        textView.setTextColor(color);
    }

    private int number;
    private int color;
}
