import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Vending here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Vending{
    private Map<Integer, Product> daftarProduct;
    private List<String> logTransaksi;
    private double uangMesin;
    private int nextProductId = 1;

    public Vending() {
        this.daftarProduct = new HashMap<>();
        this.logTransaksi = new ArrayList<>();
        this.uangMesin = 0.0;
        
        tambahProduct("SilverQueen", 15000.0, 5);
        tambahProduct("Aqua", 3000.0, 10);
        tambahProduct("Oreo", 10000.0, 4);
        tambahProduct("Chitato", 12000.0, 2);
        tambahProduct("Coca Cola", 8000.0, 1);
    }

    public void tambahProduct(String nama, double harga, int stok) {
        daftarProduct.put(nextProductId++, new Product(nama, harga, stok));
    }

    public void tampilkanMenu() {
        System.out.println("\n========= VENDING SNACK MACHINE =========");
        for (Map.Entry<Integer, Product> entry : daftarProduct.entrySet()) {
            Product p = entry.getValue();
            System.out.printf("[%d] %s\t|Rp %.1f\t|Stok: %d\n", entry.getKey(), p.getName(), p.getPrice(), p.getStock());
        }
        System.out.println("=========================================");
        cekStokHabis(); 
    }

    public Product getProduct(int id) {
        return daftarProduct.get(id);
    }

    public boolean prosesPembelian(int idProduct, double uangDibayarkan) {
        Product Product = daftarProduct.get(idProduct);

        if (Product == null) {
            System.out.println("--- Transaksi Gagal ---");
            System.out.println("Pilihan Product tidak valid.");
            return false;
        }

        if (Product.getStock() <= 0) {
            System.out.println("--- Transaksi Gagal ---");
            System.out.println("Stok Product '" + Product.getName() + "' habis.");
            return false;
        }

        double harga = Product.getPrice();
        if (uangDibayarkan < harga) {
            System.out.println("--- Transaksi Gagal ---");
            double kurang = harga - uangDibayarkan;
            System.out.printf("Pembayaran kurang. Uang yang dimasukkan: Rp %.1f. Kurang: Rp %.1f\n", uangDibayarkan, kurang);
            System.out.println("Uang Anda dikembalikan.");
            return false;
        }

        Product.reduceStock(); 
        double kembalian = uangDibayarkan - harga;
        this.uangMesin += harga; 

        System.out.println("\n--- Transaksi Berhasil ---");
        System.out.println("Product: " + Product.getName() + " telah dikeluarkan.");
        if (kembalian > 0) {
            System.out.printf("Kembalian Anda: Rp %.1f\n", kembalian);
        } else {
            System.out.println("Tidak ada kembalian.");
        }
        
        simpanLog(Product.getName(), harga, uangDibayarkan, kembalian);

        return true;
    }
    
    private void simpanLog(String namaProduct, double harga, double bayar, double kembalian) {
        String logEntry = String.format("Pembelian %s, Harga: %.1f, Bayar: %.1f, Kembalian: %.1f",
                                        namaProduct, harga, bayar, kembalian);
        logTransaksi.add(logEntry);
    }
    
    public void cekStokHabis() {
        for (Product p : daftarProduct.values()) {
            if (p.getStock() == 0) {
                System.out.println("PERINGATAN: Stok '" + p.getName() + "' HABIS. Admin perlu mengisi ulang.");
            }
        }
    }


    public boolean loginAdmin(String pw){
        if(!pw.equals("admin123")){ 
            System.out.println("Akses ditolak. Password admin salah.");
            return false;
        }else{
            return true;
        }
    }
    public void tampilkanLaporan() {
        System.out.println("\n====== LAPORAN VENDING MACHINE ======");
        System.out.printf("Total Uang Mesin: Rp %.1f\n\n", this.uangMesin);
        
        System.out.println("--- Stok Product Terbaru ---");
        int i = 1;
        for (Product p : daftarProduct.values()) {

            System.out.printf("[%d] "+p.getName() + ": " + p.getStock() + "\n",i++);
        }
        
        System.out.println("--- Log Transaksi ---");
        if (logTransaksi.isEmpty()) {
            System.out.println("(Belum ada transaksi)");
        } else {
            for (String log : logTransaksi) {
                System.out.println(log);
            }
        }
        System.out.println("=====================================");
    }
}
