package com.example.cart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private static ArrayList<CartItem> cartItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        LinearLayout itemsContainer = findViewById(R.id.items_container);

        String[] itemNames = {"iPad", "iPhone", "Mac", "Vision Pro", "AirPods", "Apple Logo"};
        String[] itemPrices = {"$599.99", "$999.99", "$1299.99", "$3499.99", "$249.99", "$0.99"};
        int[] itemImages = {
                R.drawable.ipad,
                R.drawable.iphone,
                R.drawable.mac,
                R.drawable.visionpro,
                R.drawable.airpods,
                R.drawable.img
        };

        for (int i = 0; i < itemNames.length; i++) {
            View itemView = getLayoutInflater().inflate(R.layout.item_layout, itemsContainer, false);

            ImageView imageView = itemView.findViewById(R.id.item_image);
            TextView nameTextView = itemView.findViewById(R.id.item_name);
            TextView priceTextView = itemView.findViewById(R.id.item_price);
            Button addToCartButton = itemView.findViewById(R.id.add_to_cart_button);

            imageView.setImageResource(itemImages[i]);
            nameTextView.setText(itemNames[i]);
            priceTextView.setText(itemPrices[i]);

            final int index = i;
            addToCartButton.setOnClickListener(v -> addToCart(itemNames[index], itemPrices[index], itemImages[index]));

            itemsContainer.addView(itemView);
        }

        Button viewCartButton = findViewById(R.id.view_cart_button);
        viewCartButton.setOnClickListener(v -> viewCart());
    }

    private void addToCart(String name, String price, int imageResource) {
        cartItems.add(new CartItem(name, price, imageResource));
        Toast.makeText(this, name + " added to cart", Toast.LENGTH_SHORT).show();
    }

    private void viewCart() {
        Intent intent = new Intent(SecondActivity.this, CartActivity.class);
        startActivity(intent);
    }

    public static ArrayList<CartItem> getCartItems() {
        return cartItems;
    }
}