package net.abhay.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class CategoryDto {
		private int CategoryId;

		private String CategoryTitle;

		private String CategoryDiscription;
	
}
