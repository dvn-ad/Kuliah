import java.util.ArrayList;
import java.util.List;

class Mahasiswa {
    private String nama;
    private String nrp; 
    private List<MataKuliah> frs; 
    private final int MAX_SKS = 24;

    public Mahasiswa(String nama, String nrp) {
        this.nama = nama;
        this.nrp = nrp;
        this.frs = new ArrayList<>();
    }

    public String getNama() {
        return nama;
    }

    public String getNRP() {
        return nrp;
    }

    public List<MataKuliah> getFRS() {
        return frs;
    }

    public int hitungTotalSKS() {
        int total = 0;
        for (MataKuliah mk : frs) {
            total += mk.getSKS();
        }
        return total;
    }

    public boolean isMaksimumSKS() {
        return hitungTotalSKS() >= MAX_SKS;
    }

    public int getSisaSKS() {
        return MAX_SKS - hitungTotalSKS();
    }
    
    
    public boolean sudahDiambil(String kodeMatkul) {
        for (MataKuliah mk : frs) {
            if (mk.getKode().equalsIgnoreCase(kodeMatkul)) {
                return true;
            }
        }
        return false;
    }

    public void tambahMataKuliah(MataKuliah mataKuliah) {
        frs.add(mataKuliah);
    }

    public boolean dropMataKuliah(String kodeMatkul) {
        for (int i = 0; i < frs.size(); i++) {
            if (frs.get(i).getKode().equalsIgnoreCase(kodeMatkul)) {
                frs.remove(i);
                return true; 
            }
        }
        return false; 
    }
}