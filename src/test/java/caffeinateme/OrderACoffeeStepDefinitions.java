package caffeinateme;

import caffeinateme.steps.Barista;
import caffeinateme.steps.Customer;
import caffeinateme.steps.UserRegistrationClient;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderACoffeeStepDefinitions {

    @Steps
    Customer cathy;

    @Steps
    Barista barry;

    @Steps
    UserRegistrationClient userRegistrations;


    @Given("Cathy has a Caffeinate-Me account")
    public void userHasACaffeinateMeAccount(){
        userRegistrations.registerUser(cathy);
    }

    OrderReceipt orderReceipt;

    @When("^s?he orders a (.*)$")
    public void OrdersALargeCappuccino(String order){
        orderReceipt = cathy.placesAnOrderFor(1, order);
    }

    @Then("^Barry should receive the order$")
    public void barryShouldReceiveTheOrder() {
        assertThat(barry.pendingOrders()).contains(Order.matchingReceipt(orderReceipt));
    }
}
