package home.paymentmongoapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Request {
    private Double amount;
    private RequestType requestType;
}
