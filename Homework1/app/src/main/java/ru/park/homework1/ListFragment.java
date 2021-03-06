package ru.park.homework1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListFragment extends Fragment {

    public static final String TAG = "list_fragment";

    private NumModel.Callback callback;

    public ListFragment() {
        super(R.layout.list_fragment);
    }

    public void setCallback(NumModel.Callback callback) {
        this.callback = callback;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if (view == null)
            return null;

        int colsCount = getContext().getResources().getInteger(R.integer.list_cols_count);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), colsCount));

        final NumsAdapter adapter = new NumsAdapter();
        adapter.setCallback(callback);
        recyclerView.setAdapter(adapter);

        Button addButton = view.findViewById(R.id.button_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.notifyItemInserted(NumModelRepository.appendNum());
            }
        });

        return view;
    }
}
