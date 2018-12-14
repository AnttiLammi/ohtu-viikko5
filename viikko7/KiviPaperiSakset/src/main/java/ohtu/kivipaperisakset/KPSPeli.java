package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPeli implements Game {
    private Scanner scanner;
    private Vastapelaaja vastapelaaja;
    private PlayerFactory playerFactory;

    public KPSPeli(){
        this.scanner = new Scanner(System.in);
        playerFactory = PlayerFactory.create();
    }

    public void suorita(){
        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            if (vastaus.isEmpty()){ 
                break;
            }
            vastapelaaja = playerFactory.createVastustaja(vastaus);
            if (vastapelaaja.equals(null)) {
                break;
            }
            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            pelaa();
        }
    }

    @Override
    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        
        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = scanner.nextLine();
        String tokanSiirto;

        tokanSiirto =  vastapelaaja.getSiirto();
        if (vastapelaaja.getPlayertype().contains("Tietokone")){
            System.out.println(vastapelaaja.getPlayertype() + "valitsi " + tokanSiirto);
        }
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();

            tokanSiirto = vastapelaaja.getSiirto();
            if (vastapelaaja.getPlayertype().contains("Tietokone")){
                System.out.println(vastapelaaja.getPlayertype() + "valitsi " + tokanSiirto);
                vastapelaaja.setSiirto(ekanSiirto);
            }
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    
    
}


