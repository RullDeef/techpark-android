package ru.park.homework1;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NumViewHolder extends RecyclerView.ViewHolder {
    public NumViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @SuppressLint("SetTextI18n")
    public void feedData(final @NonNull Integer number) {
        TextView textView = itemView.findViewById(R.id.text_view);
        textView.setText(number.toString());
        textView.setTextColor(number % 2 == 0 ? Color.RED : Color.BLUE);
    }
}
