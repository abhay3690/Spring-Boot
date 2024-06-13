package com.abhay.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Course extends BaseEntity{

	private String name;
	private String description;
	@ManyToMany
	@JoinTable(
			name = "author_courses", 
			joinColumns = {
					@JoinColumn(name = "couse_id")
					},
			inverseJoinColumns = {
					@JoinColumn(name="author_id")
			}
			)
	private List<Author> authors;
	@OneToMany(mappedBy = "course")
	private List<Section> sections;

}
