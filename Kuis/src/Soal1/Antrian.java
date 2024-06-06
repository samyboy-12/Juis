package Soal1;
public class Antrian {
    public enum tipePasiens {
        BPJS,
        MANDIRI
    }
    private String id;
    private Pasien pasien;
    private String keluhan;
    private Dokter dokter;
    private tipePasiens tipePasien;
    public Antrian(String id, Pasien pasien, String keluhan, Dokter dokter, tipePasiens tipePasien) {
        this.id = id;
        this.pasien = pasien;
        this.keluhan = keluhan;
        this.dokter = dokter;
        this.tipePasien = tipePasien;
    }
    public Dokter getDokter() {
        return dokter;
    }
    public Pasien getPasien() {
        return pasien;
    }
    @Override
    public String toString() {
        return "Antrian{" +
                "id='" + id + '\'' +
                ", pasien=" + pasien +
                ", keluhan='" + keluhan + '\'' +
                ", dokter=" + dokter +
                ", tipePasien='" + tipePasien + '\'' +
                '}';
    }
}

