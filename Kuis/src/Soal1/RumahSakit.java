package Soal1;

import java.util.ArrayList;
import java.util.List;

public class RumahSakit {
    private String nama;
    private String noTelepon;
    private String alamat;
    private List<Antrian> daftarAntrian;
    private List<Dokter> daftarDokter;


    public RumahSakit(String nama, String alamat, String noTelepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.daftarDokter = new ArrayList<>();
        this.daftarAntrian = new ArrayList<>();
    }

    public void tambahDokter(Dokter dokter) {
        if (!daftarDokter.contains(dokter)) {
            daftarDokter.add(dokter);
            System.out.println("Dokter " + dokter.getNama() + " telah ditambahkan ke rumah sakit");
        } else {
            System.out.println("Dokter " + dokter.getNama() + " sudah terdaftar di rumah sakit");
        }
    }

    public void tambahAntrian(Antrian antrian) {
        daftarAntrian.add(antrian);
        antrian.getDokter().tambahAntrian(antrian);
    }

    public Dokter cariDokter(String nama) {
        for (Dokter dokter : daftarDokter) {
            if (dokter.getNama().equals(nama)) {
                return dokter;
            }
        }
        return null;
    }

    public Antrian cariAntrian(Pasien pasien) {
        for (Antrian antrian : daftarAntrian) {
            if (antrian.getPasien().equals(pasien)) {
                return antrian;
            }
        }
        return null;
    }

    public void selesaikanAntrian(Antrian antrian) {
        daftarAntrian.remove(antrian);
        antrian.getDokter().getAntrianPasien().remove(antrian);
    }

    public void cekListDokter() {
        System.out.println("Daftar dokter yang tersedia:");
        for (Dokter dokter : daftarDokter) {
            System.out.println(dokter);
        }
    }

    public void cekAntrianPasien() {
        System.out.println("Antrian saat ini:");
        for (Antrian antrian : daftarAntrian) {
            System.out.println(antrian);
        }
    }

    public String generateIdAntrian(Dokter dokter) {
        return dokter.getIdDokter() + "_" + (dokter.getAntrianPasien().size() + 1);
    }

    @Override
    public String toString() {
        return "RumahSakit{" +
                "nama='" + nama + '\'' +
                ", alamat='" + alamat + '\'' +
                ", noTelepon='" + noTelepon + '\'' +
                '}';
    }
}
