public class Penyewa {
    private String nama;
    private String noKTP;

    public Penyewa(String nama, String noKTP) {
        this.nama = nama;
        this.noKTP = noKTP;
    }

    public String getNama() {
        return nama;
    }

    public String getNoKTP() {
        return noKTP;
    }

    public String getDetailPenyewa() {
        return String.format("Penyewa: %s (KTP: %s)", nama, noKTP);
    }
}