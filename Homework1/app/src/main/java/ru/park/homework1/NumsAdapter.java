package ru.park.homework1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NumsAdapter extends RecyclerView.Adapter<NumViewHolder> {

    private NumModel.Callback callback;

    public void setCallback(NumModel.Callback callback) {
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
        NumModel model = NumModelRepository.getNumAt(position);
        holder.feedData(model, callback);
    }

    @Override
    public int getItemCount() {
        return NumModelRepository.getNumsCount();
    }
}
