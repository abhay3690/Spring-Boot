package net.abhay.payloads;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.abhay.entities.Comment;

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
	private Set<CommentDto> comments = new HashSet<>(); 

}
