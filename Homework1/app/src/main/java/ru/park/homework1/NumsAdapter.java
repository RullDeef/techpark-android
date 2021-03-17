package ru.park.homework1;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NumsAdapter extends RecyclerView.Adapter<NumViewHolder> {

    public void setCallback(ListFragment.Callback callback) {
        this.callback = callback;
    }

    @NonNull
    @Override
    public NumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item, parent, false);
        return new NumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumViewHolder holder, int position) {
        int number = NumsRepository.getNumAt(position);
        int color = number % 2 == 0 ? Color.RED : Color.BLUE;

        holder.feedData(number, color, callback);
    }

    @Override
    public int getItemCount() {
        return NumsRepository.getNumsCount();
    }

    private ListFragment.Callback callback;
}
