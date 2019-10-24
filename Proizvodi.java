package rs.itcentar.katalog_proizvoda;

import java.util.concurrent.atomic.AtomicInteger;

public class Proizvodi {

    private int idProizvoda;
    private String imeProizvoda;
    private String opisProizvoda;
    private double cenaProizvoda;
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);

    public Proizvodi() {
    }

    public Proizvodi(String imeProizvoda, String opisproizvoda, double cenaProizvoda) {
        this.idProizvoda = ID_GENERATOR.getAndIncrement();
        this.imeProizvoda = imeProizvoda;
        this.opisProizvoda = opisproizvoda;
        this.cenaProizvoda = cenaProizvoda;
    }

    public int getIdProizvoda() {
        return idProizvoda;
    }

    public String getImeProizvoda() {
        return imeProizvoda;
    }

    public String getOpisProizvoda() {
        return opisProizvoda;
    }

    public double getCenaProizvoda() {
        return cenaProizvoda;
    }

    public void setImeProizvoda(String imeProizvoda) {
        this.imeProizvoda = imeProizvoda;
    }

    public void setOpisProizvoda(String opisproizvoda) {
        this.opisProizvoda = opisproizvoda;
    }

    public void setCenaProizvoda(double cenaProizvoda) {
        this.cenaProizvoda = cenaProizvoda;
    }

    @Override
    public String toString() {
        return idProizvoda + " " + imeProizvoda + " " + opisProizvoda + " " + cenaProizvoda;
    }

}
