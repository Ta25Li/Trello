package tests;

import data_provider.DataProviderBoards;
import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyBoardPage;
import static utils.RandomUtils.*;

public class BoardsTest extends AppManager {

    @BeforeMethod(alwaysRun = true)
    public void login(){
        User user = User.builder()
                .email("2885921@gmail.com")
                .password("QAtesting2025")
                .build();

        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
    }
    @Test(groups ={"smoke","regres"})
    public void createNewBoardPositive(){
        Board board = Board.builder()
                .boardTitle(generateString(5))
                .build();

        new BoardsPage(getDriver()).createNewBoard(board);

     //   Assert.assertTrue(new MyBoardPage(getDriver()).validateBoardName("new1",5));
        Assert.assertTrue(new MyBoardPage(getDriver()).validateBoardName(board.getBoardTitle(), 5));

    }
//===========negative==================

    @Test
    //@Test (invocationCount = 3) --- test will go 3 times
    public void createNewBoardNegative(){
        Board board = Board.builder()
                .boardTitle("")
                .build();

        new BoardsPage(getDriver()).createNewBoardNegative(board);

        Assert.assertTrue(new BoardsPage(getDriver()).buttonCreateNotClickable());

    }
    @Test(dataProvider = "newBoardDP", dataProviderClass = DataProviderBoards.class)
    public void createNewBoardPositiveWithDP(Board board){

        new BoardsPage(getDriver()).createNewBoard(board);


        Assert.assertTrue(new MyBoardPage(getDriver())
                .validateBoardName(board.getBoardTitle(), 5));

    }
    @Test(dataProvider = "newBoardDPFile", dataProviderClass = DataProviderBoards.class)
    public void createNewBoardPositiveWithDPFile(Board board){

        new BoardsPage(getDriver()).createNewBoard(board);


        Assert.assertTrue(new MyBoardPage(getDriver())
                .validateBoardName(board.getBoardTitle(), 5));

    }

}
