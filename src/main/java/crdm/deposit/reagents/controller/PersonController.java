package crdm.deposit.reagents.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import crdm.deposit.reagents.entity.Person;
import crdm.deposit.reagents.service.PersonService;

@ManagedBean
@RequestScoped
public class PersonController {

	private List<Person> people;
	private Person person = new Person();

	@ManagedProperty(value = "#{personService}")
	private PersonService personService;
	
	@PostConstruct
	private void load() {
		people = personService.all();
	}

	public List<Person> getPeople() {
		return people;
	}

	public void update() {
		personService.update(this.person);
		people = personService.all();
	}

	public Person find(Integer id) {
		return personService.find(id);
	}

	public void delete(Person person) {

		personService.delete(person);
		people = personService.all();

		addMessage("Stergere", "Inregistrarea a fost stearsa");
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
