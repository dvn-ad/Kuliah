public class Motor extends Kendaraan {
    private int jumlahRoda;
    private String plat;

    public Motor(String merk, String model, int tahunProduksi, int jumlahRoda, String plat) {
        super(merk, model, tahunProduksi);
        this.jumlahRoda = jumlahRoda;
        this.plat = plat;
    }

    
    
    public String getInfo() {
        return String.format("Motor: %s %s | Tahun: %d | Roda: %d | Plat: %s", 
            getMerk(), getModel(), getTahunProduksi(), jumlahRoda, plat);
    }
    
    public int getTahunProduksi() {
        
        return super.getTahunProduksi();
    }
}