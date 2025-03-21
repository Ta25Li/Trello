package pages;

import dto.Board;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BoardsPage extends BasePage {
    public BoardsPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,
                10), this);
    }

    @FindBy(xpath = "//li[@data-testid='create-board-tile']")
    WebElement btnCreateNewBoard;

    @FindBy(xpath = "//input[@data-testid='create-board-title-input']")
    WebElement inputBoardTitle;

    @FindBy (xpath = "//button[@data-testid='create-board-submit-button']")
   WebElement btnCreateBoardSubmit;

@FindBy(xpath = "//div[@class='board-tile-details is-badged']")
WebElement firstBoard;

@FindBy(xpath = "//span[text()='Board deleted.']")
WebElement popUpMsgDelete;

@FindBy(xpath = "//button[@data-testid='header-member-menu-button']")
WebElement btnAccount;

@FindBy (xpath = "//a//span[text()='Manage account']")
WebElement btnManageAccount;





public void openMyAccount(){
    clickWait(btnAccount,3);
    clickWait(btnManageAccount,3);
}


public boolean validatePopUpMsg(String text){
    return validateTextInElementWait(popUpMsgDelete,text,5);
}

public void openFirstBoard(){
    firstBoard.click();
}

    public boolean validateUrl() {
        return new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlContains("boards"));
    }

    public void createNewBoard(Board board){
        clickWait(btnCreateNewBoard,5);

        inputBoardTitle.sendKeys(board.getBoardTitle());
        clickWait(btnCreateBoardSubmit,5);

    }
//====================== negative

    public void createNewBoardNegative(Board board){
        btnCreateNewBoard.click();
        inputBoardTitle.sendKeys(board.getBoardTitle());

    }

    public boolean buttonCreateNotClickable(){
        return new WebDriverWait(driver,5)
                .until(ExpectedConditions
                        .not(ExpectedConditions.elementToBeClickable(btnCreateBoardSubmit)));
    }

}
