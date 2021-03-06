package co.edu.unal.alife.dynamics;

import java.util.Set;

/**
 * @author Juan Figueredo
 * 
 *         Abstract class that implements common functionality of DeltaPopulation implementations, such as toString,
 *         nextPopulation accesors, and updatePopulationDelta.
 * 
 */
public abstract class AbstractDeltaPopulation implements DeltaPopulation {
	private DeltaPopulation	nextPopulation;
	
	@Override
	public DeltaPopulation getNextPopulation() {
		return nextPopulation;
	}
	
	@Override
	public void setNextPopulation(DeltaPopulation nextPopulation) {
		this.nextPopulation = nextPopulation;
	}
	
	@Override
	public boolean hasNextPopulation() {
		return (nextPopulation != null) ? true : false;
	}
	
	@Override
	public String toString() {
		Set<Double> positions = this.getPositions();
		StringBuffer sb = new StringBuffer();
		for (Double position : positions) {
			sb.append(this.getElementValue(position));
			sb.append("\t");
		}
		return sb.toString();
	}
}
