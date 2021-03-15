package ru.park.homework1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DisplayFragment extends Fragment {
    Integer number = 0;

    public DisplayFragment() {
        super(R.layout.display_fragment);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        TextView textView = view.findViewById(R.id.text_view);
        textView.setText(number.toString());
    }

    public void setDisplayNumber(final @NonNull Integer number) {
        this.number = number;
    }
}
