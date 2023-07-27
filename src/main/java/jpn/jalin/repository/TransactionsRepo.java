package jpn.jalin.repository;

import jpn.jalin.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionsRepo  extends JpaRepository<Transactions, Integer> {
    Optional<Transactions>findByTransactionId( @Param("transactionId") String transactionid);
}
