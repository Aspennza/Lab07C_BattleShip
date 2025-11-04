/**
 * Creates a BattleshipGame object so that the BattleshipGame.java program can be tested and run
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class BattleshipRunner
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //This BattleshipGame creates an instance of the BattleshipGame class
        BattleshipGame game = new BattleshipGame();
        game.startGame();
    }
}