import java.util.Scanner;

/**
 * Write a description of class Main here.
 *
 * @author davin
 * @version 1.0.0.0.0.0.0
 */
public class Main
{
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vending mesin = new Vending();
        int pilihan = -1;


        while (pilihan != 0) {
            mesin.tampilkanMenu();
            System.out.println("[0] Keluar");
            System.out.println("[-5] Admin Login");
            System.out.print("Pilih nomor produk: ");
            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // Konsumsi newline
            } else {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scanner.nextLine();
                continue;
            }

            if (pilihan > 0) {
                Product produkDipilih = mesin.getProduct(pilihan);
                if (produkDipilih != null) {
                    if(produkDipilih.getStock() == 0){
                        System.out.println("Stok produk habis. Silakan pilih produk lain.");
                        continue;
                    }
                    System.out.printf("Anda memilih: %s. Harga: Rp %.1f\n", produkDipilih.getName(), produkDipilih.getPrice());
                    System.out.print("Masukkan jumlah uang: ");
                    if (scanner.hasNextDouble()) {
                        double uang = scanner.nextDouble();
                        scanner.nextLine(); 
                        mesin.prosesPembelian(pilihan, uang);
                    } else {
                        System.out.println("Input uang tidak valid. Transaksi dibatalkan.");
                        scanner.nextLine(); 
                    }
                } else {
                    System.out.println("Pilihan produk tidak tersedia.");
                }
            }else if (pilihan == 0) {
                System.out.println("Terima kasih");
            }else if(pilihan == -5){
                System.out.print("Masukkan password admin: ");
                String password = scanner.nextLine();
                if(mesin.loginAdmin(password)){
                    mesin.tampilkanLaporan();
                    mesin.cekStokHabis();
                    System.out.println("Refill produk? (Y/N)");
                    if(scanner.nextLine().equalsIgnoreCase("Y")){
                        System.out.print("Masukkan ID produk untuk refill: ");
                        if (scanner.hasNextInt()) {
                            int idRefill = scanner.nextInt();
                            scanner.nextLine(); 
                            Product p = mesin.getProduct(idRefill);
                            if (p != null) {
                                System.out.print("Masukkan jumlah stok yang ditambahkan: ");
                                if (scanner.hasNextInt()){
                                    int jumlahStok = scanner.nextInt();
                                    scanner.nextLine(); 
                                    p.addStock(jumlahStok);
                                    System.out.println("Stok berhasil ditambahkan.");
                                    pilihan = -1;
                                } else {
                                    System.out.println("Invalid");
                                    scanner.nextLine(); 
                                }
                            }else{
                                System.out.println("Produk dengan ID tersebut tidak ditemukan.");
                            }
                        }else{
                            System.out.println("Input ID produk tidak valid.");
                            scanner.nextLine(); 
                        }
                    }else {
                        pilihan = -1; 
                    }
                }
            }else{
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
        scanner.close();
    }
}
