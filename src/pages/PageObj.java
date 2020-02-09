package pages;

public class PageObj {

    private WebBrowserDriver theDriver;
    private BasePage page;
    private LoginPage loginPage;

    // Constructor
    public PageObj(WebBrowserDriver theDriver, BasePage page, LoginPage loginPage) {
        this.theDriver = theDriver;
        this.page = page;
        this.loginPage = loginPage;
    }

    public void doLogin(String username, String password){
        this.loginPage.doLogin(username, password);
    }

    public WebBrowserDriver getTheDriver() {
        return theDriver;
    }

    public BasePage getPage() {
        return page;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }
}