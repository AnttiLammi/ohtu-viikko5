package laskin;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus implements Komento {
    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    private Integer prev;
    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo,Sovelluslogiikka sovellus){
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
        
        
    }

    @Override
    public void suorita() {
        try {
            this.prev = Integer.parseInt(this.tuloskentta.getText());
            this.undo.disableProperty().set(false);
            Integer syote = Integer.parseInt(this.syotekentta.getText());
            
            sovellus.miinus(syote);
            tuloskentta.setText("" + sovellus.tulos());
            syotekentta.setText("");
           
            if (sovellus.tulos()!=0) {
                nollaa.disableProperty().set(false);
            } else {
                nollaa.disableProperty().set(true);
            }
        } catch (Exception e){

        }
    }
    @Override
    public void peru() {
        this.syotekentta.setText("");
        this.tuloskentta.setText("" + this.prev);
        this.sovellus.setTulos(this.prev);
        this.undo.disableProperty().set(true);
    }
}