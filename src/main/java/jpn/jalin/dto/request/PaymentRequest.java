package jpn.jalin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    private String transactionId;
    private String custName;
    private String itemName;
    private Integer itemPrice;
    private Integer itemQty;
    private String paymentType;
    private String location;
}
