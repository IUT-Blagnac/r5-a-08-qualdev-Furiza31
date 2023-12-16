package hellocucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * IsItFriday
 */
public class IsItFriday {
    private String today;
    private String actualAnswer;

    static String isItFriday(String today) {
        return "Friday".equals(today) ? "TGIF" : "Nope";
    }

    @Given("today is {string}")
    public void today_is_sunday(String pfToday) {
        today = pfToday;
    }

    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_friday_yet() {
        actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }

}