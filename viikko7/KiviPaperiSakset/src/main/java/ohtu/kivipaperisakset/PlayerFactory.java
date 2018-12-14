package ohtu.kivipaperisakset;

import java.util.Scanner;

public class PlayerFactory {
    private PlayerFactory(){
        //Hide constructor to force call to PlayerFactory.create()
    }
    public static PlayerFactory create(){
        return new PlayerFactory();
    }
    public Vastapelaaja createVastustaja(String type){
        switch(type){
            case "a":
            return new Ihminen(new Scanner(System.in));

            case "b":
            return new Tekoaly();
  
            case "c": 
            return new TekoalyParannettu(20);
         
            default:
            return null;
        }
        
    }
}