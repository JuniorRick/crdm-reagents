package crdm.deposit.reagents.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import crdm.deposit.reagents.entity.Producer;
import crdm.deposit.reagents.entity.Reagent;
import crdm.deposit.reagents.service.ReagentService;


@ManagedBean
@RequestScoped
public class ReagentController {

	private List<Reagent> reagents;
	
	private Reagent reagent = new Reagent();
	private Producer producer = new Producer();
	
	@ManagedProperty(value = "#{reagentService}")
	private ReagentService reagentService;

	@PostConstruct
	private void load() {
		reagents= reagentService.all();
	}
	
	public List<Reagent> getReagents() {
		return reagents;
	}

	public void update() {
		reagentService.update(this.reagent);
		reagents = reagentService.all();
	}

	public void delete(Reagent reagent) {
		reagentService.delete(reagent);
		reagents = reagentService.all();
	}

	
	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public Reagent getReagent() {
		return reagent;
	}

	public void setReagent(Reagent reagent) {
		this.reagent = reagent;
	}

	public ReagentService getReagentService() {
		return reagentService;
	}

	public void setReagentService(ReagentService reagentService) {
		this.reagentService = reagentService;
	}

	public Reagent getReagent(Integer id) {
		return null;
	}

}
