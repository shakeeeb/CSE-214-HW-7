import big.data.DataSource;
import big.data.DataSourceIterator;

import java.util.ArrayList;
/**DataSet class
 * ID: 109239204
 * @author Shakeeb Saleh
 *
 */
public class DataSet {
	/**
	 * rawData contains the raceresults of all cars
	 * name is the name of the dataset
	 * average is the one-indexed array of averages
	 */
	private ArrayList<RaceResult> rawData = new ArrayList<RaceResult>();
	private String name = "";
	private double[] average = new double[6]; // one-indexed
	/**
	 * empty constructor
	 */
	public DataSet(){
	}
	/**
	 * Overloaded Constructor
	 * @param csvFilename - the filename of the csv file
	 * @param name
	 */
	public DataSet(String csvFilename, String name){
		this.name = name;
		DataSource ds = DataSource.connectCSV(csvFilename);
		ds.load();
		DataSourceIterator iter = ds.iterator();
		
		double onetotal = 0, twototal = 0, threetotal = 0, fourtotal = 0, fivetotal = 0;
		while(iter.hasData()){
			RaceResult daniel = new RaceResult();
			onetotal += iter.fetchDouble("race1"); 
			twototal += iter.fetchDouble("race2");
			threetotal += iter.fetchDouble("race3"); 
			fourtotal += iter.fetchDouble("race4");
			fivetotal += iter.fetchDouble("race5");
			double[] times = {iter.fetchDouble("race1"), iter.fetchDouble("race2"), iter.fetchDouble("race3"), iter.fetchDouble("race4"), iter.fetchDouble("race5") };
			daniel.setModel(iter.fetchString("model"));
			System.out.print("i found it!");
			daniel.setTimes(times);
			rawData.add(daniel);
			iter.loadNext();
		} 
		average[1] = onetotal/rawData.size();
		average[2] = twototal/rawData.size();
		average[3] = threetotal/rawData.size();
		average[4] = fourtotal/rawData.size();
		average[5] = fivetotal/rawData.size();
	}
	/**
	 * Overloaded Constructor 
	 * which infers the name from the filename
	 * @param csvFilename
	 */
	public DataSet(String csvFilename){
		this.name = csvFilename.substring(0, csvFilename.indexOf('.'));
		DataSource swagMaster = DataSource.connectCSV(csvFilename);
		swagMaster.load();
		DataSourceIterator iter = swagMaster.iterator();
		double onetotal = 0, twototal = 0, threetotal = 0, fourtotal = 0, fivetotal = 0;
		while(iter.hasData()){
			RaceResult moocow = new RaceResult();
			double[] times = {iter.fetchDouble("race1"), iter.fetchDouble("race2"), iter.fetchDouble("race3"), iter.fetchDouble("race4"), iter.fetchDouble("race5") };
			onetotal += iter.fetchDouble("race1"); 
			twototal += iter.fetchDouble("race2");
			threetotal += iter.fetchDouble("race3"); 
			fourtotal += iter.fetchDouble("race4");
			fivetotal += iter.fetchDouble("race5");
			moocow.setModel(iter.fetchString("model"));
			moocow.setTimes(times);
			rawData.add(moocow);
			iter.loadNext();
		} 
		average[1] = onetotal/rawData.size();
		average[2] = twototal/rawData.size();
		average[3] = threetotal/rawData.size();
		average[4] = fourtotal/rawData.size();
		average[5] = fivetotal/rawData.size();
	}
	/**
	 * getResult
	 * returns the RaceResult at the specfied row
	 * @param i
	 * @return
	 */
	public RaceResult getResult(int i){
		return rawData.get(i);
	}
	/**
	 * numrows
	 * returns the number of rows
	 * @return
	 */
	public int numRows(){
		return rawData.size();
	}
	/**
	 * toString
	 * returns al info in the form of a string
	 */
	public String toString(){
		String result = name + " \n";
		result += "Number of Rows: " + rawData.size() + " \n";
		result += "Average of First Race: " + average[1] + " \n";
		result += "Average of Second Race: " + average[2] + " \n";
		result += "Average of Third Race: " + average[3] + " \n";
		result += "Average of Fourth Race: " + average[4] + " \n";
		result += "Average of Fifth Race: " + average[5] + " \n";
		return result;
	}
	/**
	 * setName
	 * sets name to new name
	 * @param newName
	 */
	public void setName(String newName){
		name = newName;
	}
	/**
	 * just getters for all instance variables
	 * @return
	 */
	public ArrayList<RaceResult> getRawData(){
		return rawData;
	}
	public String getName(){
		return name;
	}
	public double[] getAverages(){
		return average;
	}
	public double getSingleRaceAverage(int i){
		return average[i];
	}

}
