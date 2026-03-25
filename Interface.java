// Interface dasar
interface Transaksi {
    void prosesTransaksi(double jumlah);
    String getStatusTransaksi();
}

// Interface TransaksiDigital mewarisi Transaksi
interface TransaksiDigital extends Transaksi {
    void verifikasiOTP(String kodeOTP);
    String getPlatformDigital();
}

// Interface LayananInternasional mewarisi Transaksi
interface LayananInternasional extends Transaksi {
    void konversiMataUang(String dariMataUang, String keMataUang);
    double getKursKonversi();
}

// Interface TransferGlobal mewarisi TransaksiDigital DAN LayananInternasional
interface TransferGlobal extends TransaksiDigital, LayananInternasional {
    void transferAntarNegara(String negaraTujuan, double jumlah);
    String getReferensiTransfer();
}