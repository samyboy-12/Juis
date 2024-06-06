package Soal1;
import java.util.ArrayList;
import java.util.List;
public class Dokter extends orang {
    private String nama;
    private String tanggalLahir;
    private JENIS_KELAMIN gender;
    private String nomorSTR;
    private String spesialisasi;
    private String idDokter;
    private List<Antrian> antrianPasien;

    public Dokter(String nama, String tanggalLahir, JENIS_KELAMIN gender, String nomorSTR, String spesialisasi) {
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.gender = gender;
        this.nomorSTR = nomorSTR;
        this.spesialisasi = spesialisasi;
        this.antrianPasien = new ArrayList<>();
    }
    public void daftar(RumahSakit rumahSakit) {
        rumahSakit.tambahDokter(this);
    }
    public void tambahAntrian(Antrian antrian) {
        this.antrianPasien.add(antrian);
    }
    public List<Antrian> getAntrianPasien() {
        return antrianPasien;
    }
    @Override
    public String toString() {
        return "Dokter{" +
                "nama='" + nama + '\'' +
                ", spesialisasi='" + spesialisasi + '\'' +
                '}';
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public JENIS_KELAMIN getGender() {
        return gender;
    }

    public void setGender(JENIS_KELAMIN gender) {
        this.gender = gender;
    }

    public String getNomorSTR() {
        return nomorSTR;
    }

    public void setNomorSTR(String nomorSTR) {
        this.nomorSTR = nomorSTR;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }

    public String getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(String idDokter) {
        this.idDokter = idDokter;
    }

    public void setAntrianPasien(List<Antrian> antrianPasien) {
        this.antrianPasien = antrianPasien;
    }


}
