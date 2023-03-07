package centuri.test_maven;



public class Field {
	//Coordonées de points //
	private Double xField;
	private Double yField;

	

	public Field(Double xField, Double yField) {
		this.xField = xField;
		this.yField = yField;
		
	}
	
	
	public Double getxField() {
		return this.xField;
	}
	
	public Double getyField() {
		return this.yField;
	}
	
	
	public void setxField(Double xField) {
		this.xField = xField;
	}
	
	public void setyField(Double yField) {
		this.yField = yField;
	}
	
	
	
}
