package centuri.test_maven;

import java.util.ArrayList;

public class Counter {
	
	Double sum_coordinate;
	
	public Counter (Double sum_coordinate) {
		this.sum_coordinate = sum_coordinate;
	}
	
	public Double get_Counter () {
		return this.sum_coordinate;
	}
	
	public void set_Counter (Double sum_coordinate) {
		this.sum_coordinate=sum_coordinate;
	}
	
	public void add_Counter(Double coordinate) {
		this.sum_coordinate = this.sum_coordinate + coordinate;
	}
	
	public void less_Counter(Double coordinate) {
		this.sum_coordinate = this.sum_coordinate - coordinate;
	}

}
