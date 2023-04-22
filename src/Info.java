import java.io.*;
import java.util.Arrays;

public abstract class Info {

    //isendiväljad
    private static String nimi;//laenutaja nimi
    private static String tüüp;//kas uisud või suusad
    private double aeg;//kui kaua saab laenutada
    private static boolean info = true;//kas piisavalt vahendeid on laos

    //konstruktor isendiväljadele
    public Info(String tüüp, String laenutaja, double aeg) {
        this.tüüp = tüüp;
        this.nimi = laenutaja;
        this.aeg = aeg;
    }

    public static boolean isInfo() {
        return info;
    }

    //meetod, mis näitab, kas uisud/suusad on uued või vanad
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
        System.out.println("-".repeat(90));
        try {
            vahendidLaenutamiseks();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (info) {
            System.out.println("-".repeat(90));
            return getNimi() + ", maksmisele kuulub " + hind() + " eurot. ";
        } else {
            return getNimi();
        }
    }

    public String getNimi() {
        return nimi;
    }

    //meetod, mis ütleb kui palju uiske/suuski/suusakeppe on hetkel laos
    private static void kogusedHetkel() throws Exception {
        int[] kogusedHetkel = new int[3];
        int min = 0;
        int max = 50;//maksimaalselt 50 uisu-/suusa-/suusakepi paari on olemas

        //valime suvalised kolm numbrit, mis vastavalt eelnimetatud järjekorrale näitavad hetke seisu laos.
        for (int i = 0; i < kogusedHetkel.length; i++) {
            int suvaline = (int) Math.floor(Math.random() * (max - min + 1) + min);
            kogusedHetkel[i] = suvaline;
        }
        //loome faili, kuhu on lao andmed kirjutatud
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("lao_andmed.txt"), "UTF-8"))) {
            bufferedWriter.write(Arrays.toString(kogusedHetkel));
        }
    }

    //getter asjade koguse saamiseks
    public static int[] getKogusedHetkel() throws Exception {
        kogusedHetkel();
        //loeme failist andmed
        int[] kogused = new int[3];
        try (InputStreamReader inputStreamReader = new InputStreamReader
                (new FileInputStream("lao_andmed.txt"), "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String rida = bufferedReader.readLine();
            String[] osad = rida.substring(1, rida.length() - 1).split(", ");
            kogused[0] = Integer.parseInt(osad[0]);//uisud
            kogused[1] = Integer.parseInt(osad[1]);//suusad
            kogused[2] = Integer.parseInt(osad[2]);//kepid
        }
        return kogused;
    }

    //avalik meetod, mis ütleb kas on olemas laenutamiseks kõiki vahendeid
    //ja kui on siis väljastab kui palju neid on
    public void vahendidLaenutamiseks() throws Exception {
        //kontrollime kas migeid vahendeid (uiske, suuski või suusakeppe) pole
        //kogusedHetkel järjendis on 0 kohal uisud, 1 kohal suusad ja 2 kohal kepid
        if (getKogusedHetkel()[1] == 0 || getKogusedHetkel()[2] == 0 && tüüp.equals("suuskasid")) {
            System.out.println("Kahjuks pole suusatamiseks piisavalt vahendeid.");
            info = false;
        } else if (getKogusedHetkel()[0] == 0 && tüüp.equals("uiske")) {
            System.out.println(getNimi() + "Kahjuks pole uisutamiseks piisavalt vahendeid.");
            info = false;
        }
        if (info) System.out.println("Kõik vajalikud vahendid on olemas.");
        System.out.println("Uiske, suuski, suusakeppe on laos vastavalt (paare): " + Arrays.toString(getKogusedHetkel()) + ".");
    }
}
