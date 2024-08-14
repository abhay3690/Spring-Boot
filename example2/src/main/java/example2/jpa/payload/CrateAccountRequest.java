package example2.jpa.payload;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CrateAccountRequest {
    private String accountNumber;
    private BigDecimal balance;
    private String accountType;
}
