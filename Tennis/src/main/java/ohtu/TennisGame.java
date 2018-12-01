package ohtu;

public class TennisGame {
    public static final int PLAYERS = 2;
    public static final int MAX_POINTS = 4;
    private int pointsP1 = 0;
    private int pointsP2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            pointsP1 += 1;
        else
            pointsP2 += 1;
    }

    public String getScore() {
        String score = "";
      
        if (pointsP1==pointsP2)
        {
            score = evenScore();
        }
        else if (pointsP1>=MAX_POINTS || pointsP2>=MAX_POINTS)
        {
            score = maxPointsScore();
        }
        else
        {
            score = otherScore();
        }
        return score;
    }
    public String evenScore(){   
        switch (this.pointsP1)
            {
                case 0:
                    return "Love-All";
                   
                case 1:
                    return "Fifteen-All";
                    
                case 2:
                    return "Thirty-All";
                case 3:
                    return "Forty-All";
                   
                default:
                    return "Deuce";
   
            }
    }
    public String maxPointsScore(){
        String score ="";
        int advantage = pointsP1-pointsP2;
            if (advantage==1) score ="Advantage player1";
            else if (advantage ==-1) score ="Advantage player2";
            else if (advantage>=2) score = "Win for player1";
            else score ="Win for player2";
        return score;
    }

    public String otherScore(){
        int currentPlayerPoints=0;
        String score = "";
        for (int i=1; i<=PLAYERS; i++)
            {
            if (i==1){
                currentPlayerPoints = pointsP1;
            }
            else 
            { 
                score+="-"; 
                currentPlayerPoints = pointsP2;
            }
            switch(currentPlayerPoints)
            {
                case 0:
                    score+="Love";
                    break;
                case 1:
                    score+="Fifteen";
                    break;
                case 2:
                    score+="Thirty";
                    break;
                case 3:
                    score+="Forty";
                    break;
                }
            }
        return score;
    }
}
    