package com.ins.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "med")
public class User {
	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "name" ,length = 20)
	private String name;
	@Column(name = "address" ,length = 20)
	private String address;
	
}
