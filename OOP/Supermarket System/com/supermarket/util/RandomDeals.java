package com.supermarket.util;

import com.supermarket.docs.JavadocProduct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Kelas utilitas untuk menghasilkan penawaran atau rekomendasi acak.
 */
public class RandomDeals {
    private static final Random random = new Random();

    /**
     * Memilih dan menampilkan satu produk sebagai penawaran harian.
     * @param products Daftar semua produk yang tersedia.
     */
    public static void showDailyDeal(List<JavadocProduct> products) {
        if (products == null || products.isEmpty()) {
            System.out.println("Tidak ada produk untuk penawaran hari ini.");
            return;
        }
        JavadocProduct deal = products.get(random.nextInt(products.size()));
        System.out.println("\n--- PENAWARAN SPESIAL HARI INI ---");
        System.out.println(deal.getName() + " hanya Rp " + (deal.getPrice() * 0.9)); // Diskon 10%
        System.out.println("---------------------------------");
    }
}