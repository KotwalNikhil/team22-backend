package com.db.grad.javaapi.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dogs")
@NoArgsConstructor
@Getter
@Setter
public class Dogs {

	@Id
	private long id;
    private String name;
    private long age;

}