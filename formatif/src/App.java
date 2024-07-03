import java.util.*;

public class App {

    public static void main(String[] args) {
        List<Dosen> dosens = new ArrayList<>();
        dosens.add(new Dosen("Pak. Salaudin", 0.8, 0.7, 0.9));
        dosens.add(new Dosen("Bu. Rita", 0.6, 0.8, 0.8));
        dosens.add(new Dosen("Pak. Adrianus", 0.7, 0.6, 0.7));

        double[] bobot = {0.4, 0.3, 0.3};

        // Proses perhitungan Weighted Product
        for (Dosen dosen : dosens) {
            double wp = dosen.pengalamanMengajar * bobot[0]
                      + dosen.publikasiIlmiah * bobot[1]
                      + dosen.evaluasiMahasiswa * bobot[2];
            dosen.setNilaiWP(wp);
        }

        // Mengurutkan dosen berdasarkan nilai WP tertinggi
        dosens.sort(Comparator.comparingDouble(Dosen::getNilaiWP).reversed());

        // Menampilkan hasil
        System.out.println("Urutan dosen terbaik berdasarkan Metode Weighted Product:");
        int rank = 1;
        for (Dosen dosen : dosens) {
            System.out.println(rank + ". " + dosen.getNama() + " - Nilai WP: " + dosen.getNilaiWP());
            rank++;
        }
    }

    static class Dosen {
        private String nama;
        private double pengalamanMengajar;
        private double publikasiIlmiah;
        private double evaluasiMahasiswa;
        private double nilaiWP;

        public Dosen(String nama, double pengalamanMengajar, double publikasiIlmiah, double evaluasiMahasiswa) {
            this.nama = nama;
            this.pengalamanMengajar = pengalamanMengajar;
            this.publikasiIlmiah = publikasiIlmiah;
            this.evaluasiMahasiswa = evaluasiMahasiswa;
        }

        public String getNama() {
            return nama;
        }

        public double getNilaiWP() {
            return nilaiWP;
        }

        public void setNilaiWP(double nilaiWP) {
            this.nilaiWP = nilaiWP;
        }
    }
}
