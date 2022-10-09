package utils;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class AccionesWeb extends Object {
    private static final int TIEMPO_DE_ESPERA = 1;

    public void tomarCapturaPantalla() {
        Serenity.takeScreenshot();
    }

    public void esperaElementoVisible(By element) {
        try {
            WebDriverWait dwait = new WebDriverWait(getDriver(), TIEMPO_DE_ESPERA);
            dwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
        } catch (Exception e) {
            return;
        }
    }
}
