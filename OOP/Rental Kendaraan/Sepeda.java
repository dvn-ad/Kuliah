public class Sepeda extends Kendaraan {
    private String jenisSepeda;

    public Sepeda(String merk, String model, int tahunProduksi, String jenisSepeda) {
        super(merk, model, tahunProduksi);
        this.jenisSepeda = jenisSepeda;
    }

    
    
    public String getInfo() {
        return String.format("Sepeda: %s %s | Tahun: %d | Jenis: %s", 
            getMerk(), getModel(), getTahunProduksi(), jenisSepeda);
    }
    
    public int getTahunProduksi() {
        
        return super.getTahunProduksi();
    }
}