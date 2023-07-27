package jpn.jalin.controller;


import jpn.jalin.dto.request.CheckRequest;
import jpn.jalin.dto.request.PaymentRequest;
import jpn.jalin.dto.request.Request;
import jpn.jalin.dto.response.CustomResponse;
import jpn.jalin.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qr")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping(value = "/payment", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomResponse payment(@RequestBody PaymentRequest paymentRequest) {
        return transactionService.initiatePayment(paymentRequest);
    }

    @PostMapping(value = "/check", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomResponse check(@RequestBody CheckRequest checkStatusRequest) {
        return transactionService.checkStatus(checkStatusRequest);
    }

    @PostMapping(value = "/refund", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomResponse refund(@RequestBody Request request) {
        return transactionService.onProsses(request);
    }

    @PostMapping(value = "/inquiry", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomResponse inquiry(@RequestBody Request request) {
        return transactionService.onProsses(request);
    }

    @PostMapping(value = "/payment/debit", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomResponse debit(@RequestBody Request request) {
        return transactionService.onProsses(request);
    }

    @PostMapping(value = "/payment/reversal", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomResponse reversal(@RequestBody Request request) {
        return transactionService.onProsses(request);
    }

    @PostMapping(value = "/payment/reversal/rep", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomResponse rep(@RequestBody Request request) {
        return transactionService.onProsses(request);
    }

    @PostMapping(value = "/tcico/inquiry", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomResponse tcico(@RequestBody Request request) {
        return transactionService.onProsses(request);
    }
}
