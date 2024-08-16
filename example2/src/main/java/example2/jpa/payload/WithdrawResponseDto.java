package example2.jpa.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class WithdrawResponseDto {
    private String message;
    private BigDecimal newBalance;
}