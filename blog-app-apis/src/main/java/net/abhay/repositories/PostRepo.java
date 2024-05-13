package net.abhay.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.abhay.entities.Category;
import net.abhay.entities.Post;
import net.abhay.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	List<Post> findByUser(User user);

	List<Post> findByCategory(Category category);
}
