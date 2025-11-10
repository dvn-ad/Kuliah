public abstract class Kendaraan {
    private String merk;
    private String model;
    private int tahunProduksi;

    public Kendaraan(String merk, String model, int tahunProduksi) {
        this.merk = merk;
        this.model = model;
        this.tahunProduksi = tahunProduksi;
    }

    
    public String getMerk() {
        return merk;
    }

    public String getModel() {
        return model;
    }
    
    
    public int getTahunProduksi() {
        return tahunProduksi;
    }
    
    
    public abstract String getInfo();
    
    
    public String displayList() {
        return String.format("%s %s (%d)", merk, model, tahunProduksi);
    }
}