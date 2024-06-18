package QL_SinhVien;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DSSinhVien implements Serializable {
    private List<SinhVien> ds;

    public DSSinhVien() {
        ds = new ArrayList<SinhVien>();
    }

    public boolean themsv(SinhVien sv) {
        if (ds.contains(sv)) {
            return false;
        }
        ds.add(sv);
        return true;
    }

    public SinhVien getSinhVien(int i) {
        if (i >= 0 && i < ds.size())
            return ds.get(i);
        return null;
    }

    public int tongSinhVien() {
        return ds.size();
    }

    public SinhVien timkiem(String Masv) throws Exception {
        SinhVien sv = new SinhVien(Masv);
        if (ds.contains(sv))
            return ds.get(ds.indexOf(sv));
        return null;
    }

    public boolean xoaSinhVien(String masv) throws Exception {
        SinhVien sv = new SinhVien(masv);
        if (ds.contains(sv)) {
            ds.remove(sv);
            return true;
        }
        return false;
    }

    public boolean suaTTSinhVien(String masv, SinhVien svVersion2) throws Exception {
        SinhVien sv = new SinhVien(masv);
        if (ds.contains(sv)) {
            sv = ds.get(ds.indexOf(sv));
            sv.setHoten(svVersion2.getHoten());
            sv.setDiemLT(svVersion2.getDiemLT());
            sv.setDiemTH(svVersion2.getDiemTH());
            return true;
        }
        return false;
    }
}
