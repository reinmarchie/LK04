class RekeningValas extends Rekening implements TransferGlobal {

    private String mataUangDasar;
    private String statusTransaksi;
    private double kursKonversi;
    private String referensiTransfer;

    public RekeningValas(String nomorRekening, double saldo, String mataUangDasar) {
        super(nomorRekening, saldo); // Memanggil constructor superclass
        this.mataUangDasar = mataUangDasar;
        this.statusTransaksi = "IDLE";
        this.kursKonversi = 1.0;
        this.referensiTransfer = "-";
    }

    //Implementasi dari Transaksi
    @Override
    public void prosesTransaksi(double jumlah) {
        if (jumlah > saldo) {
            statusTransaksi = "GAGAL - Saldo tidak mencukupi";
            System.out.println("[Transaksi] GAGAL: Saldo tidak mencukupi untuk transaksi sebesar " + jumlah);
        } else {
            saldo -= jumlah;
            statusTransaksi = "SUKSES";
            System.out.println("[Transaksi] Berhasil memproses transaksi sebesar " + jumlah);
            System.out.println("[Transaksi] Saldo tersisa: " + saldo);
        }
    }

    @Override
    public String getStatusTransaksi() {
        return statusTransaksi;
    }

    //Implementasi dari TransaksiDigital
    @Override
    public void verifikasiOTP(String kodeOTP) {
        // Simulasi verifikasi OTP
        if (kodeOTP != null && kodeOTP.length() == 6) {
            System.out.println("[OTP] Verifikasi OTP berhasil dengan kode: " + kodeOTP);
        } else {
            System.out.println("[OTP] Verifikasi OTP GAGAL. Kode tidak valid.");
        }
    }

    @Override
    public String getPlatformDigital() {
        return "GakMauRugi Mobile Banking v2.0";
    }

    //Implementasi dari LayananInternasional
    @Override
    public void konversiMataUang(String dariMataUang, String keMataUang) {
        // Simulasi konversi (kurs sederhana)
        if (dariMataUang.equals("IDR") && keMataUang.equals("USD")) {
            kursKonversi = 0.000063;
        } else if (dariMataUang.equals("USD") && keMataUang.equals("IDR")) {
            kursKonversi = 15900.0;
        } else {
            kursKonversi = 1.0;
        }
        System.out.println("[Konversi] " + dariMataUang + " -> " + keMataUang
                + " | Kurs: " + kursKonversi);
    }

    @Override
    public double getKursKonversi() {
        return kursKonversi;
    }

    //Implementasi dari TransferGlobal
    @Override
    public void transferAntarNegara(String negaraTujuan, double jumlah) {
        referensiTransfer = "TRF-" + nomorRekening + "-" + System.currentTimeMillis();
        System.out.println("[Transfer Global] Memulai transfer ke negara: " + negaraTujuan);
        System.out.println("[Transfer Global] Jumlah: " + jumlah + " " + mataUangDasar);
        System.out.println("[Transfer Global] Referensi: " + referensiTransfer);
        prosesTransaksi(jumlah);
    }

    @Override
    public String getReferensiTransfer() {
        return referensiTransfer;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Mata Uang      : " + mataUangDasar);
        System.out.println("Platform       : " + getPlatformDigital());
        System.out.println("Status         : " + statusTransaksi);
    }
}