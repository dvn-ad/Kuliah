package com.supermarket.app;

import com.supermarket.config.AppConfig;
import com.supermarket.docs.JavadocProduct;
import com.supermarket.service.InventoryManager;
import com.supermarket.util.RandomDeals;

/**
 * Kelas utama yang menjalankan simulasi sistem supermarket.
 * Ini adalah titik masuk (entry point) dari aplikasi.
 */
public class SupermarketSystem {
    public static void main(String[] args) {
        System.out.println("Selamat datang di " + AppConfig.STORE_NAME);
        System.out.println("==========================================");

        // Membuat dan mengisi inventaris
        InventoryManager inventory = new InventoryManager();
        inventory.addProduct(new JavadocProduct("Susu UHT", 20000, 50));
        inventory.addProduct(new JavadocProduct("Roti Tawar", 15000, 30));
        inventory.displayInventory();

        // Menampilkan penawaran acak
        RandomDeals.showDailyDeal(inventory.getAllProducts());
    }
}