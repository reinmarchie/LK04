class Rekening {
    protected String nomorRekening;
    protected double saldo;

    public Rekening(String nomorRekening, double saldo) {
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public double getSaldo() {
        return saldo;
    }

    public void tampilkanInfo() {
        System.out.println("Nomor Rekening : " + nomorRekening);
        System.out.println("Saldo          : " + saldo);
    }
}