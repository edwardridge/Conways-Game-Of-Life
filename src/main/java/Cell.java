/**
 * Created by edwardridge on 26/03/2016.
 */
public class Cell {
    CellState CellState;
    GridPosition GridPosition;

    public Cell(GridPosition gridPosition){
        CellState = CellState.DEAD;
        GridPosition = gridPosition;
    }

    public void SetCellState(CellState cellState){
        this.CellState = cellState;
    }
}
