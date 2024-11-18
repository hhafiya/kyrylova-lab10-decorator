import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.decorators.abstractDecorator.decorators.BasicItem;
import com.decorators.abstractDecorator.decorators.BasketDecorator;
import com.decorators.abstractDecorator.decorators.Item;
import com.decorators.abstractDecorator.decorators.PaperDecorator;
import com.decorators.abstractDecorator.decorators.RibbonDecorator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemDecoratorTest {

    private Item basicItem;

    @BeforeEach
    public void setUp() {
        basicItem = new BasicItem();
    }

    @Test
    public void testBasketDecorator() {
        Item basketItem = new BasketDecorator(basicItem);

        assertEquals("Basic item, basket", basketItem.getDescription());
        assertEquals(4.0 + basicItem.getPrice(), basketItem.getPrice(), 0.001);
    }

    @Test
    public void testPaperDecorator() {
        Item paperItem = new PaperDecorator(basicItem);

        assertEquals("Basic item, paper", paperItem.getDescription());
        assertEquals(13.0 + basicItem.getPrice(), paperItem.getPrice(), 0.001);
    }

    @Test
    public void testRibbonDecorator() {
        Item ribbonItem = new RibbonDecorator(basicItem);

        assertEquals("Basic item, ribbon", ribbonItem.getDescription());
        assertEquals(40.0 + basicItem.getPrice(), ribbonItem.getPrice(), 0.001);
    }

    @Test
    public void testAllDecorators() {
        Item decoratedItem = new RibbonDecorator(new PaperDecorator(new BasketDecorator(basicItem)));

        assertEquals("Basic item, basket, paper, ribbon", decoratedItem.getDescription());
        assertEquals(4.0 + 13.0 + 40.0 + basicItem.getPrice(), decoratedItem.getPrice(), 0.001);
    }
}
