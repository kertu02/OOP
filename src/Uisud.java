import java.util.Random;

public class Uisud extends Info {

    public Uisud(String tüüp, String laenutaja, double aeg) {
        super(tüüp, laenutaja, aeg);
    }

    //meetod selle kohta, kas uisud on terved
    @Override
    boolean kasTerved() {
        String[] konditsioon = {"Terved", "Kulunud"};
        Random random = new Random();
        int valik = random.nextInt(konditsioon.length);//kui indeks 0, siis terved kui ei siis kulunud
        return valik == 0;//kui terved, siis tagastab true
    }

    @Override
    public String toString() {
        if (isInfo()) {
            if (kasTerved())
                return super.toString() + "Teil läks hästi - saite parimas konditsioonis uisud.";
            else {
                return super.toString() + "Kahjuks peate leppima kulunud uiskudega.";
            }
        }
        return super.toString() + ", te peate ootama kuni järgmised uisud vabanevad.";
    }
}
