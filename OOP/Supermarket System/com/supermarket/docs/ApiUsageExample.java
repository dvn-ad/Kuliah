package com.supermarket.docs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Kelas ini mendemonstrasikan penggunaan beberapa kelas dari Java API.
 * Kita menggunakan ArrayList untuk daftar, Date untuk waktu, dan Scanner untuk input.
 */
public class ApiUsageExample {
    public static void main(String[] args) {
        // Menggunakan java.util.List dan java.util.ArrayList
        List<String> groceries = new ArrayList<>();
        groceries.add("Apel");
        groceries.add("Susu");
        System.out.println("Daftar belanja: " + groceries);

        // Menggunakan java.util.Date
        Date today = new Date();
        System.out.println("Tanggal hari ini: " + today);

        // Menggunakan java.util.Scanner untuk input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama Anda: ");
        String name = scanner.nextLine();
        System.out.println("Halo, " + name + "!");
        scanner.close();
    }
}