package javax.CD;

import java.io.Serializable;

public class CD implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String maCD;
    private String tuaCD, Casy;
    private int soBAIHAT;
    private double giathanh;

    public CD(String maCD, String tuaCD, String Casy, int soBAIHAT, double giathanh) {
        this.maCD = maCD;
        this.tuaCD = tuaCD;
        this.Casy = Casy;
        this.soBAIHAT = soBAIHAT;
        this.giathanh = giathanh;
    }

    public CD(String maCD) {
        this(maCD, "", "", 0, 0.0);
    }

    public String gettuaCD() {
        return tuaCD;
    }

    public void settuaCD(String tuaCD) {
        this.tuaCD = tuaCD;
    }

    public String getCasy() {
        return Casy;
    }

    public void setCasy(String Casy) {
        this.Casy = Casy;
    }

    public int getsoBAIHAT() {
        return soBAIHAT;
    }

    public void setsoBAIHAT(int soBAIHAT) {
        this.soBAIHAT = soBAIHAT;
    }

    public double getgiathanh() {
        return giathanh;
    }

    public void setgiathanh(double giathanh) {
        this.giathanh = giathanh;
    }

    public String getmaCD() {
        return maCD;
    }

    @Override
                                public boolean equals(Object obj){
                                    return this.maCD.equalsIgnoreCase(((CD)obj).maCD);
                                }
}