package hellocucumber;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String owner;
    private String target;
    private String message;
    private List<String> cocktails = new ArrayList<>();

    public void declareTarget(String pfTarget) {
        this.target = pfTarget;
    }

    public void declareOwner(String pfOwner) {
        this.owner = pfOwner;
    }

    public List<String> getCocktails() {
        return this.cocktails;
    }

    public void addMessage(String pfMessage) {
        this.message = pfMessage;
    }

    public String getTicket() {
        return "From " + this.owner + " to " + this.target + ": " + this.message;
    }
}
