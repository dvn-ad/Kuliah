import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FRSSystem {
    private static List<MataKuliah> daftarMataKuliah = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Mahasiswa currMhsw;

    public static void main(String[] args) {
        setupData();

        inputMahasiswa();

        if (currMhsw != null) {
            menu();
        }
    }

    private static void setupData() {
        Dosen d1 = new Dosen("Fajar Baskoro, S.Kom., M.T.");
        Dosen d2 = new Dosen("Prof. Dr. Eng. Nanik Suciati, S.Kom., M.Kom.");
        Dosen d3 = new Dosen("Victor Hariadi, S.Si., M.Kom.");
        Dosen d4 = new Dosen("Prof. Ir. Ary Mazharuddin Shiddiqi, S.Kom., M.Comp.Sc., Ph.D.");
        Dosen d5 = new Dosen("Ir. Misbakhul Munir Irfan Subakti, S.Kom., M.Sc., M.Phil.");
        Dosen d6 = new Dosen("Ilham Gurat Adillion, S.Kom., M.Kom.");
        Dosen d7 = new Dosen("Ir. Adhatus Solichah Ahmadiyah, S.Kom., M.Sc.");

        daftarMataKuliah.add(new MataKuliah("EF234302", "Pemrograman Berbasis Objek", 3, d1));
        daftarMataKuliah.add(new MataKuliah("EF234301", "Pemrograman Web", 3, d5));
        daftarMataKuliah.add(new MataKuliah("EF234303", "Jaringan Komputer", 4, d4));
        daftarMataKuliah.add(new MataKuliah("EF234305", "Matematika Diskrit", 3, d6));
        daftarMataKuliah.add(new MataKuliah("EF234307", "KPPL", 3, d7));
        daftarMataKuliah.add(new MataKuliah("EK234201", "Konsep Kecerdasan Artifisial", 3, d2));
        daftarMataKuliah.add(new MataKuliah("EF234304", "Teori Graf", 3, d3));
    }

    private static void inputMahasiswa() {
        System.out.println("=== Sistem Pengambilan FRS ===");
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NRP: ");
        String nrp = scanner.nextLine();

        currMhsw = new Mahasiswa(nama, nrp);
        System.out.printf("Mahasiswa %s (%s) berhasil didaftarkan.\n\n", currMhsw.getNama(), currMhsw.getNRP());
    }

    private static void menu() {
        
        boolean exit = false;

        while (!exit) {
            System.out.println();
            System.out.println("--- MENU FRS ---");
            System.out.println("1. Ambil mata kuliah");
            System.out.println("2. Drop mata kuliah");
            System.out.println("3. Cek FRS");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi (1-4): ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 
            if(pilihan < 1 || pilihan > 4){
                System.out.println("invalid");
                continue;
            } 


            switch (pilihan) {
                case 1:
                    ambilMataKuliah();
                    break;
                case 2:
                    dropMataKuliah();
                    break;
                case 3:
                    cekFRS();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("invalid");
            }
        }
    }

    private static void tampilkanDaftarMatkul() {
        System.out.println();
        System.out.println("--- DAFTAR MATA KULIAH ---");
        System.out.println(String.format("%-15s | %-30s | %-5s | %s", 
                            "KODE", "NAMA MATKUL", "SKS", "DOSEN"));
        System.out.println("------------------------------------------------------------------------------------------------");
        for (int i = 0; i < daftarMataKuliah.size(); i++) {
            MataKuliah mk = daftarMataKuliah.get(i);
            System.out.println(String.format("%-15s | %-30s | %-5d | %s", 
                                mk.getKode(), 
                                mk.getNama(), 
                                mk.getSKS(), 
                                mk.getDosenPengampu().getNama()));
        }
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.printf("Total SKS sekarang: %d/24. Sisa SKS: %d\n", 
                          currMhsw.hitungTotalSKS(), currMhsw.getSisaSKS());
    }

    private static void ambilMataKuliah() {
        if (currMhsw.isMaksimumSKS()) {
            System.out.println("SKS melebihi 24.");
            return;
        }

        tampilkanDaftarMatkul();
        System.out.print("mmasukkan kode mata kuliah yang ingin diambil: ");
        String kode = scanner.nextLine();

        MataKuliah matkulDipilih = null;
        for (MataKuliah mk : daftarMataKuliah) {
            if (mk.getKode().equalsIgnoreCase(kode)) { //equalsIgnoreCase untuk ignore huruf besar kecil
                matkulDipilih = mk;
                break;
            }
        }

        if (matkulDipilih == null) {
            System.out.println("kode mata kuliah tidak ada");
            return;
        }

        if (currMhsw.sudahDiambil(kode)) {
            System.out.println("Mata kuliah " + matkulDipilih.getNama() + " sudah diambil");
            return;
        }

        int sksBaru = matkulDipilih.getSKS();
        if (currMhsw.hitungTotalSKS() + sksBaru > 24) {
            System.out.println("Gagal. SKS melebihi 24");
            return;
        }

        currMhsw.tambahMataKuliah(matkulDipilih);
        System.out.printf("mata kuliah %s ditambahkan ke FRS\n", matkulDipilih.getNama());
        System.out.printf("total SKS sekarang: %d/24.\n", currMhsw.hitungTotalSKS());
    }

    private static void dropMataKuliah() {
        if (currMhsw.getFRS().isEmpty()) {
            System.out.println("FRS masih kosong");
            return;
        }

        cekFRS();
        
        System.out.print("masukkan kode mata kuliah yang ingin di drop: ");
        String kode = scanner.nextLine();

        if (currMhsw.dropMataKuliah(kode)) {
            System.out.printf("mata kuliah kode %s di drop.\n", kode.toUpperCase());
            System.out.printf("Total SKS sekarang: %d/24.\n", currMhsw.hitungTotalSKS());
        } else {
            System.out.println("Gagal. kode mata kuliah tidak ada");
        }
    }

    private static void cekFRS() {
        System.out.println();
        System.out.println("--- FRS " + currMhsw.getNama()+ " ---");
        if (currMhsw.getFRS().isEmpty()) {
            System.out.println("FRS Anda masih kosong.");
            return;
        }

        System.out.println(String.format("%-15s | %-30s | %-70s | %s", 
                            "KODE", "NAMA MATKUL", "DOSEN", "SKS"));
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        for (MataKuliah mk : currMhsw.getFRS()) {
            System.out.println(mk.getRincian());
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("total SKS yang diambil: %d / 24 SKS.\n", currMhsw.hitungTotalSKS());
    }
}

