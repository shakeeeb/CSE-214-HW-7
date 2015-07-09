
/**
 * RaceResult Class
 * ID: 109239204
 * @author Shakeeb Saleh
 *
 */
public class RaceResult {
	private String model = "";
	private double[] times = new double[5];
	
	/**
	 * default Constructor
	 */
	public RaceResult(){
		
	}
	/**
	 * Overloaded Constructor
	 * @param times
	 * @param model
	 */
	public RaceResult(double[] times, String model){
		setModel(model);
		setTimes(times);
	}
	/**
	 * set Times
	 * @param newTimes
	 */
	public void setTimes(double[] newTimes){
		for(int i =0; i< newTimes.length-1; i++){
			times[i] = newTimes[i];
		}
	}
	/**
	 * get times
	 * @return
	 */
	public double[] getTimes(){
		return times;
	}
	/**
	 * set model
	 * @param modelName
	 */
	public void setModel(String modelName){
		this.model = modelName;
	}
	/**
	 * get model
	 * @return
	 */
	public String getModel(){
		return model;
	}
	
	public String toString(){
		String result = model + ": ";
		result += " " + times[0] + ", " + times[1] + ", " + times[2] + ", " + times[3] + ", " + times[4] +".";
		return result;
	}
	

}
