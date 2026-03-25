public class ProtokolKeamanan {
    // Variabel final - nilainya tidak dapat diubah setelah inisialisasi
    public final String ID_SERVER;
    private final String VERSI_ENKRIPSI = "AES-256";
    private final int BATAS_PERCOBAAN = 3;

    public ProtokolKeamanan(String idServer) {
        this.ID_SERVER = idServer; // Inisialisasi dilakukan di constructor, tidak bisa diubah lagi
    }

    public boolean validasiTransaksi(String nomorRekening, String kodeOTP) {
        System.out.println("\n[Keamanan] Server ID     : " + ID_SERVER);
        System.out.println("[Keamanan] Enkripsi      : " + VERSI_ENKRIPSI);
        System.out.println("[Keamanan] Batas Coba    : " + BATAS_PERCOBAAN + "x");
        System.out.println("[Keamanan] Memvalidasi rekening: " + nomorRekening);

        // Simulasi validasi
        boolean valid = kodeOTP != null && kodeOTP.length() == 6;
        System.out.println("[Keamanan] Status Validasi: " + (valid ? "TERVERIFIKASI" : "DITOLAK"));
        return valid;
    }

    public String getInfoKeamanan() {
        return "Server=" + ID_SERVER + " | Enkripsi=" + VERSI_ENKRIPSI;
    }
}
