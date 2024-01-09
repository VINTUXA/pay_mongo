package home.paymentmongoapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class PaymentMongoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentMongoApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(PaymentRepository repository){
		return args -> {
			Request request = new Request(12.2, RequestType.PAY);
			Payment payment = new Payment(100.0,100.0,PaymentType.DEFAULT, List.of(request));
			repository.insert(payment);
		};
	}

}
