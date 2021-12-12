package model;

import java.util.Comparator;

public class SortedAttractions implements Comparator<Attraction> {

	@Override
	public int compare(Attraction o1, Attraction o2) {
		if (o1.getCost() != o2.getCost()) {
			return (o1.getCost().compareTo(o2.getCost())) * -1;
		} else {
			return (o1.getDuration().compareTo(o2.getDuration())) * -1;
		}
		
	}

}
