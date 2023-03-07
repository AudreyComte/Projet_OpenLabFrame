package centuri.test_maven;



public class Head {
	// Coordonnées de point//
	double xHead;
	double yHead;
	double zHead;
	Double[]coordinate_head;
	
	public Head (double xHead, double yHead, double zHead) {
		this.xHead = xHead;
		this.yHead = yHead;
		this.zHead = zHead;
		this.coordinate_head = new Double[] {this.xHead, this.yHead, this.zHead};
	}
	
	
	public Double getxHead() {
		return this.xHead;
	}
	
	public Double getyHead() {
		return this.yHead;
	}
	
	public Double getzHead() {
		return this.zHead;
	}
	
	
	public void setxHead(Double xHead) {
		this.xHead = xHead;
	}
	
	public void setyHead(Double yHead) {
		this.yHead = yHead;
	}
	
	public void setzHead(Double zHead) {
		this.zHead = zHead;
	}
	
	
	
	public Double [] set_coordinate_head(Double xHead, Double yHead, Double zHead) {
		coordinate_head [0] = xHead;
		coordinate_head [1] = yHead;
		coordinate_head [2] = zHead;
		return coordinate_head;
	}
	
	public Double [] set_xy_coordinate_head(Double xHead, Double yHead) {
		coordinate_head [0] = xHead;
		coordinate_head [1] = yHead;
		return coordinate_head;
	}
	
	public Double [] get_coordinate_head() {
		return coordinate_head;
	}
	
	public Double get_Pos_x_Head(){
		return coordinate_head [0];
	}
	
	public Double get_Pos_y_Head(){
		return coordinate_head [1];
	}
	
	public Double get_Pos_z_Head(){
		return coordinate_head [2];
	}
	
	
	public void initializationPos0 () {
		coordinate_head [0] = 0.0;
		coordinate_head [1] = 0.0;
		coordinate_head [2] = 0.0;
	}

	
	public Double forward_xHead (Double forw) {
		return coordinate_head [0] = coordinate_head [0]+ forw;
	}
	
	public Double forward_yHead (Double forw) {
		return coordinate_head [1] =coordinate_head [1]+ forw;
	}
	
	public Double forward_zHead (Double forw) {
		return coordinate_head [2] =+ forw;
	}
	
	public Double set_x_Head (Double xHead){
		return coordinate_head [0] = xHead;
	}
	
	public Double set_y_Head (Double yHead){
		return coordinate_head [1] = yHead;
	}
	
	public Double set_z_Head (Double zHead){
		return coordinate_head [2] = zHead;
	}

}

