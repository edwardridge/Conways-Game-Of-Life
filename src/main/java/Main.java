import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        GameFactory gameFactory = new GameFactory();
        String gameState =
                "| | | | | | | | | | | | | | | |\n" +
                "| | | | | | | | | | | | | | | |\n" +
                "| | | |X| | | | | | | | | | | |\n" +
                "| | | | |X| | | | | | | | | | |\n" +
                "| | |X|X|X| | | | | | | | | | |\n" +
                "| | | | | | | | | | | | | | | |\n" +
                "| | | | | | | | | | | | | | | |\n" +
                "| | | | | | | | | | | | | | | |\n" +
                "| | | | | | | | | | | | | | | |\n" +
                "| | | | | | | | | | | | | | | |\n" +
                "| | | | | | | | | | | | | | | |\n" +
                "| | | | | | | | | | | | | | | |\n" +
                "| | | | | | | | | | | | | | | |\n" +
                "| | | | | | | | | | | | | | | |\n" +
                "| | | | | | | | | | | | | | | |\n" +
                "| | | | | | | | | | | | | | | |\n"
                ;
        GameOfLife gameOfLife = gameFactory.CreateGame(gameState);

        PrintGame(gameOfLife);

        System.out.print("Click enter to go to next step");
        String s = br.readLine();

        while(s.equalsIgnoreCase("e") == false){
            gameOfLife.Step();
            PrintGame(gameOfLife);
            s = br.readLine();

        }
    }

    private static void PrintGame(GameOfLife gameOfLife){
        Cell[][] cells = gameOfLife.GetGrid().AsTwoDimArray();

        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells[i].length; j++){
                String cellIsAlive = cells[i][j].CellState == CellState.ALIVE ? "X" : " ";
                System.out.print("|" + cellIsAlive);
            }
            System.out.print("\n");
        }
    }
}
