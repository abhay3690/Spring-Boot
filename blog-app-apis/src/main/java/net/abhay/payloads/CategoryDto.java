package net.abhay.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Getter@Setter@NoArgsConstructor
public class CategoryDto {

	private int categoryId;
	@NotEmpty@Size(min = 3,message = "please enter Title min size=3")
	private String categoryTitle;
	@NotEmpty@Size(min = 10,message = "min size of description is 10")
	private String categoryDescription;
}
