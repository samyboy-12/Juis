package Soal1;

public class Pasien extends orang {
    private String nama;
    private String tanggalLahir;
    private JENIS_KELAMIN gender;
    private String pekerjaan;
    private String domisili;

    public Pasien(String nama, String tanggalLahir, JENIS_KELAMIN gender, String pekerjaan, String domisili) {
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.gender = gender;
        this.pekerjaan = pekerjaan;
        this.domisili = domisili;
    }

    public void daftar(RumahSakit rumahSakit, String keluhan, String namaDokter, Antrian.tipePasiens tipePasien) {
        Dokter dokter = rumahSakit.cariDokter(namaDokter);
        if (dokter != null) {
            Antrian antrian = new Antrian(rumahSakit.generateIdAntrian(dokter), this, keluhan, dokter, tipePasien);
            rumahSakit.tambahAntrian(antrian);
        } else {
            System.out.println("Dokter tidak ditemukan");
        }
    }

    public void periksa(RumahSakit rumahSakit) {
        Antrian antrian = rumahSakit.cariAntrian(this);
        if (antrian != null) {
            rumahSakit.selesaikanAntrian(antrian);
            System.out.println(nama + " telah diperiksa oleh " + antrian.getDokter().getNama());
        } else {
            System.out.println(nama + " belum mendaftar untuk pemeriksaan");
        }
    }

    @Override
    public String toString() {
        return "Pasien{" +
                "nama='" + nama + '\'' +
                ", pekerjaan='" + pekerjaan + '\'' +
                '}';
    }
}
