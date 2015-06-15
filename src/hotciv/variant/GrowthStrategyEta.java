package hotciv.variant;

import hotciv.framework.City;
import hotciv.framework.GrowthStrategy;

public class GrowthStrategyEta implements GrowthStrategy {
	public void grow(City city) {
		int currentPopulation = city.getSize();
		
		if(city.getFood() >= (5 + (currentPopulation * 3)) ){
			city.setSize(currentPopulation + 1);
			city.resetFood();
		}
	}
}
