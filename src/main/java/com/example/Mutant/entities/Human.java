package com.example.Mutant.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Humano")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Human extends Base  {
	
@Column(name="dnaHumano")
	
	private String[] dnaH;


	

}
