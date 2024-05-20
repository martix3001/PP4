package pl.styczenmarta.ecommerce.sales.cart;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CartTest {
    @Test
    void itIsEmptyWhenCreated(){
        Cart cart = Cart.empty();

        assertThat(cart.isEmpty())
                .isTrue();
    }

    @Test
    void itIsNotEmptyWhenProductWasAdded(){
        Cart cart = Cart.empty();

        String productX = thereIsProductId("X");

        cart.addProduct(productX);

        assertThat(cart.isEmpty())
                .isFalse();
    }

    private String thereIsProductId(String id) {
        return  id;
    }

    @Test
    void itExposeUniqueProductCount(){
        Cart cart = Cart.empty();
        String productX = thereIsProductId("X");

        cart.addProduct(productX);
        assertThat(cart.getLinesCount())
                .isEqualTo(1);

    }
    @Test
    void itExposeUniqueProductCount2(){
        Cart cart = Cart.empty();
        String productX = thereIsProductId("X");

        cart.addProduct(productX);
        cart.addProduct(productX);

        assertThat(cart.getLinesCount())
                .isEqualTo(1);

    }
    @Test
    void itExposeUniqueProductCount3(){
        Cart cart = Cart.empty();
        String productX = thereIsProductId("X");
        String productY = thereIsProductId("Y");

        cart.addProduct(productX);
        cart.addProduct(productX);
        cart.addProduct(productY);

        assertThat(cart.getLinesCount())
                .isEqualTo(2);

    }


    @Test
    void ItExposeCartLneQuantity1(){
        Cart cart = Cart.empty();
        String productX = thereIsProductId("X");

        cart.addProduct(productX);
        List<CartLine> lines = cart.getLines();

        assertCartContainsXAmountOfProduct(lines,productX,1);
    }

    void ItExposeCartLneQuantity2(){
        Cart cart = Cart.empty();
        String productX = thereIsProductId("X");

        cart.addProduct(productX);
        cart.addProduct(productX);
        List<CartLine> lines = cart.getLines();

        assertCartContainsXAmountOfProduct(lines,productX,2);
    }
    @Test
    void ItExposeCartLneQuantity3(){
        Cart cart = Cart.empty();
        String productX = thereIsProductId("X");
        String productY = thereIsProductId("Y");

        cart.addProduct(productX);
        cart.addProduct(productX);
        cart.addProduct(productX);
        cart.addProduct(productY);
        List <CartLine> lines = cart.getLines();

        assertCartContainsXAmountOfProduct(lines,productX,3);
        assertCartContainsXAmountOfProduct(lines,productY,1);
    }

    private void assertCartContainsXAmountOfProduct(List<CartLine> lines, String productId
            , int i) {
        assertThat(lines)
                .filteredOn(cartLine -> cartLine.getProductId().equals(productId))
                .extracting(cartLine -> cartLine.getQty())
                .first()
                .isEqualTo(i);
    }
}
