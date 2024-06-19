package javax.CD;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DSCD implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<CD> ds;

    public DSCD() {
        ds = new ArrayList<CD>();
    }

    public boolean themCD(CD cd) {
        if (ds.contains(cd))
            return false;
        ds.add(cd);
        return true;
    }

    public CD getCD(int i) {
        if (i >= 0 && i < ds.size())
            return ds.get(i);
        return null;
    }

    public boolean xoaCD(String maCD) {
        CD cd = new CD(maCD);
        if (ds.contains(cd)) {
            ds.remove(cd);
            return true;
        }
        return false;
    }

    public CD timKiem(String maCD) {
        CD cd = new CD(maCD);
        if (ds.contains(cd))
            return ds.get(ds.indexOf(cd));
        return null;
    }

    public boolean capNhat(String maCD, String tuaCD,
            String caSy, int soBaiHat, double giaThanh) {
        CD cd = new CD(maCD);
        if (ds.contains(cd)) {
            cd = ds.get(ds.indexOf(cd));
            cd.settuaCD(tuaCD);
            cd.setCasy(caSy);
            cd.setsoBAIHAT(soBaiHat);
            cd.setgiathanh(giaThanh);
            return true;
        }
        return false;
    }

    public int tongCD() {
        return ds.size();
    }
}