package crdm.deposit.blanks.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reagents")
public class Reagent {
	
	
	@Id
	private Integer id;
	
}
