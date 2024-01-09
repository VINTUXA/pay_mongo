package home.paymentmongoapi;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Payment {
    public Payment(String id, Double amount, Double originalAmount, PaymentType paymentType, List<Request> requests) {
        this.id = id;
        this.amount = amount;
        this.originalAmount = originalAmount;
        this.paymentType = paymentType;
        this.requests = requests;
    }
    public Payment() {
        // Конструктор без параметров
    }

    @Id
    private String id;
    private Double amount;
    private Double originalAmount;
    private PaymentType paymentType;
    private List<Request> requests;

    @Version
    private Long version;

    public Payment(Double amount,
                   Double originalAmount,
                   PaymentType paymentType,
                   List<Request> requests) {
        this.amount = amount;
        this.originalAmount = originalAmount;
        this.paymentType = paymentType;
        this.requests = requests;
    }
}
