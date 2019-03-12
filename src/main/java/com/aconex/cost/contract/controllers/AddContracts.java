package com.aconex.cost.contract.controllers;

import com.aconex.cost.contract.services.ContractService;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.POST;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.ws.rs.Path;
import org.hibernate.SessionFactory;
import com.aconex.cost.contract.models.Contract;
import org.hibernate.Session;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/form")
@Produces(MediaType.APPLICATION_JSON)
public class AddContracts {

    private final SessionFactory sessionFactory;

    public AddContracts(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@POST
	@UnitOfWork
    public Response index(ContractPostInput contract_from_post) {
        Session session  = sessionFactory.getCurrentSession();
		Contract contract = new Contract();
		contract.setCode(contract_from_post.contractcode);
		contract.setDescription(contract_from_post.description);
		contract.setVendor(contract_from_post.vendor);
		contract.setBudget(contract_from_post.budget);
		contract.setForecast(contract_from_post.forecast);
		contract.setPaid(contract_from_post.payment);
		contract.setPercentComplete(contract_from_post.percentComplete);
		contract.setCommitted(contract_from_post.committed);
		session.persist(contract);

        return Response.ok().build();
    }
    
	 public static class ContractPostInput {

        @JsonProperty("contractcode")
        public String contractcode;
		
		@JsonProperty("description")
        public String description;
		
		@JsonProperty("vendor")
        public String vendor;
		
		@JsonProperty("percentComplete")
        public double percentComplete;
		
		@JsonProperty("budget")
        public double budget;
		
		@JsonProperty("payment")
        public double payment;
		
		@JsonProperty("forecast")
        public double forecast;
		
		@JsonProperty("committed")
        public double committed;
		

    }
	

}
