package actions;

import org.openqa.selenium.WebDriver;
import pageObjects.FormyPage;

public class FormyPageActions {

    protected WebDriver driver = null;
    FormyPage formyPage = null;

    public FormyPageActions (WebDriver driver){

        this.driver = driver;
        formyPage = new FormyPage(driver);

    }

    public void verifyApp() {

        try {
            if (formyPage.getPageTitle().equals("Formy")) {
                if (formyPage.getHeader().isDisplayed()) {
                    System.out.println("Actual result: App Loaded Succesfully");
                } else System.out.println("Actual result: App Not Loaded");
            } else System.out.println("Actual result: App Not Loaded");

        } catch (Exception e) {
            System.out.println("Actual result: App Not Loaded");
            System.out.println(e);
        }
    }

    public void setFirstname(String firstName){

        try {
            formyPage.getForm1().sendKeys(firstName);
            System.out.println("Actual result: First Name Set Successfully");

        }catch( Exception e){

            System.out.println("Actual result: not possible to set name");
            System.out.println(e);

        }
    }

    public void validateConfirmation (){

        System.out.println("The TXT IS " + formyPage.getConfirmMsj().getText());
        if (formyPage.getConfirmMsj().getText().equals("The form was successfully submitted!"))
            System.out.println("Actual result: Form was successfully submitted!");
        else System.out.println("Actual result: Not Possible to submitt form ");


    }




}
