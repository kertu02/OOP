import java.util.Random;

public class Uisud extends Info {

    public Uisud(String tüüp, String laenutaja, double jalanumber, double aeg) {
        super(tüüp, laenutaja, jalanumber, aeg);
    }

    //meetod selle kohta, kas uisud on terved
    @Override
    boolean kasTerved() {
        String[] konditsioon = {"Terved", "Kulunud"};
        Random random = new Random();
        int valik = random.nextInt(konditsioon.length);//kui indeks 0, siis terved kui ei siis katki
        return valik == 0;//kui terved, siis tagastab true
    }
}
