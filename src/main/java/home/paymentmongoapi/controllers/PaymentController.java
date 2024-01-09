package home.paymentmongoapi.controllers;

import home.paymentmongoapi.Payment;
import home.paymentmongoapi.PaymentService;
import home.paymentmongoapi.Request;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/payments")
@AllArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    @GetMapping
    public List<Payment> fetchAllPayment(){
        return paymentService.getAllPayments();
    }

    @PostMapping("/pay")
    public Payment createPayment(@RequestBody Request request) {
        return paymentService.createPayment(request);
    }

    @PostMapping("/cancel/{paymentId}")
    public Payment cancelPayment(@PathVariable String paymentId, @RequestBody Request request) {
        return paymentService.cancelPayment(paymentId, request);
    }
}
