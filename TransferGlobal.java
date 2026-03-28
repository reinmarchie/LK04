public interface TransferGlobal extends TransaksiDigital, LayananInternasional {
    void transferAntarNegara(String negaraTujuan, double jumlah);
    String getReferensiTransfer();
}
