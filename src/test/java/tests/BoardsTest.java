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
                .boardTitle("new1")
                .build();

        new BoardsPage(getDriver()).createNewBoard(board);
    }

}
