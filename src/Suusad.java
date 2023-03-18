import java.time.Year;

public class Suusad extends Info {

    private int pikkus;//kui pikk on inimene
    public Suusad(String tüüp, String laenutaja, double jalanumber, int pikkus, double aeg) {
        super(tüüp, laenutaja, jalanumber, aeg);
        this.pikkus = pikkus;
    }

    //meetod saadud 3 nädala kodutöö alt
    public int suusakepiPikkus() {
        return (int) Math.round(0.85 * pikkus);
    }

    //meetod selle kohta, kas suusad on terved?
    @Override
    boolean kasTerved() {
        int vanad = 2010; //vanimad suusad
        int uued = Year.now().getValue();//uusimad suusad, mis on ostetud käesoleval aastal
        int suvalineAasta = (int)Math.floor(Math.random() * (uued - vanad + 1) + vanad);
        return suvalineAasta >= 2020; //kui suusad on aastast 2020 või uuemad, siis on need terved
    }

    @Override
    public String toString() {
        return super.toString() + " Võtke palun kepid pikkusega " + suusakepiPikkus() + " cm.";
    }
}
