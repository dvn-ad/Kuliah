import java.util.Objects;

class MataKuliah {
    private String kode;
    private String nama;
    private int sks;
    private Dosen dosenPengampu;

    public MataKuliah(String kode, String nama, int sks, Dosen dosenPengampu) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
        this.dosenPengampu = dosenPengampu;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public int getSKS() {
        return sks;
    }

    public Dosen getDosenPengampu() {
        return dosenPengampu;
    }
    
    public String getRincian() {
        return String.format("%-15s | %-30s | %-70s | %s SKS",
                this.kode,
                this.nama,
                this.dosenPengampu.getNama(),
                this.sks);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MataKuliah that = (MataKuliah) o;
        return Objects.equals(kode, that.kode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kode);
    }
}

