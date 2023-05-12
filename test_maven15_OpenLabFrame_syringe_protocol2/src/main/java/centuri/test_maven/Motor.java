package centuri.test_maven;

public class Motor {
	double x_y_axis_max_rate;
	double x_y_acceleration;
	
	public Motor (double x_y_axis_max_rate, double x_y_acceleration) {
		this.x_y_axis_max_rate = x_y_axis_max_rate;
		this.x_y_acceleration = x_y_acceleration;
	}
	
	public int time (double AB) {
		int time;
		double acceleration_deceleration_time = (((x_y_axis_max_rate/60)/x_y_acceleration)*2);
		double d1 = (x_y_axis_max_rate/60) * acceleration_deceleration_time;
		if (AB <= d1) {
			time = (int) Math.round(acceleration_deceleration_time);
		} else {
			time = (int) Math.round((acceleration_deceleration_time + ((AB - d1) / (x_y_axis_max_rate/60))));
		}
			return time;
		
		}

}
