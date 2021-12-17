	package model;

import java.util.LinkedList;
import java.util.List;

public abstract class Offer extends Product {
	protected List<Attraction> attractionsInclude;
	protected Integer attractionAmount;
	private String offerClass;

	public Offer(String offerClass,Integer id, String name,  String desc, String tipe) {
		super(id, name, 0, 0., desc, tipe);
		this.attractionsInclude = new LinkedList<Attraction>();
		this.offerClass=offerClass;
	}

	@Override
	public abstract Integer getCost();

	public List<Attraction> getAttractionsInclude() {
		return this.attractionsInclude;
	}

	public Integer getAttractionAmount() {
		return this.attractionAmount;
	}

	@Override
	public Double getDuration() {
		Double totalDuration = 0.0;
		
		for (Attraction atr : attractionsInclude) {
			totalDuration += atr.getDuration();
	
			
		}
		return totalDuration;
	}

	@Override
	public boolean canHost(int i) {
		if (this.getAttractionAmount() == 1) {
			return this.attractionsInclude.get(0).canHost(i);
		}
		if (this.getAttractionAmount() == 2) {
			return this.attractionsInclude.get(0).canHost(i) && this.attractionsInclude.get(1).canHost(i);

		}
		if (this.getAttractionAmount() == 3) {
			return this.attractionsInclude.get(0).canHost(i) && this.attractionsInclude.get(1).canHost(i)
					&& this.attractionsInclude.get(2).canHost(i);

		}
		return false;
	}

	@Override
	public void host(int i) {
		for (Attraction atr : attractionsInclude) {
			atr.host(i);
		}

	}
	
	public abstract Integer getDeductionPercent();
	
	public abstract Attraction getFreeAttraction();
	
	public abstract Integer getAbsolutePrice();
	
	public String getOfferClass() {
		return this.offerClass;
	}


}
