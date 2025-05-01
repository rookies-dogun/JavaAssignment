package mylab.order.di.xml;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:order/order.xml")
public class OrderTest {


    @Autowired
    ShoppingCart cart;

    @Autowired
    OrderService orderService;

    @Test
    public void testShoppingCart() {

        // 카트가 비어있는지 확인
        Assertions.assertNotNull(cart);
        // 개수 확인
        Assertions.assertEquals(2, cart.getProducts().size());
        // 전체 출력
        cart.getProducts().forEach(product -> {
            System.out.println(product.toString());
        });
    }

    @Test
    public void testOrderService() {

        Assertions.assertNotNull(orderService);
        Assertions.assertNotNull(orderService.getShoppingCart());
        System.out.println(orderService.calculateOrderTotal());

    }
}
