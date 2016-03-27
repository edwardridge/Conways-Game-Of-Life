import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NextStateTest {
    @Test
    public void With_No_Alive_Neighbours_Alive_Cell_Dies(){
        GameFactory gameFactory = new GameFactory();
        String gameState =
                " | | | |\n" +
                " |X| | |\n" +
                " | | | |\n" +
                " | | | |\n";
        GameOfLife game = gameFactory.CreateGame(gameState);

        game.Step();

        GridPosition gridPosition = GridPosition.Create(2, 2);
        assertThat(game.GetCellState(gridPosition)).isEqualTo(CellState.DEAD);
    }

    @Test
    public void With_One_Alive_Neighbour_Alive_Cell_Dies(){
        GameFactory gameFactory = new GameFactory();
        String gameState =
                " | | | |\n" +
                " | | | |\n" +
                " | |X|X|\n" +
                " | | | |\n";
        GameOfLife game = gameFactory.CreateGame(gameState);

        game.Step();

        GridPosition gridPosition = GridPosition.Create(3, 3);
        assertThat(game.GetCellState(gridPosition)).isEqualTo(CellState.DEAD);
    }

    @Test
    public void With_Two_Alive_Neighbours_Along_Same_X_Axis_Alive_Cell_Stays_Alive(){
        GameFactory gameFactory = new GameFactory();
        String gameState =
                " | | | |\n" +
                "X|X|X| |\n" +
                " | | | |\n" +
                " | | | |\n";
        GameOfLife game = gameFactory.CreateGame(gameState);

        game.Step();

        GridPosition gridPosition = GridPosition.Create(2, 2);
        assertThat(game.GetCellState(gridPosition)).isEqualTo(CellState.ALIVE);
    }

    @Test
    public void With_Two_Alive_Neighbours_Along_Same_Y_Axis_Alive_Cell_Stays_Alive(){
        GameFactory gameFactory = new GameFactory();
        String gameState =
                " |X| | |\n" +
                " |X| | |\n" +
                " |X| | |\n" +
                " | | | |\n";
        GameOfLife game = gameFactory.CreateGame(gameState);

        game.Step();

        GridPosition gridPosition = GridPosition.Create(2, 2);
        assertThat(game.GetCellState(gridPosition)).isEqualTo(CellState.ALIVE);
    }

    @Test
    public void With_Two_Alive_Neighbours_Along_Different_X_And_Y_Axis_Alive_Cell_Stays_Alive(){
        GameFactory gameFactory = new GameFactory();
        String gameState =
                " |X| | |\n" +
                "X|X| | |\n" +
                " | | | |\n" +
                " | | | |\n";
        GameOfLife game = gameFactory.CreateGame(gameState);

        game.Step();

        GridPosition gridPosition = GridPosition.Create(2, 2);
        assertThat(game.GetCellState(gridPosition)).isEqualTo(CellState.ALIVE);
    }

    @Test
    public void With_Two_Alive_Neighbours_That_Are_Diagnol_Alive_Cell_Stays_Alive(){
        GameFactory gameFactory = new GameFactory();
        String gameState =
                " | |X| |\n" +
                " |X| | |\n" +
                "X| | | |\n" +
                " | | | |\n";
        GameOfLife game = gameFactory.CreateGame(gameState);

        game.Step();

        GridPosition gridPosition = GridPosition.Create(2, 2);
        assertThat(game.GetCellState(gridPosition)).isEqualTo(CellState.ALIVE);
    }

    @Test
    public void With_Three_Alive_Neighbours_Alive_Cell_Stays_Alive(){
        GameFactory gameFactory = new GameFactory();
        String gameState =
                " | |X| |\n" +
                "X|X| | |\n" +
                "X| | | |\n" +
                " | | | |\n";
        GameOfLife game = gameFactory.CreateGame(gameState);

        game.Step();

        GridPosition gridPosition = GridPosition.Create(2, 2);
        assertThat(game.GetCellState(gridPosition)).isEqualTo(CellState.ALIVE);
    }

    @Test
    public void With_Three_Alive_Neighbours_Alive_Cell_Stays_Alive_Check_2(){
        GameFactory gameFactory = new GameFactory();
        String gameState =
                " | | | |\n" +
                "X|X|X| |\n" +
                "X| | | |\n" +
                " | | | |\n";
        GameOfLife game = gameFactory.CreateGame(gameState);

        game.Step();

        GridPosition gridPosition = GridPosition.Create(2, 2);
        assertThat(game.GetCellState(gridPosition)).isEqualTo(CellState.ALIVE);
    }

    @Test
    public void With_Four_Alive_Neighbours_Alive_Cell_Dies(){
        GameFactory gameFactory = new GameFactory();
        String gameState =
                " |X| | |\n" +
                "X|X|X| |\n" +
                "X| | | |\n" +
                " | | | |\n";
        GameOfLife game = gameFactory.CreateGame(gameState);

        game.Step();

        GridPosition gridPosition = GridPosition.Create(2, 2);
        assertThat(game.GetCellState(gridPosition)).isEqualTo(CellState.DEAD);
    }

    @Test
    public void With_Five_Alive_Neighbours_Alive_Cell_Dies(){
        GameFactory gameFactory = new GameFactory();
        String gameState =
                "X|X| | |\n" +
                "X|X|X| |\n" +
                "X| | | |\n" +
                " | | | |\n";
        GameOfLife game = gameFactory.CreateGame(gameState);

        game.Step();

        GridPosition gridPosition = GridPosition.Create(2, 2);
        assertThat(game.GetCellState(gridPosition)).isEqualTo(CellState.DEAD);
    }

    @Test
    public void With_Six_Alive_Neighbours_Alive_Cell_Dies() {
        GameFactory gameFactory = new GameFactory();
        String gameState =
                "X|X| | |\n" +
                        "X|X|X| |\n" +
                        "X|X| | |\n" +
                        " | | | |\n";
        GameOfLife game = gameFactory.CreateGame(gameState);

        game.Step();

        GridPosition gridPosition = GridPosition.Create(2, 2);
        assertThat(game.GetCellState(gridPosition)).isEqualTo(CellState.DEAD);
    }

    @Test
    public void With_Seven_Alive_Neighbours_Alive_Cell_Dies(){
        GameFactory gameFactory = new GameFactory();
        String gameState =
                "X|X|X| |\n" +
                "X|X|X| |\n" +
                "X|X| | |\n" +
                " | | | |\n";
        GameOfLife game = gameFactory.CreateGame(gameState);

        game.Step();

        GridPosition gridPosition = GridPosition.Create(2, 2);
        assertThat(game.GetCellState(gridPosition)).isEqualTo(CellState.DEAD);
    }

    @Test
    public void With_Eight_Alive_Neighbours_Alive_Cell_Dies(){
        GameFactory gameFactory = new GameFactory();
        String gameState =
                "X|X|X| |\n" +
                "X|X|X| |\n" +
                "X|X|X| |\n" +
                " | | | |\n";
        GameOfLife game = gameFactory.CreateGame(gameState);

        game.Step();

        GridPosition gridPosition = GridPosition.Create(2, 2);
        assertThat(game.GetCellState(gridPosition)).isEqualTo(CellState.DEAD);
    }

    @Test
    public void With_Three_Alive_Neighbours_Dead_Cell_Becomes_Alive(){
        GameFactory gameFactory = new GameFactory();
        String gameState =
                " | | | |\n" +
                "X| |X| |\n" +
                "X| | | |\n" +
                " | | | |\n";
        GameOfLife game = gameFactory.CreateGame(gameState);

        game.Step();

        GridPosition gridPosition = GridPosition.Create(2, 2);
        assertThat(game.GetCellState(gridPosition)).isEqualTo(CellState.ALIVE);
    }

    @Test
    public void With_Three_Alive_Neighbours_Dead_Cell_Becomes_Alive_Check_2(){
        GameFactory gameFactory = new GameFactory();
        String gameState =
                " | | | |\n" +
                " |X| | |\n" +
                "X| | | |\n" +
                " | |X| |\n";
        GameOfLife game = gameFactory.CreateGame(gameState);

        game.Step();

        GridPosition gridPosition = GridPosition.Create(3, 2);
        assertThat(game.GetCellState(gridPosition)).isEqualTo(CellState.ALIVE);
    }
}
