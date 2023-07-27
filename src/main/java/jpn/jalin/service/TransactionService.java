package jpn.jalin.service;


import jpn.jalin.dto.request.CheckRequest;
import jpn.jalin.dto.request.PaymentRequest;
import jpn.jalin.dto.request.Request;
import jpn.jalin.dto.response.CustomResponse;
import jpn.jalin.model.Transactions;
import jpn.jalin.repository.TransactionsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionsRepo transactionRepository;

    public CustomResponse initiatePayment(PaymentRequest request) {
        CustomResponse response = new CustomResponse();
        Transactions transactions = new Transactions();

        Optional<Transactions> byTransactionId = transactionRepository.findByTransactionId(request.getTransactionId());
        if (byTransactionId.isPresent()) {
            response.setStatus("Error");
            response.setMessage("Transaction Id already exists");
            return response;
        }

        transactions.setTransactionId(request.getTransactionId());
        transactions.setItemName(request.getItemName());
        transactions.setCustName(request.getCustName());
        transactions.setItemPrice(request.getItemPrice());
        transactions.setItemQty(request.getItemQty());
        transactions.setPaymentType(request.getPaymentType());
        transactions.setLocation(request.getLocation());
        transactionRepository.save(transactions);

        response.setStatus("Success");
        response.setMessage("Transaction successfully created");
        return response;
    }

    public CustomResponse checkStatus(CheckRequest request) {
        CustomResponse response = new CustomResponse();
        Optional<Transactions> byTransactionId = transactionRepository.findByTransactionId(request.getTransactionId());
        if (byTransactionId.isEmpty()) {
            response.setStatus("Error");
            response.setMessage("Transaction Id Not Found");
            return response;
        }

        response.setStatus("Success");
        response.setMessage(byTransactionId.get().getLocation());
        return response;
    }

    public CustomResponse onProsses(Request request) {
        CustomResponse response = new CustomResponse();
        response.setStatus("Success");
        response.setMessage("API ON PROGRESS");
        return response;
    }
}
