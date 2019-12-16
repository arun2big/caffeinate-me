package caffeinateme.steps;

import caffeinateme.OrderReceipt;
import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class Customer extends ScenarioActor {

    private long customerId;

    @Steps(shared = true)
    CoffeeOrdersClient coffeeOrders;

    public void hasACustomerIdOf(long newcustomerId) {
        this.customerId = newcustomerId;
    }

    public long getCustomerId() {
        return customerId;
    }

    @Step("#actor places an Order for {0} {1}")
    public OrderReceipt placesAnOrderFor(int quantity, String product) {
        return coffeeOrders.placeOrder(customerId, quantity, product);
    }
}
