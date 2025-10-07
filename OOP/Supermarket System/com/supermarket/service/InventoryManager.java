package com.supermarket.service;

import com.supermarket.docs.JavadocProduct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Mengelola katalog atau inventaris produk menggunakan Map.
 * Kunci adalah nama produk (String) dan nilai adalah objek JavadocProduct.
 */
public class InventoryManager {
    private Map<String, JavadocProduct> productCatalog;

    public InventoryManager() {
        this.productCatalog = new HashMap<>();
    }

    public void addProduct(JavadocProduct product) {
        productCatalog.put(product.getName().toLowerCase(), product);
    }

    public JavadocProduct getProduct(String name) {
        return productCatalog.get(name.toLowerCase());
    }

    public List<JavadocProduct> getAllProducts() {
        return new ArrayList<>(productCatalog.values());
    }

    public void displayInventory() {
        System.out.println("\n--- Inventaris Produk ---");
        for (JavadocProduct product : productCatalog.values()) {
            System.out.println(product);
        }
    }
}