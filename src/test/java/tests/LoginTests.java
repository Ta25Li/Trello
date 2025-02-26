package tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends AppManager {

    @Test
    public void loginPositive(){
        User user = User.builder()
                .email("2885921@gmail.com")
                .password("QAtesting2025")

                .build();

    new HomePage(getDriver()).clickBtnLogin();
    new LoginPage(getDriver()).login(user);

        Assert.assertTrue(new BoardsPage(getDriver()).validateUrl());
    }
}
