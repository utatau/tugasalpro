package com.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Dosen> dosens = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.print("Masukkan nama dosen ke-" + (i + 1) + ": ");
            String nama = scanner.nextLine();

            System.out.print("Masukkan nilai pengalaman mengajar (0-1) untuk " + nama + ": ");
            double pengalamanMengajar = scanner.nextDouble();

            System.out.print("Masukkan nilai publikasi ilmiah (0-1) untuk " + nama + ": ");
            double publikasiIlmiah = scanner.nextDouble();

            System.out.print("Masukkan nilai evaluasi mahasiswa (0-1) untuk " + nama + ": ");
            double evaluasiMahasiswa = scanner.nextDouble();

            scanner.nextLine();

            dosens.add(new Dosen(nama, pengalamanMengajar, publikasiIlmiah, evaluasiMahasiswa));
        }

        double[] bobot = {0.4, 0.3, 0.3};

        for (Dosen dosen : dosens) {
            double wp = dosen.pengalamanMengajar * bobot[0]
                    + dosen.publikasiIlmiah * bobot[1]
                    + dosen.evaluasiMahasiswa * bobot[2];
            dosen.setNilaiWP(wp);
        }
        dosens.sort(Comparator.comparingDouble(Dosen::getNilaiWP).reversed());
        System.out.println("Urutan dosen terbaik berdasarkan Metode Weighted Product:");
        int rank = 1;
        for (Dosen dosen : dosens) {
            System.out.println(rank + ". " + dosen.getNama() + " - Nilai WP: " + dosen.getNilaiWP());
            rank++;
        }

        scanner.close();
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
