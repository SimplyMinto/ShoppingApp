package com.example.cart;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart); // Reference the new layout

        LinearLayout cartContainer = findViewById(R.id.cart_container);
        ArrayList<CartItem> cartItems = SecondActivity.getCartItems();

        if (cartItems.isEmpty()) {
            TextView emptyMessage = new TextView(this);
            emptyMessage.setText("Your cart is empty.");
            cartContainer.addView(emptyMessage);
        } else {
            for (CartItem item : cartItems) {
                TextView itemTextView = new TextView(this);
                itemTextView.setText(item.getName() + " - " + item.getPrice());
                cartContainer.addView(itemTextView);
            }
        }
    }
}
