package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class VerificarProductosInterface {
    private static final Target PRODUCTO_AGREGADO1 = Target.the("ingresa contraseña").located(By.xpath("//*[@id='cart_summary']//a[text()='Blouse']"));
    private static final Target PRODUCTO_AGREGADO2 = Target.the("ingresa confirmacion de contraseña").located(By.xpath("//*[@id='cart_summary']//a[text()='Printed Summer Dress']"));
    private static final Target PRODUCTO_AGREGADO3 = Target.the("check box de informacion").located(By.xpath("//*[@id='cart_summary']//a[text()='Printed Chiffon Dress']"));

    public static Target getProductoAgregado1() {
        return PRODUCTO_AGREGADO1;
    }

    public static Target getProductoAgregado2() {
        return PRODUCTO_AGREGADO2;
    }

    public static Target getProductoAgregado3() {
        return PRODUCTO_AGREGADO3;
    }

}
