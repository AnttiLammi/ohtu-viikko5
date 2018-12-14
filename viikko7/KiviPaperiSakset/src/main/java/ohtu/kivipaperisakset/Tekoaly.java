package ohtu.kivipaperisakset;

public class Tekoaly implements Vastapelaaja {

    int siirto;

    public Tekoaly() {
        siirto = 0;
    }

    public String getSiirto() {
        siirto++;
        siirto = siirto % 3;

        if (siirto == 0) {
            return "k";
        } else if (siirto == 1) {
            return "p";
        } else {
            return "s";
        }
    }

    public void setSiirto(String siirto) {
        // ei tehdä mitään 
    }

    @Override
    public String getPlayertype() {
        return "Tietokone ";
    }
}
