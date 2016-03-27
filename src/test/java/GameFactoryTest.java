import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class GameFactoryTest {
    @Test
    public void With_String_That_Has_Four_Lines_Grid_Size_Is_Four(){
        GameFactory gameFactory = new GameFactory();
        String gameState =
                " | | | |\n" +
                " | | | |\n" +
                " | | | |\n" +
                " | | | |\n";

        GameOfLife game = gameFactory.CreateGame(gameState);

        assertThat(game.GetGridSize()).isEqualTo(4);
    }

    @Test
    public void With_X_In_First_Cell_First_Cell_Set_To_Alive(){
        GameFactory gameFactory = new GameFactory();
        String gameState =
                "X| | | |\n" +
                " | | | |\n" +
                " | | | |\n" +
                " | | | |\n";

        GameOfLife game = gameFactory.CreateGame(gameState);

        assertThat(game.GetCellState(GridPosition.Create(1, 1))).isEqualTo(CellState.ALIVE);
    }

    @Test
    public void With_X_In_3_2_Cell_Has_3_2_Set_To_Alive(){
        GameFactory gameFactory = new GameFactory();
        String gameState =
                " | | | |\n" +
                " | | | |\n" +
                " |X| | |\n" +
                " | | | |\n";

        GameOfLife game = gameFactory.CreateGame(gameState);

        assertThat(game.GetCellState(GridPosition.Create(3, 2))).isEqualTo(CellState.ALIVE);
    }

    @Test
    public void With_X_In_2_2_And_1_4_Cells_Are_Set_To_Alive(){
        GameFactory gameFactory = new GameFactory();
        String gameState =
                " | | |X|\n" +
                " |X| | |\n" +
                " | | | |\n" +
                " | | | |\n";

        GameOfLife game = gameFactory.CreateGame(gameState);

        assertThat(game.GetCellState(GridPosition.Create(2, 2))).isEqualTo(CellState.ALIVE);
        assertThat(game.GetCellState(GridPosition.Create(1, 4))).isEqualTo(CellState.ALIVE);
    }
}
