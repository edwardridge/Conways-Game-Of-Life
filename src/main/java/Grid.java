import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Grid {
    private List<Cell> cells;
    private int GridSize;

    public Grid(int gridSize){
        this.cells = new ArrayList<>();
        this.GridSize = gridSize;

        for(int i = 0; i < gridSize; i++){
            for(int j = 0; j < gridSize; j++){
                GridPosition gridPosition = GridPosition.CreateZeroBased(i, j);
                cells.add(new Cell(gridPosition));
            }
        }
    }

    public int GetGridSize() {
        return GridSize;
    }

    public void SetCellState(GridPosition gridPosition, CellState cellState) {
        Optional<Cell> cell = GetCell(gridPosition);

        if(cell.isPresent()){
            cell.get().SetCellState(cellState);
        }
    }

    public CellState GetCellState(GridPosition gridPosition) {
        Optional<Cell> cell = GetCell(gridPosition);

        if(cell.isPresent()){
            return cell.get().CellState;
        }

        return null;
    }

    public List<Cell> GetAllCells(){
        return cells;
    }

    public int GetCountOfAliveNeighboursForCell(Cell cell) {
        int countOfAliveNeighbours = 0;
        GridPosition[] gridPositionsOfNeighbours = GetGridPositionsOfNeighbours(cell);

        for(GridPosition gridPosition : gridPositionsOfNeighbours){
            if(CellIsAlive(gridPosition)){
                countOfAliveNeighbours = countOfAliveNeighbours + 1;
            }
        }

        return countOfAliveNeighbours;
    }

    public void SetCells(List<Cell> cells){
        this.cells = cells;
    }

    public Cell[][] AsTwoDimArray(){
        Cell[][] cellsAsTwoDimArray = new Cell[GridSize][GridSize];
        for(Cell cell : GetAllCells()){
            cellsAsTwoDimArray[cell.GridPosition.X - 1][cell.GridPosition.Y - 1] = cell;
        }

        return cellsAsTwoDimArray;
    }

    private GridPosition[] GetGridPositionsOfNeighbours(Cell cell){
        List<GridPosition> gridPositions = new ArrayList<>();
        GridPosition positionForCell = cell.GridPosition;

        int[] offsets = new int[]{-1, 0, 1};

        for(int xOffset : offsets){
            for(int yOffset : offsets){
                if(xOffset == 0 && yOffset == 0){

                }else{
                    gridPositions.add(GridPosition.Create(positionForCell.X + xOffset, positionForCell.Y + yOffset));
                }
            }
        }

        return gridPositions.toArray(new GridPosition[gridPositions.size()]);

    }

    private boolean CellIsAlive(GridPosition gridPosition){
        Optional<Cell> cell = GetCell(gridPosition);
        if(cell.isPresent() && cell.get().CellState == CellState.ALIVE){
            return true;
        }

        return false;
    }

    private Optional<Cell> GetCell(GridPosition gridPosition){
        return cells.stream().filter(p -> p.GridPosition.X == gridPosition.X
                && p.GridPosition.Y == gridPosition.Y).findFirst();
    }
}
