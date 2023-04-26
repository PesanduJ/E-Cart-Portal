package com.ecartportal.ecartportal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "items")
public class Item {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	private String name;
	private float selling_price;
	private int units;
}
