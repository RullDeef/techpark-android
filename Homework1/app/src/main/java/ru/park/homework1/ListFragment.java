package ru.park.homework1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListFragment extends Fragment {
    RecyclerView recyclerView;
    NumsAdapter numsAdapter;

    View.OnClickListener listener;

    public ListFragment(View.OnClickListener itemListener) {
        super(R.layout.list_fragment);
        numsAdapter = new NumsAdapter(itemListener);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button addButton = view.findViewById(R.id.button_add);
        addButton.setOnClickListener(listener);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 3));
        recyclerView.setAdapter(numsAdapter);
    }

    public void feedNumsList(@NonNull List<Integer> numbers) {
        numsAdapter.updateNumbers(numbers);
        numsAdapter.notifyDataSetChanged(); // bad for now
    }

    public void setAddCallback(@NonNull final View.OnClickListener listener) {
        this.listener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                listener.onClick(view);
                numsAdapter.notifyDataSetChanged(); // bad bad bad
            }
        };
    }
}
