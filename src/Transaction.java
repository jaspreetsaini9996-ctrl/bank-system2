import java.io.Serializable;
import java.time.LocalDateTime;

public class Transaction implements Serializable {
    private String type;
    private LocalDateTime time;
    private String to;
    private Double amount;

    public Transaction(String type, Double amount) {
        this.type = type;
        this.time = LocalDateTime.now();

        this.amount = amount;
    }


    @Override
    public String toString() {
        return type + "| " + time + " |" + to + "| " + amount;
    }
    public String getType() {
        return type;
    }



    public LocalDateTime getTime() {
        return time;
    }



    public String getTo() {
        return to;
    }



    public Double getAmount() {
        return amount;
    }


}
