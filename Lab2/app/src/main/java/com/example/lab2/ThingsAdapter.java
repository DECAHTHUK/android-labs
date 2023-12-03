package com.example.lab2;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ThingsAdapter extends RecyclerView.Adapter<ThingsAdapter.ThingsHolder> {

    private final List<Pair<String, String>> things;

    private Context context;

    public ThingsAdapter(List<Pair<String, String>> things) {
        this.things = things;
    }

    public void addNewItem(String thingName, String thingQuantity, int position) {
        things.add(position, new Pair<>(thingName, thingQuantity));
        notifyItemInserted(position);
    }

    public void deleteItem(int position) {
        things.remove(position);
        notifyItemRemoved(position);
    }

    @NonNull
    @Override
    public ThingsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.things, parent, false);
        this.context = parent.getContext();
        return new ThingsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThingsHolder holder, int position) {
        holder.getThing().setText(things.get(position).first);
        holder.getQuantity().setText(context.getString(R.string.sht_text, things.get(position).second));
        holder.getDeleteButton().setOnClickListener(t -> deleteItem(position));
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return things.size();
    }

    public static class ThingsHolder extends RecyclerView.ViewHolder {

        private final TextView thing;

        private final TextView quantity;

        private final Button deleteButton;

        public ThingsHolder(@NonNull View itemView) {
            super(itemView);
            thing = itemView.findViewById(R.id.thing);
            quantity = itemView.findViewById(R.id.quantity);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }

        public TextView getThing() {
            return thing;
        }

        public TextView getQuantity() {
            return quantity;
        }

        public Button getDeleteButton() {
            return deleteButton;
        }
    }
}
