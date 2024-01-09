package home.paymentmongoapi;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    public List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }

    public Payment createPayment(Request request) {

        Payment payment = new Payment(request.getAmount(),request.getAmount(), PaymentType.DEFAULT, List.of(request));

        return paymentRepository.save(payment);
    }

    public Payment cancelPayment(String paymentId, Request request) {
        try {
            Payment payment = paymentRepository.findById(paymentId).orElseThrow(() -> new RuntimeException("Payment not found"));
            payment.setAmount(payment.getAmount() - request.getAmount());
            payment.getRequests().add(request);

            paymentRepository.save(payment);
            return payment;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }
}
