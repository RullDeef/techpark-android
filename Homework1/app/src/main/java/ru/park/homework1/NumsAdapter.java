package ru.park.homework1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NumsAdapter extends RecyclerView.Adapter<NumsAdapter.NumViewHolder> {

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

    public static class NumViewHolder extends RecyclerView.ViewHolder {
        public NumViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void feedData(final NumModel model, final NumModel.Callback callback) {
            TextView textView = itemView.findViewById(R.id.text_view);

            textView.setText(String.valueOf(model.getNumber()));
            textView.setTextColor(model.getColor());

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    callback.invoke(model);
                }
            });
        }
    }
}
