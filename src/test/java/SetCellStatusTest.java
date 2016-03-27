import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class SetCellStatusTest {
    @Test
    public void Cell_At_1_1_Is_Set_To_Dead_By_Default(){
        GameOfLife gameOfLife = new GameOfLife(8);
        GridPosition gridPosition = GridPosition.Create(1, 1);

        CellState cellState = gameOfLife.GetCellState(gridPosition);

        assertThat(cellState).isEqualTo(CellState.DEAD);
    }

    @Test
    public void When_Cell_At_1_1_Is_Set_To_Alive_Status_Is_Alive(){
        GameOfLife gameOfLife = new GameOfLife(8);
        GridPosition gridPosition = GridPosition.Create(1, 1);

        gameOfLife.SetCellState(gridPosition, CellState.ALIVE);

        CellState cellState = gameOfLife.GetCellState(gridPosition);
        assertThat(cellState).isEqualTo(CellState.ALIVE);
    }

    @Test
    public void When_Cell_At_1_1_Is_Set_To_Alive_Then_Back_To_Dead_Status_Is_Dead(){
        GameOfLife gameOfLife = new GameOfLife(8);
        GridPosition gridPosition = GridPosition.Create(1, 1);

        gameOfLife.SetCellState(gridPosition, CellState.ALIVE);
        gameOfLife.SetCellState(gridPosition, CellState.DEAD);

        CellState cellState = gameOfLife.GetCellState(gridPosition);
        assertThat(cellState).isEqualTo(CellState.DEAD);
    }

    @Test
    public void When_Cell_At_3_2_Is_Set_To_Alive_Status_Is_Alive(){
        GameOfLife gameOfLife = new GameOfLife(8);
        GridPosition gridPosition = GridPosition.Create(3, 2);

        gameOfLife.SetCellState(gridPosition, CellState.ALIVE);

        CellState cellState = gameOfLife.GetCellState(gridPosition);
        assertThat(cellState).isEqualTo(CellState.ALIVE);
    }

    @Test
    public void When_Cell_At_4_7_Is_Set_To_Alive_Status_Is_Alive(){
        GameOfLife gameOfLife = new GameOfLife(8);
        GridPosition gridPosition = GridPosition.Create(4, 7);

        gameOfLife.SetCellState(gridPosition, CellState.ALIVE);

        CellState cellState = gameOfLife.GetCellState(gridPosition);
        assertThat(cellState).isEqualTo(CellState.ALIVE);
    }
}
