package ru.park.homework1;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NumViewHolder extends RecyclerView.ViewHolder {
    public NumViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void feedData(final NumModel model, final ListFragment.Callback callback) {
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
