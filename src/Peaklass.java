import java.util.Scanner;

public class Peaklass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Tere! ");
        System.out.print("Soovite laenutada uiske või suuskasid? (Sisesta: 'uiske' või 'suuskasid'): ");
        String tüüp = sc.nextLine();
        System.out.print("Sisesta eesnimi: ");
        String nimi = sc.nextLine();
        System.out.print("Sisesta oma jalanumber: ");
        double jalanumber = Double.parseDouble(sc.nextLine());;
        if (tüüp.equals("suuskasid")) {
            System.out.print("Sisesta enda pikkus (cm): ");
            int pikkus = Integer.parseInt(sc.nextLine());
            System.out.print("Kas soovite suusatada 0.5h või 1h? (Sisesta: '0.5' või '1'): ");
            double aeg = Double.parseDouble(sc.nextLine());
            Suusad suusad = new Suusad(tüüp, nimi, jalanumber, pikkus, aeg);
            System.out.println(suusad);
        }
        else {
            System.out.print("Kas soovite suusatada 0.5h või 1h? (Sisesta: '0.5' või '1'): ");
            String aeg = sc.nextLine();
            Uisud uisud = new Uisud(tüüp, nimi, jalanumber, Double.parseDouble(aeg));
            System.out.println(uisud);
        }


        //kui teha mingi aja küsimise nt liidesega? võib ka selle ära kustutada ja midagi uut mõelda
        System.out.println();
        System.out.println("Veidi aega pärast laenutamist...");
        System.out.println("Kas soovite teada kui palju aega teil veel on? (Sisesta: 'jah' või 'ei'): ");
        String vastus = sc.nextLine();
        if (vastus.equals("jah")) {
            //siia võiks teha liidesega töötava osa
            System.out.println();
        }
    }
}