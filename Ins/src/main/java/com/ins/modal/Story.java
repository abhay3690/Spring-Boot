package com.ins.modal;

import java.time.LocalDateTime;
import java.util.Objects;

import com.ins.dto.UserDto;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Stories")
public class Story {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "user_id")),
			@AttributeOverride(name = "email", column = @Column(name = "user_email")),

	})
	private UserDto user;
	@NotNull
	private String image;
	private String caption;
	private LocalDateTime timestamp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(caption, id, image, timestamp, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Story other = (Story) obj;
		return Objects.equals(caption, other.caption) && id == other.id && Objects.equals(image, other.image)
				&& Objects.equals(timestamp, other.timestamp) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Story [id=" + id + ", user=" + user + ", image=" + image + ", caption=" + caption + ", timestamp="
				+ timestamp + "]";
	}

	public Story(int id, UserDto user, @NotNull String image, String caption, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.user = user;
		this.image = image;
		this.caption = caption;
		this.timestamp = timestamp;
	}

	public Story() {
		super();
		// TODO Auto-generated constructor stub
	}

}
