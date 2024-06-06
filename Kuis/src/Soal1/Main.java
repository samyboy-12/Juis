package Soal1;

public class Main {
    public static void main(String[] args) {
        RumahSakit rumahSakit1 = new RumahSakit("RUMAH SAKIT SEHAT", "JALAN MENUJU KEMENANGAN", "77218671");
        Dokter dokter1 = new Dokter("WAHAB", "15 JANUARI 2000", orang.JENIS_KELAMIN.LAKI_LAKI, "34.2.1.100.3.21.007812", "PENYAKIT DALAM");
        Dokter dokter2 = new Dokter("BELDA", "16 FEBRUARI 2003", orang.JENIS_KELAMIN.PEREMPUAN, "34.2.1.100.3.21.001234", "ANAK");
        Dokter dokter3 = new Dokter("FAUZI", "17 MARET 2002", orang.JENIS_KELAMIN.LAKI_LAKI, "34.2.1.100.3.21.005342", "PENYAKIT KULIT");
        Dokter dokter4 = new Dokter("EZRA", "18 APRIL 2000", orang.JENIS_KELAMIN.LAKI_LAKI, "34.2.1.100.3.21.006772", "PENYAKIT JANTUNG");

        System.out.println("# TAMBAH DOKTER KE RUMAH SAKIT");
        rumahSakit1.cekListDokter();
        dokter1.daftar(rumahSakit1);
        dokter2.daftar(rumahSakit1);
        dokter3.daftar(rumahSakit1);
        dokter4.daftar(rumahSakit1);
        dokter1.daftar(rumahSakit1);
        System.out.println("\n");
        rumahSakit1.cekListDokter();

        Pasien pasien1 = new Pasien("YUSUF",  "19 DESEMBER 2005", orang.JENIS_KELAMIN.LAKI_LAKI, "Mahasiwa", "POGUNG");
        Pasien pasien2 = new Pasien("KRIS",  "20 NOVEMBER 2006", orang.JENIS_KELAMIN.LAKI_LAKI, "Mahasiwa", "POGUNG");
        Pasien pasien3 = new Pasien("ARSYAD",  "21 OKTOBER 2004", orang.JENIS_KELAMIN.LAKI_LAKI, "Mahasiwa", "POGUNG");
        Pasien pasien4 = new Pasien("EDELINE",  "22 SEPTEMBER 2005", orang.JENIS_KELAMIN.LAKI_LAKI, "Mahasiwa", "POGUNG");
        Pasien pasien5 = new Pasien("ANNISA",  "23 AGUSTUS 2005", orang.JENIS_KELAMIN.LAKI_LAKI, "Mahasiwa", "POGUNG");
        Pasien pasien6 = new Pasien("JAKI",  "24 JULI 2005", orang.JENIS_KELAMIN.LAKI_LAKI, "Mahasiwa", "POGUNG");

        System.out.println("\n");
        System.out.println("======== PEMBATAS ==========");
        System.out.println("\n");

        System.out.println("# CEK ANTRIAN RUMAH SAKIT");
        rumahSakit1.cekAntrianPasien();
        System.out.println("\n");
        System.out.println("======== PEMBATAS ==========");
        System.out.println("\n");

        System.out.println("# PASIEN DAFTAR KE RUMAH SAKIT");
        pasien1.daftar(rumahSakit1, "PUSING", "WAHAB", Antrian.tipePasiens.MANDIRI);
        pasien2.daftar(rumahSakit1, "PILEK", "WAHAB", Antrian.tipePasiens.MANDIRI);
        pasien3.daftar(rumahSakit1, "MASUK ANGIN", "BELDA", Antrian.tipePasiens.MANDIRI);
        pasien6.daftar(rumahSakit1, "KESELEO", "BELDA", Antrian.tipePasiens.MANDIRI);
        pasien4.daftar(rumahSakit1, "FLU", "FAUZI", Antrian.tipePasiens.MANDIRI);
        pasien5.daftar(rumahSakit1, "BATUK", "LUTHFI", Antrian.tipePasiens.MANDIRI);
        pasien5.daftar(rumahSakit1, "BATUK", "EZRA", Antrian.tipePasiens.MANDIRI);
        pasien5.daftar(rumahSakit1, "SAKIT HATI", "EZRA", Antrian.tipePasiens.MANDIRI);

        System.out.println("\n");
        System.out.println("======== PEMBATAS ==========");
        System.out.println("\n");

        rumahSakit1.cekAntrianPasien();
        System.out.println("\n");
        System.out.println("======== PEMBATAS ==========");
        System.out.println("\n");

        System.out.println("# PASIEN PERIKSA");
        pasien2.periksa(rumahSakit1);
        pasien1.periksa(rumahSakit1);
        pasien2.periksa(rumahSakit1);
        System.out.println("\n");
        System.out.println("======== PEMBATAS ==========");
        System.out.println("\n");

        rumahSakit1.cekAntrianPasien();
        System.out.println("\n");
        System.out.println("======== PEMBATAS ==========");
        System.out.println("\n");

        System.out.println("# PASIEN PERIKSA BELUM DAFTAR");
        pasien2.periksa(rumahSakit1);
    }
}
