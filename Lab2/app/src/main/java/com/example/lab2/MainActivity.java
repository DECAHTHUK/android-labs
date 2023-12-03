package com.example.lab2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private final ThingsAdapter thingsAdapter = new ThingsAdapter(new ArrayList<>());

    @Override
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.main_activity);

        RecyclerView recyclerView = findViewById(R.id.productList);
        recyclerView.setAdapter(thingsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    public void addNewProduct(View view) {
        EditText thingNameEditText = findViewById(R.id.thingName);
        String thingName = thingNameEditText.getText().toString();
        thingNameEditText.setText("");

        EditText thingQuantityEditText = findViewById(R.id.thingQuantity);
        String thingQuantity = thingQuantityEditText.getText().toString();
        thingQuantityEditText.setText("");

        if (thingName.isBlank() || thingName.isBlank()) {
            TextView errorMessage = findViewById(R.id.error_message);
            errorMessage.setVisibility(View.VISIBLE);
            return;
        }
        TextView errorMessage = findViewById(R.id.error_message);
        errorMessage.setVisibility(View.INVISIBLE);
        thingsAdapter.addNewItem(thingName, thingQuantity, 0);
    }
}
