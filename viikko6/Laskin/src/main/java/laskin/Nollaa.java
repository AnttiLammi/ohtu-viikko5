package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa implements Komento {

    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    private Integer prev;

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }

    @Override
    public void suorita() {
        try {
            this.prev = Integer.parseInt(tuloskentta.getText());
            this.undo.disableProperty().set(false);
            this.nollaa.disableProperty().set(true);
            sovellus.nollaa();
            tuloskentta.setText("" + sovellus.tulos());
            syotekentta.setText("");
        } catch (Exception e) {

        }
    }

    @Override
    public void peru() {
        this.syotekentta.setText("");
        this.tuloskentta.setText("" + this.prev);
        this.sovellus.setTulos(prev);
        this.undo.disableProperty().set(true);
    }
}
