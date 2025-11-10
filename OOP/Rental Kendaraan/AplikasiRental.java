import java.util.ArrayList;

public class AplikasiRental {
    private ArrayList<Kendaraan> daftarKendaraan;
    private ArrayList<DataSewa> daftarSewa;

    public AplikasiRental() {
        daftarKendaraan = new ArrayList<>();
        daftarSewa = new ArrayList<>();
        inisialisasiData();
    }

    private void inisialisasiData() {
        daftarKendaraan.add(new Mobil("Toyota", "Avanza", 2020, 4, "B 1111 AA"));
        daftarKendaraan.add(new Motor("Honda", "Vario", 2022, 2, "L 5482 SAD"));
        daftarKendaraan.add(new Sepeda("Polygon", "Siskiu", 2023, "Balap"));
        daftarKendaraan.add(new Mobil("Toyota", "Innova", 2019, 4, "B 1234 CD"));
        daftarKendaraan.add(new Motor("Yamaha", "NMAX", 2021, 2, "B 5678 EF"));

        Penyewa p1 = new Penyewa("Andi", "3203010101900001");
        Penyewa p2 = new Penyewa("Budi", "3203010202900002");
        Penyewa p3 = new Penyewa("Ehsan", "3203010303900003");
        Penyewa p4 = new Penyewa("Davin", "3203010404900004");
        Penyewa p5 = new Penyewa("Upin", "3203010505900005");
        Penyewa p6 = new Penyewa("Ipin", "3203010606900006");
        Penyewa p7 = new Penyewa("Mail", "3203010707900007");

        
        daftarSewa.add(new DataSewa(p1, daftarKendaraan.get(0))); 
        daftarSewa.add(new DataSewa(p2, daftarKendaraan.get(2))); 
        daftarSewa.add(new DataSewa(p3, daftarKendaraan.get(1))); 
        daftarSewa.add(new DataSewa(p4, daftarKendaraan.get(3))); 
        daftarSewa.add(new DataSewa(p5, daftarKendaraan.get(4))); 
        daftarSewa.add(new DataSewa(p6, daftarKendaraan.get(0))); 
        daftarSewa.add(new DataSewa(p7, daftarKendaraan.get(1))); 
    }

    
    public void tampilkanListKendaraan() {
        System.out.println("=== LIST KENDARAAN TERSEDIA ===");
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Tidak ada kendaraan tersedia.");
            return;
        }
        
        int i = 1;
        for (Kendaraan k : daftarKendaraan) {
            System.out.printf("%d. %s\n", i++, k.getInfo());
        }
    }

    
    public void tampilkanDaftarPenyewa() {
        System.out.println("\n=== DAFTAR PENYEWA & KENDARAAN DISEWA ===");
        if (daftarSewa.isEmpty()) {
            System.out.println("Tidak ada data penyewaan.");
            return;
        }
        
        for (DataSewa ds : daftarSewa) {
            System.out.println(ds.getDetailSewa());
        }
        System.out.println("-------------------------------------");
    }

    public static void main(String[] args) {
        AplikasiRental app = new AplikasiRental();
        app.tampilkanListKendaraan();
        app.tampilkanDaftarPenyewa();
    }
}