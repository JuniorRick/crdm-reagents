package crdm.deposit.blanks.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import crdm.deposit.blanks.entity.Producer;
import crdm.deposit.blanks.service.ProducerService;

@ManagedBean
@RequestScoped
public class ProducerController {

	private List<Producer> producers;
	
	@ManagedProperty(value="#{producerService}")
	private ProducerService producerService;
	
	
	public List<Producer> getProducers() {
		producers = producerService.all();
		return producers;
	}

	public void edit(Integer id) {
		
	}
	public void delete(Integer id) {
		
	}
	
	public ProducerService getProducerService() {
		return producerService;
	}

	public void setProducerService(ProducerService producerService) {
		this.producerService = producerService;
	}
	
	public Producer getProducer(Integer id) {
		return null;
	}
	
}
