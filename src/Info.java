import java.util.Arrays;

public abstract class Info {

    //isendiväljad
    private String laenutaja;//laenutaja nimi
    private String tüüp;//kas uisud või suusad
    private double jalanumber;//laenutaja jalanumber
    private double aeg;//kui kaua saab laenutada
    private int[] kogusedHetkel;//kui palju suuski/uiske/suusakeppe on hetkel laos
    private boolean info = true;//kas piisavalt vahendeid on laos

    //konstruktor isendiväljadele
    public Info(String tüüp, String laenutaja, double jalanumber, double aeg) {
        this.tüüp = tüüp;
        this.laenutaja = laenutaja;
        this.jalanumber = jalanumber;
        this.aeg = aeg;
    }

    //meetod, mis näitab, kas uisud/suusad on terved või katki
    abstract boolean kasTerved();

    //meetod, mis arvutab kui palju tuleb laenutajal maksta
    public int hind() {
        if (tüüp.equals("suuskasid") && aeg == 1)//1h suuski maksab 10 eurot
            return 10;
        else if (tüüp.equals("suuskasid") && aeg == 0.5)//30min suuski maksab 7 eurot
            return 7;
        else if (tüüp.equals("uiske") && aeg == 1)//1h suuski maksab 10 eurot
            return 5;
        else if (tüüp.equals("uiske") && aeg == 0.5)//30min suuski maksab 7 eurot
            return 3;
        else return 0;//seda ei tohiks juhtuda, ent meetod peab midagi tagastama
    }

    @Override
    public String toString() {
        if (info) {
            return "Teil kuulub maksmisele " + hind() + " eurot.";
        }
        else {
            return "Vabandame väga!";
        }
    }

    //meetod, mis ütleb kui palju uiske/suuski/suusakeppe on hetkel laos
    private int[] kogusedHetkel() {
        int[] kogusedHetkel = new int[3];
        int min = 0;
        int max = 50;//maksimaalselt 50 uisu-/suusa-/suusakepi paari on olemas

        //valime suvalised kolm numbrit, mis vastavalt eelnimetatud järjekorrale näitavad hetke seisu laos.
        for (int i = 0; i < kogusedHetkel.length; i++) {
            int suvaline = (int) Math.floor(Math.random() * (max - min + 1) + min);
            kogusedHetkel[i] = suvaline;
        }

        return kogusedHetkel;
    }

    //getter asjade koguse saamiseks
    public int[] getKogusedHetkel() {
        return kogusedHetkel();
    }

    //avalik meetod, mis ütleb kas on olemas laenutamiseks kõiki vahendeid
    //ja kui on siis väljastab kui palju neid on
    public void vahendidLaenutamiseks() {
        //kontrollime kas migeid vahendeid (uiske, suuski või suusakeppe) pole
        //kogusedHetkel järjendis on 0 kohal uisus, 1 kohal suusad ja 2 kohal kepid
        if (tüüp.equals("suuskasid") && getKogusedHetkel()[1] == 0 || getKogusedHetkel()[2] == 0) {
            System.out.println(laenutaja + ", kahjuks pole suusatamiseks piisavalt vahendeid.");
            info = false;
        } else if (tüüp.equals("uiske") && getKogusedHetkel()[0] == 0) {
            System.out.println(laenutaja + ", kahjuks pole uisutamiseks piisavalt vahendeid.");
            info = false;
        }
        if (info) System.out.println(laenutaja + ", vajalikud vahendid on olemas.");
        System.out.println("Uiske, suuski, suusakeppe on laos vastavalt (paare): " + Arrays.toString(getKogusedHetkel()) + ".");
    }
}
