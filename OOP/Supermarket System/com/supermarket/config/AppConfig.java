package com.supermarket.config;

/**
 * Kelas ini berisi konstanta dan konfigurasi global untuk aplikasi.
 * Menggunakan 'static final' untuk nilai yang tidak akan pernah berubah.
 */
public class AppConfig {
    public static final String STORE_NAME = "Gemini Fresh Mart";
    public static final double TAX_RATE = 0.11; // PPN 11%
    private static int transactionCount = 0; // Variabel static untuk menghitung transaksi

    /**
     * Metode static untuk menambah jumlah transaksi.
     */
    public static void incrementTransactionCount() {
        transactionCount++;
    }

    /**
     * Metode static untuk mendapatkan jumlah transaksi saat ini.
     * @return jumlah total transaksi.
     */
    public static int getTransactionCount() {
        return transactionCount;
    }
}