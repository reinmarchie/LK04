public interface TransaksiDigital extends Transaksi {
    void verifikasiOTP(String kodeOTP);
    String getPlatformDigital();
}
