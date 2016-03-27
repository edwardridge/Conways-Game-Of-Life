public class GameFactory {
    public GameOfLife CreateGame(String gameState) {
        String[] lines = gameState.split("\n");

        GameOfLife gameOfLife = new GameOfLife(lines.length);

        for(int i = 0; i < lines.length; i++){
            String line = lines[i];
            String[] cellsForLine = line.split("\\|", -1);

            for(int j = 0; j < cellsForLine.length; j++){
                String cellString = cellsForLine[j];

                if(cellString.equalsIgnoreCase("X")){
                    gameOfLife.SetCellState(GridPosition.CreateZeroBased(i, j), CellState.ALIVE);
                }
            }

        }

        return gameOfLife;
    }
}
