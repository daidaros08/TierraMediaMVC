package model;

import java.util.LinkedList;
import java.util.List;

public class AbsoluteOffer extends Offer {
	private Integer absolutePrice;

	// constructor 2 atracciones
	public AbsoluteOffer(Integer id, String name, String description, String tipe, Attraction atr1, Attraction atr2,
			Integer absolutePrice) {
		super("Abs", id, name, description, tipe);
		this.attractionsInclude = new LinkedList<Attraction>();
		this.absolutePrice = absolutePrice;
		this.attractionsInclude.add(atr1);
		this.attractionsInclude.add(atr2);
		this.attractionAmount = this.attractionsInclude.size();
	}

	// constructor 1 atraccion
	public AbsoluteOffer(Integer id, String name, String description, String tipe, Attraction atr1,
			Integer absolutePrice) {
		super("Abs", id, name, description, tipe);
		this.absolutePrice = absolutePrice;
		this.attractionsInclude.add(atr1);
		this.attractionAmount = this.attractionsInclude.size();

	}

	@Override
	public Integer getCost() {

		return this.absolutePrice;
		
	}

	@Override
	public Integer getDeductionPercent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Attraction getFreeAttraction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAbsolutePrice() {
		// TODO Auto-generated method stub
		return this.absolutePrice;
	}

}
