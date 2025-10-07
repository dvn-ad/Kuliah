package com.supermarket.docs;

/**
 * Kelas ini merepresentasikan sebuah produk yang dijual di supermarket.
 * Setiap produk memiliki nama, harga, dan stok.
 *
 * @author Gemini
 * @version 2.0
 * @since 2025-10-07
 */
public class JavadocProduct {
    private String name;
    private double price;
    private int stock;

    /**
     * Konstruktor untuk membuat objek produk baru.
     *
     * @param name Nama dari produk.
     * @param price Harga satuan produk.
     * @param stock Jumlah stok awal produk.
     */
    public JavadocProduct(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Mengembalikan nama produk.
     * @return sebuah String yang berisi nama produk.
     */
    public String getName() {
        return name;
    }

    /**
     * Mengembalikan harga produk.
     * @return sebuah double yang merupakan harga produk.
     */
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Produk: %s, Harga: Rp %,.2f, Stok: %d", name, price, stock);
    }
}