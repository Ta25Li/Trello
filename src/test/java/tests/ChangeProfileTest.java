package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AtlassianProfilePage;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import utils.NGListener;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static utils.RandomUtils.generateString;
@Listeners(NGListener.class)


public class ChangeProfileTest extends AppManager {

    BoardsPage boardsPage;

    @BeforeMethod
    public void login(Method method) {
        User user = User.builder()
                .email("2885921@gmail.com")
                .password("QAtesting2025")
                .build();
        logger.info("start method ---> "+method.getName() + "  with user "+ user);

        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        boardsPage = new BoardsPage(getDriver());
    }

    @Test
    public void changeProfilePhoto(Method method){
        boardsPage.openMyAccount();
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        System.out.println(tabs);
        getDriver().switchTo().window(tabs.get(1)); //after click openes second widnow, take window from list under index 1
        AtlassianProfilePage atlassianProfilePage = new AtlassianProfilePage(getDriver());

        atlassianProfilePage.changeMyProfilePhoto("src/main/resources/hikari.jpg");

        logger.info(method.getName());
        Assert.assertTrue(atlassianProfilePage
                .validateMessage("We've uploaded your new avatar. It may take a few minutes to display everywhere."));
    }

    @Test
    public void changeProfilePhotoNegativeWrongFormatFile(Method method){
        boardsPage.openMyAccount();
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        System.out.println(tabs);
        getDriver().switchTo().window(tabs.get(1)); //after click openes second widnow, take window from list under index 1
        AtlassianProfilePage atlassianProfilePage = new AtlassianProfilePage(getDriver());

        atlassianProfilePage.changeMyProfilePhoto("src/test/resources/test_logs/log-25_03_15_T_11_58_27.log");

        logger.info(method.getName());
        Assert.assertTrue(atlassianProfilePage.validateMessageWrongFormatFile
                ("Could not load image, the format is invalid."));
    }








}
