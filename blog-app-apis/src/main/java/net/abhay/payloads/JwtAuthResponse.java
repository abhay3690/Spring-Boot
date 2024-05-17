package net.abhay.payloads;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class JwtAuthResponse {
	private String token;
}
