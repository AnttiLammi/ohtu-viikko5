package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Ihminen implements Vastapelaaja {
    int siirto;
    private Scanner scanner;

    public Ihminen(Scanner scanner){
        this.scanner = scanner;
    }

    @Override
    public String getSiirto() {
        System.out.print("Toisen pelaajan siirto: ");
        return scanner.nextLine();
    }
    public String getPlayertype(){
        return "Toinen pelaaja ";
    }
    public void setSiirto(String siirto) {
        //do nothing
    }
    
}