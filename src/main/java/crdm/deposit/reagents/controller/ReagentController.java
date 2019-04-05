package crdm.deposit.reagents.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import crdm.deposit.reagents.entity.Reagent;
import crdm.deposit.reagents.service.ReagentService;


@ManagedBean
@RequestScoped
public class ReagentController {

	private List<Reagent> reagents;

	@ManagedProperty(value = "#{reagentService}")
	private ReagentService reagentService;

	public List<Reagent> getReagents() {
		reagents = reagentService.all();
		return reagents;
	}

	public void edit(Integer id) {

	}

	public void delete(Integer id) {

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
