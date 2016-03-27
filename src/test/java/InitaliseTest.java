import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class InitaliseTest{

    @Test
    public void When_Grid_Size_Is_Initialised_To_Four_Grid_Size_Is_Set_To_Four(){
        GameOfLife gameOfLife = new GameOfLife(4);
        assertThat(gameOfLife.GetGridSize()).isEqualTo(4);
    }

    @Test
    public void When_Grid_Size_Is_Initialised_To_Seven_Grid_Size_Is_Set_To_Seven(){
        GameOfLife gameOfLife = new GameOfLife(7);
        assertThat(gameOfLife.GetGridSize()).isEqualTo(7);
    }
}