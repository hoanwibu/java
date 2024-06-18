package QL_SinhVien;

import java.io.Serializable;

import javax.print.DocFlavor.STRING;

public class SinhVien implements Serializable {
    private final String Masv;
    private String hoten, malop;
    private double diemLT, diemTH;

    public SinhVien(String Masv, String hoten, String malop, double diemLT, double diemTH) throws Exception {
        this.Masv = Masv;
        this.hoten = hoten;
        this.malop = malop;
        setDiemLT(diemLT);
        setDiemTH(diemTH);
    }

    public SinhVien(String Masv) throws Exception {
        // this.masv = masv;
        // this.hoten = "Firstname";
        // this.malop = "Lastname";
        // this.diemLT = 0.0;
        // this.diemTH = 0.0;
        this(Masv, "First name", "Last name", 0.0, 0.0);
    }

    public SinhVien(String Masv, String ten) throws Exception {
        // this.masv = masv;
        // this.hoten = "firstname";
        // this.malop = "lastname";
        // this.diemLT = 0.0;
        // this.diemTH = 0.0;
        this(Masv, ten, "lastname", 0.0, 0.0);
    }

    @Override
    public boolean equals(Object obj) {
        return this.Masv.equalsIgnoreCase(((SinhVien) obj).Masv);
    }

    public String getMasv() {
        return Masv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public double getDiemLT() {
        return diemLT;
    }

    public void setDiemLT(double diemLT) throws Exception {
        if (diemLT >= 0 && diemLT <= 10)
            this.diemLT = diemLT;
        else
            throw new Exception("Điểm lý thuyết nhập từ 0 --> 10");
    }

    public double getDiemTH() {
        return diemTH;
    }

    public void setDiemTH(double diemTH) throws Exception {
        if (diemTH >= 0 && diemTH <= 10)
            this.diemTH = diemTH;
        else
            throw new Exception("Điểm thực hành nhập từ 0 --> 10");
    }

    public double diemTB() {
        return (diemLT + diemTH) / 2;
    }

    public String KQ() {
        return (diemTB() >= 5) ? "Đạt" : "Rớt";
    }
}
