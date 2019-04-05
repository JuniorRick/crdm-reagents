package crdm.deposit.reagents.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import crdm.deposit.reagents.entity.Person;
import crdm.deposit.reagents.service.PersonService;

@ManagedBean
@RequestScoped
public class PersonController {

	private List<Person> people;
	
	@ManagedProperty(value="#{personService}")
	private PersonService personService;
	
	
	public List<Person> getPeople() {
		people = personService.all();
		return people;
	}

	public void edit(Integer id) {
		
	}
	public void delete(Integer id) {
		
	}
	
	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	public Person getPerson(Integer id) {
		return null;
	}
	
}
