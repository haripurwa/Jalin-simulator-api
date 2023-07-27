package jpn.jalin.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String custName;
    private String transactionId;
    private String itemName;
    private Integer itemPrice;
    private Integer itemQty;
    private String paymentType;
    private String location;

}
