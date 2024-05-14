package net.abhay.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
	private int postId; 
	private String title;
	private String content;
	private String imageName;
	private String addedDate;
	private CategoryDto category;
	private UserDto user;

}
