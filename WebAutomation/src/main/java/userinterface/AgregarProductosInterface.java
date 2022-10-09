package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class AgregarProductosInterface {
    private static final Target POSICIONAR_HOVER_PRODUCTO1 = Target.the("Hover del producto").located(By.xpath("(//*[@class='product-container']//child::a[@title='Blouse'])[2]"));
    private static final Target BTN_ADD_CART1 = Target.the("Agregar al carrito").located(By.xpath("(//*[@class='product-container']//child::a[@title='Blouse'])[2]//following::a[1]"));
    private static final Target POSICIONAR_HOVER_PRODUCTO2 = Target.the("Hover del producto").located(By.xpath("(//*[@class='product-container']//child::a[@title='Printed Summer Dress'])[2]"));
    private static final Target BTN_ADD_CART2 = Target.the("Agregar al carrito").located(By.xpath("(//*[@class='product-container']//child::a[@title='Printed Summer Dress'])[2]//following::a[1]"));
    private static final Target POSICIONAR_HOVER_PRODUCTO3 = Target.the("Hover del producto").located(By.xpath("(//*[@class='product-container']//child::a[@title='Printed Chiffon Dress'])[2]"));
    private static final Target BTN_ADD_CART3 = Target.the("Agregar al carrito").located(By.xpath("(//*[@class='product-container']//child::a[@title='Printed Chiffon Dress'])[2]//following::a[1]"));
    private static final Target BTN_CONTINUE_SHOPPING = Target.the("Boton continuar comprando").located(By.xpath("//span[@title='Continue shopping']"));
    private static final By WAIT_DIV = By.id("layer_cart");
    private static final Target BTN_CARRITO = Target.the("Boton carrito de compras").located(By.xpath("//*[@id=\"header\"]//child::a[@title='View my shopping cart']"));

    public Target getPosicionarHoverProducto() {
        return POSICIONAR_HOVER_PRODUCTO1;
    }

    public Target getBtnAddCart() {
        return BTN_ADD_CART1;
    }

    public Target getPosicionarHoverProducto2() {
        return POSICIONAR_HOVER_PRODUCTO2;
    }

    public Target getBtnAddCart2() {
        return BTN_ADD_CART2;
    }

    public Target getPosicionarHoverProducto3() {
        return POSICIONAR_HOVER_PRODUCTO3;
    }

    public Target getBtnAddCart3() {
        return BTN_ADD_CART3;
    }

    public static Target getBtnContinueShopping() {
        return BTN_CONTINUE_SHOPPING;
    }

    public static By getWaitDiv() {
        return WAIT_DIV;
    }

    public static Target getBtnCarrito() {
        return BTN_CARRITO;
    }

}
