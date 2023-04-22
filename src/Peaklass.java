import java.util.Scanner;

public class Peaklass {
    public static void main(String[] args) {
        boolean korras = false; //küsime nii kaua kuni kõik sisestused on õiged
        Scanner sc = new Scanner(System.in);

        System.out.println("-".repeat(75));
        System.out.print("Tere tulemast!");
        System.out.println();
        while (!korras) {
            System.out.println("Soovie laenutada uiske või suuskasid?");
            System.out.print("(Sisesta: 'uiske' või 'suuskasid'): ");
            String tüüp = sc.nextLine();
            if (tüüp.equals("uiske") || tüüp.equals("suuskasid")) {
                System.out.print("Sisesta enda eesnimi: ");
                String nimi = sc.nextLine();
                if (tüüp.equals("suuskasid")) {
                    System.out.print("Sisesta enda pikkus (cm): ");
                    int pikkus = Integer.parseInt(sc.nextLine());
                    System.out.print("Kas soovite suusatada 0.5h või 1h? (Sisesta: '0.5' või '1'): ");
                    double aeg = Double.parseDouble(sc.nextLine());
                    try {
                        if (aeg == 0.5 || aeg == 1.0) {
                            Suusad suusad = new Suusad(tüüp, nimi, pikkus, aeg);
                            System.out.println(suusad);
                            korras = true;
                        } //erinditöötlus
                        else throw new EbasobivaSisestuseErind("Aeg valesti sisestaud!");
                    } catch (EbasobivaSisestuseErind e) {
                        throw e;
                    }
                } else {
                    System.out.print("Kas soovite suusatada 0.5h või 1h? (Sisesta: '0.5' või '1'): ");
                    double aeg = Double.parseDouble(sc.nextLine());
                    try {
                        if (aeg == 0.5 || aeg == 1.0) {
                            Uisud uisud = new Uisud(tüüp, nimi, aeg);
                            System.out.println(uisud);
                            korras = true;
                        } //erinditöötlus
                        else throw new EbasobivaSisestuseErind("Aeg valesti sisestaud!");
                    } catch (EbasobivaSisestuseErind e) {
                        throw e;
                    }
                }
                System.out.println("-".repeat(90));
            } else throw new EbasobivaSisestuseErind("Andmed, mis sisestasite ei vasta nõutud tingimustele.");
        }

    }
}