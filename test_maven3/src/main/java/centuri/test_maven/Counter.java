package centuri.test_maven;

import java.util.ArrayList;

public class Counter {
	
	int sum_coordinate;
	
	public Counter (int sum_coordinate) {
		this.sum_coordinate = sum_coordinate;
	}
	
	public int get_Counter () {
		return this.sum_coordinate;
	}
	
	public void set_Counter (int sum_coordinate) {
		this.sum_coordinate=sum_coordinate;
	}
	
	public void add_Counter(int coordinate) {
		this.sum_coordinate = this.sum_coordinate + coordinate;
	}
	
	public void less_Counter(int coordinate) {
		this.sum_coordinate = this.sum_coordinate - coordinate;
	}

}
