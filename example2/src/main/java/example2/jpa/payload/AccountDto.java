package example2.jpa.payload;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDto {
    private Long id;
    private Long accountNumber;
    private BigDecimal balance;
    private String accountType;
}
