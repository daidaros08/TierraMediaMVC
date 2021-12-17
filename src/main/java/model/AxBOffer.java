package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AxBOffer extends Offer {
	private Attraction freeAtr;
	private List<Attraction> payAttractions;
	
	
	// Constructor con 3 atracciones
	public AxBOffer(Integer id, String name, String desc, String tipe, Attraction firstAtr, Attraction secAtr,
			Attraction freeAtr) {
		super("AxB", id, name, desc, tipe);
		this.payAttractions = new LinkedList<Attraction>();
		this.payAttractions.add(firstAtr);
		this.payAttractions.add(secAtr);
		this.freeAtr = freeAtr;
		this.attractionsInclude.add(firstAtr);
		this.attractionsInclude.add(secAtr);
		this.attractionsInclude.add(freeAtr);
		this.attractionAmount = this.attractionsInclude.size();
	}

	// Constructor con 2 atracciones
	public AxBOffer(Integer id, String name, String desc, String tipe, Attraction firstAtr, Attraction freeAtr) {
		super("AxB", id, name, desc, tipe);
		this.payAttractions = new LinkedList<Attraction>();
		this.payAttractions.add(firstAtr);
		this.freeAtr = freeAtr;
		this.attractionsInclude.add(firstAtr);
		this.attractionsInclude.add(freeAtr);
		this.attractionAmount = this.attractionsInclude.size();
	}

	@Override
	public Integer getCost() {

		Integer totalCost = 0;
		
		for (Attraction atr : this.payAttractions) {
			totalCost += atr.getCost();	
		}
		
		
		return totalCost;
		
	}

	public Attraction getFreeAttraction() {
		return this.freeAtr;
	}

	public List<Attraction> getPayAttractions() {
		return this.payAttractions;
	}

	@Override
	public Integer getDeductionPercent() {
		return null;
	}

	@Override
	public Integer getAbsolutePrice() {
		// TODO Auto-generated method stub
		return null;
	}

}
