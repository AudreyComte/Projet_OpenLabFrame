package centuri.test_maven;

public class Motor2 {
	double x_y_axis_max_rate= 100.0;
	double x_y_acceleration= 1000.0;
	
	public int time (double AB) {
		int time;
		double acceleration_deceleration_time = (((x_y_axis_max_rate/60)/x_y_acceleration)*2);
		double d1 = (x_y_axis_max_rate/60) * acceleration_deceleration_time;
		if (AB <= d1) {
			time = (int) Math.round(acceleration_deceleration_time);
		} else {
			time = (int) Math.round((acceleration_deceleration_time + ((AB - d1) / x_y_axis_max_rate/60)));
		}
			return time;
		
		}


}
