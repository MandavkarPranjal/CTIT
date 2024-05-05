package com.example.assignment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText editTextDish, editTextQuantity;
    private Button buttonAdd;
    private TextView textViewBill;
    private Map<String, Double> menu;
    private double totalBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextDish = findViewById(R.id.editTextDish);
        editTextQuantity = findViewById(R.id.editTextQuantity);
        buttonAdd = findViewById(R.id.buttonAdd);
        textViewBill = findViewById(R.id.textViewBill);

        menu = new HashMap<>();
        menu.put("Coffee", 2.50);
        menu.put("Tea", 1.50);
        menu.put("Sandwich", 5.00);
        menu.put("Cake", 3.00);

        totalBill = 0.0;

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dish = editTextDish.getText().toString();
                int quantity = Integer.parseInt(editTextQuantity.getText().toString());

                if (menu.containsKey(dish)) {
                    double price = menu.get(dish);
                    totalBill += price * quantity;
                    updateBill();
                }
            }
        });
    }

    private void updateBill() {
        DecimalFormat df = new DecimalFormat("0.00");
        textViewBill.setText("Total Bill: $" + df.format(totalBill));
    }
}
