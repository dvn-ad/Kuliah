package com.supermarket.util;

/**
 * Kelas utilitas untuk memproses input string, seperti tokenisasi.
 */
public class InputProcessor {
    /**
     * Memecah kalimat menjadi kata-kata (token).
     * @param query Kalimat input dari pengguna.
     * @return Array of String yang berisi kata-kata.
     */
    public static String[] tokenizeQuery(String query) {
        if (query == null || query.trim().isEmpty()) {
            return new String[0]; // return array kosong
        }
        // Memecah berdasarkan spasi dan mengubah ke huruf kecil
        return query.toLowerCase().split("\\s+");
    }
}