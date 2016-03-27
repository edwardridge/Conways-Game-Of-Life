import java.util.ArrayList;
import java.util.List;

public class GameOfLife {
    private Grid grid;

    public GameOfLife(int gridSize){
        this.grid = new Grid(gridSize);
    }

    public int GetGridSize() {
        return grid.GetGridSize();
    }

    public void SetCellState(GridPosition gridPosition, CellState cellState) {
        grid.SetCellState(gridPosition, cellState);
    }

    public CellState GetCellState(GridPosition gridPosition) {
        return grid.GetCellState(gridPosition);
    }

    public Grid GetGrid(){
        return grid;
    }

    public void Step() {
        List<Cell> newCells = new ArrayList<>();
        for(Cell cell : grid.GetAllCells()){
            int countOfAliveNeighbours = grid.GetCountOfAliveNeighboursForCell(cell);
            Cell newCell = new Cell(cell.GridPosition);

            if((countOfAliveNeighbours == 2 || countOfAliveNeighbours == 3) && cell.CellState == CellState.ALIVE){
                newCell.SetCellState(CellState.ALIVE);
            }
            else if(countOfAliveNeighbours == 3 && cell.CellState == CellState.DEAD){
                newCell.SetCellState(CellState.ALIVE);
            }
            else{
                newCell.SetCellState(CellState.DEAD);
            }

            newCells.add(newCell);
        }

        grid.SetCells(newCells);
    }
}