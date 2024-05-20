package com.ins.dto;

import org.hibernate.internal.build.AllowSysOut;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data

public class UserDto {
	private int id;
	private String username;
	private String email;
	private String name;
	private String userImage;	

}
