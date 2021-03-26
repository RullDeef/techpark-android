package ru.park.homework1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DisplayFragment extends Fragment {

    private static final String BUNDLE_NUM_MODEL_KEY = "num_model";
    public static final String TAG = "display_fragment";

    private NumModel numModel;

    public DisplayFragment() {
        super(R.layout.display_fragment);
    }

    public void setDisplayNumModel(NumModel model) {
        this.numModel = model;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            numModel = (NumModel) savedInstanceState.getSerializable(BUNDLE_NUM_MODEL_KEY);
        }

        TextView textView = view.findViewById(R.id.text_view);
        textView.setText(String.valueOf(numModel.getNumber()));
        textView.setTextColor(numModel.getColor());
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(BUNDLE_NUM_MODEL_KEY, numModel);
    }
}
