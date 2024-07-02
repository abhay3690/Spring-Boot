package com.ins.modal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ins.dto.UserDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String email;
	private String mobile;
	private String website;
	private String bio;
	private String gender;
	private String image;
	private String password;
	@Embedded
	@ElementCollection
	private Set<UserDto> follower = new HashSet<UserDto>();
	@Embedded
	@ElementCollection
	private Set<UserDto> follwing = new HashSet<UserDto>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Story> stories = new ArrayList<>();
	@ManyToMany
	private List<Post> savedPost = new ArrayList<>();

	public String getUserImage() {
		// TODO Auto-generated method stub
		return null;
	}

}
