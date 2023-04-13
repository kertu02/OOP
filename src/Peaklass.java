import java.util.Scanner;

public class Peaklass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("-".repeat(75));
        System.out.print("Tere tulemast!");
        System.out.println();
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
                    Suusad suusad = new Suusad(tüüp, nimi, pikkus, aeg);
                    System.out.println(suusad);
                } catch (Exception e) {
                    System.out.println("Andmed, mis sisestasite ei vasta nõutud tingimustele.");
                }
            } else {
                System.out.print("Kas soovite suusatada 0.5h või 1h? (Sisesta: '0.5' või '1'): ");
                String aeg = sc.nextLine();
                try {
                    Uisud uisud = new Uisud(tüüp, nimi, Double.parseDouble(aeg));
                    System.out.println(uisud);
                } catch (Exception e) {
                    System.out.println("Andmed, mis sisestasite ei vasta nõutud tingimustele.");
                }

            }
            System.out.println("-".repeat(90));
        }
        else System.out.println("Andmed, mis sisestasite ei vasta nõutud tingimustele.");
    }
}