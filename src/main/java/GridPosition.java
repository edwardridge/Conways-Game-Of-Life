/**
 * Created by edwardridge on 26/03/2016.
 */
public class GridPosition {

    private GridPosition(int x, int y){
        this.X = x;
        this.Y = y;
    }

    public static GridPosition Create(int x, int y){
        return new GridPosition(x, y);
    }

    public static GridPosition CreateZeroBased(int x, int y){
        return new GridPosition(x + 1, y + 1);
    }

    public int GetZeroBasedValueForX(){
        return this.X - 1;
    }

    public int GetZeroBasedValueForY(){
        return this.Y - 1;
    }

//    @Override
//    public int hashCode() {
//        return (this.X * 17) + (this.Y * 31);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (!(obj instanceof GridPosition))
//            return false;
//        if (obj == this)
//            return true;
//
//        GridPosition rhs = (GridPosition) obj;
//        return rhs.X == this.X && rhs.Y == this.Y;
//    }

    public int X;
    public int Y;

}
