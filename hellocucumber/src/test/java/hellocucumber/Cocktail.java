package hellocucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Cocktail {

    private Order order;

    @Given("^(.*) who wants to buy a drink$")
    public void who_wants_to_buy_a_drink(String pfFrom) {
        this.order = new Order();
        this.order.declareOwner(pfFrom);
    }

    @When("^an order is declared for (.*)$")
    public void an_order_is_declared_for(String pfTo) {
        this.order.declareTarget(pfTo);
    }

    @Then("^there is (\\d+) cocktails? in the order$")
    public void there_is_cocktails_in_the_order(int pfNbCocktails) {
        List<String> cocktails = this.order.getCocktails();
        assertEquals(pfNbCocktails, cocktails.size());
    }

    @And("^a message saying \"(.*)\" is added$")
    public void a_message_saying_is_added(String pfMessage) {
        this.order.addMessage(pfMessage);
    }

    @Then("^the ticket must say \"(.*)\"$")
    public void the_ticket_must_say(String pfExpected) {
        String ticket = this.order.getTicket();
        assertEquals(pfExpected, ticket);
    }

}
