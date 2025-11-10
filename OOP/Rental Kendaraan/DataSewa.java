public class DataSewa {
    private Penyewa penyewa;
    private Kendaraan kendaraan;

    public DataSewa(Penyewa penyewa, Kendaraan kendaraan) {
        this.penyewa = penyewa;
        this.kendaraan = kendaraan;
    }

    public Penyewa getPenyewa() {
        return penyewa;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    
    public String getDetailSewa() {
        String detailPenyewa = penyewa.getDetailPenyewa();
        String detailKendaraan = kendaraan.getInfo(); 
        
        return String.format("--- Data Sewa ---\n%s\nKendaraan Disewa: %s", 
            detailPenyewa, detailKendaraan);
    }
}