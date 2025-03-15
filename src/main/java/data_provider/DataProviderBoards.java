package data_provider;

import dto.Board;
import org.testng.annotations.DataProvider;
import static utils.RandomUtils.*;

public class DataProviderBoards {
    @DataProvider
    public Board[] newBoardDP(){
    Board board1 = Board.builder().build();
    }
}
