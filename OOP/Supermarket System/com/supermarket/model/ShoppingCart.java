package com.supermarket.model;

import com.supermarket.docs.JavadocProduct;
import java.util.HashMap;
import java.util.Map;

/**
 * Merepresentasikan keranjang belanja.
 * Menggunakan wrapper class 'Integer' untuk kuantitas produk.
 */
public class ShoppingCart {
    private Map<JavadocProduct, Integer> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void addItem(JavadocProduct product, int quantity) { // quantity adalah int
        // Autoboxing terjadi saat 'quantity' dimasukkan ke Map<..., Integer>
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Map.Entry<JavadocProduct, Integer> entry : items.entrySet()) {
            int quantity = entry.getValue(); // Unboxing dari Integer ke int
            total += entry.getKey().getPrice() * quantity;
        }
        return total;
    }
}