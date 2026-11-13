public class BankPolimorfik {
    public static void main(String[] args) {
        Tabungan ani = new Tabungan("101", "Ani", 1000000, 2.5);
        Tabungan citra = new Tabungan("102", "Citra", 300000, 2.0); //constructor
        Giro budi = new Giro("201", "Budi", 200000, 500000);  //dalam in tu manggil super ke rekening

        Rekening[] semua = { ani, citra, budi }; // abstrack clss
        BerBunga[] berbunga = { ani, citra };   //Array bertipe interface BerBunga

        System.out.println("========== REKENING AWAL ==========");
        for (Rekening r : semua) {
            r.cetakInfo();    //Method di Rekening di-override di Tabungan dan Giro
        }
        System.out.println();
        System.out.println("========== AKHIR BULAN ============");
        for (Rekening r : semua) {
            System.out.println(r.getNomor() + " biaya admin  : " + Rekening.formatRupiah(r.potongBiayaAdmin()));
        }
        for (BerBunga b : berbunga) {
            System.out.println(b.getNomor() + " bunga        : " + Rekening.formatRupiah(b.tambahBunga()));
        }

        System.out.println();
        System.out.println("===== REKENING AKHIR =========");
        int total = 0;
        for (Rekening r : semua) {
            r.cetakInfo();
            total += r.getSaldo();
        }
        System.out.println("-------------------------");
        System.out.println("Total dana bank : " + Rekening.formatRupiah(total));
    }
}
