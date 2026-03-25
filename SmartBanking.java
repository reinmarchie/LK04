public class SmartBanking {
    public static void main(String[] args) {
        System.out.println("     SMART BANKING ECOSYSTEM - GakMauRugi    ");

        // Membuat protokol keamanan (final class)
        ProtokolKeamanan keamanan = new ProtokolKeamanan("SRV-GMR-2026");

        // Membuat rekening valuta asing
        RekeningValas rekening = new RekeningValas("REK-001-USD", 5000.0, "USD");

        System.out.println(">>> INFO REKENING AWAL:");
        rekening.tampilkanInfo();

        System.out.println("\n>>> PROSES TRANSFER GLOBAL:");
        // Langkah 1: Validasi keamanan
        boolean tervalidasi = keamanan.validasiTransaksi(rekening.getNomorRekening(), "482910");

        if (tervalidasi) {
            // Langkah 2: Verifikasi OTP
            rekening.verifikasiOTP("482910");

            // Langkah 3: Konversi mata uang
            rekening.konversiMataUang("USD", "IDR");

            // Langkah 4: Transfer antar negara
            rekening.transferAntarNegara("Singapura", 1500.0);
        }

        System.out.println("\n>>> INFO REKENING SETELAH TRANSAKSI:");
        rekening.tampilkanInfo();

        System.out.println("\n>>> REFERENSI TRANSFER: " + rekening.getReferensiTransfer());
        System.out.println(">>> INFO KEAMANAN    : " + keamanan.getInfoKeamanan());

        System.out.println("\n==============================================");
        System.out.println("          DEMO SELESAI");
        System.out.println("==============================================");
    }
}