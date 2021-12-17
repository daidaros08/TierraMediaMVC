package model;

import java.util.LinkedList;
import java.util.List;

public class PercentOffer extends Offer {
	private Integer deductionPercent;

	// Constructor con 2 atracciones
	public PercentOffer(Integer id, String name, String desc, String tipe, Attraction atr1,
			Attraction atr2, Integer percent) {
		super("Por", id, name, desc, tipe);
		this.deductionPercent = percent;
		this.attractionsInclude.add(atr1);
		this.attractionsInclude.add(atr2);
		this.attractionAmount = this.attractionsInclude.size();
	}

	// Constructor con 1 atraccion
	public PercentOffer(Integer id, String name, String desc, String tipe, Attraction atr1,
			Integer percent) {
		super("Por", id, name, desc, tipe);
		this.deductionPercent = percent;
		this.attractionsInclude.add(atr1);
		this.attractionAmount = this.attractionsInclude.size();
	}

	@Override
	public Integer getCost() {
		Integer totalCost = 0;
		Integer parcialCost = 0;
		
		for (Attraction atr : this.attractionsInclude) {
			parcialCost += atr.getCost();
		}
		totalCost = parcialCost - (parcialCost * (this.getDeductionPercent() / 100));
		return totalCost;
		
	}

	@Override
	public Integer getDeductionPercent() {
		return this.deductionPercent;
	}

	@Override
	public Attraction getFreeAttraction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAbsolutePrice() {
		// TODO Auto-generated method stub
		return null;
	}

}
