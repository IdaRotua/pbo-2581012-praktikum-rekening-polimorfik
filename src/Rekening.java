public abstract class Rekening {
    private String nomor;
    private String pemilik;
    protected int saldo;   //nduknya. Tabungan dan Giro mewarisinya

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public String getNomor() { return nomor; }
    public String getPemilik() { return pemilik; }
    public int getSaldo() { return saldo; }

    // wajib ditentukan sendiri oleh setiap jenis rekening
    public abstract int biayaAdminBulanan();

    public int potongBiayaAdmin() {
        int biaya = biayaAdminBulanan();
        saldo -= biaya;
        return biaya;
    }

    public boolean setor(int jumlah) {
        if (jumlah <= 0) {
            return false;
        }
        saldo += jumlah;
        return true;
    }

    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > saldo) {
            return false;
        }
        saldo -= jumlah;
        return true;
    }

    public void cetakInfo() {
      System.out.println(String.format("%s | %-6s | %12s", nomor, pemilik, formatRupiah(saldo)));
    }

    protected static String formatRupiah(int angka) {
        String digit = Integer.toString(Math.abs(angka));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digit.length(); i++) {
            if (i > 0 && (digit.length() - i) % 3 == 0) {
                sb.append('.');
            }
            sb.append(digit.charAt(i));
        }
        return "Rp" + (angka < 0 ? "-" : "") + sb;
    }
}
