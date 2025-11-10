public class Mobil extends Kendaraan {
    private int jumlahRoda;
    private String plat;

    public Mobil(String merk, String model, int tahunProduksi, int jumlahRoda, String plat) {
        super(merk, model, tahunProduksi);
        this.jumlahRoda = jumlahRoda;
        this.plat = plat;
    }

    
    @Override
    public String getInfo() {
        return String.format("Mobil: %s %s | Tahun: %d | Roda: %d | Plat: %s", 
            getMerk(), getModel(), getTahunProduksi(), jumlahRoda, plat);
    }
    
    
    public int getJumlahRoda() {
        return jumlahRoda;
    }
    
    
    
    public int getTahunProduksi() {
        
        return super.getTahunProduksi();
    }
}