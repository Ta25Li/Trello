package tests;

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

    @BeforeMethod
    public void login(){
        User user = User.builder()
                .email("2885921@gmail.com")
                .password("QAtesting2025")
                .build();

        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
    }
    @Test
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
    public void createNewBoardNegative(){
        Board board = Board.builder()
                .boardTitle("")
                .build();

        new BoardsPage(getDriver()).createNewBoardNegative(board);

        Assert.assertTrue(new BoardsPage(getDriver()).buttonCreateNotClickable());

    }
}
