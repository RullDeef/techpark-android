package ru.park.homework1;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NumsAdapter extends RecyclerView.Adapter<NumViewHolder> {
    private List<Integer> numbers;
    private View.OnClickListener itemListener;

    NumsAdapter(@NonNull final View.OnClickListener itemListener) {
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public NumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item, parent, false);
        view.findViewById(R.id.text_view).setOnClickListener(itemListener);
        return new NumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumViewHolder holder, int position) {
        holder.feedData(numbers.get(position));
    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    public void updateNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
