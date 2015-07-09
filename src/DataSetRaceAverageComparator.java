import java.util.Comparator;

public class DataSetRaceAverageComparator implements Comparator<DataSet>{
	int raceNumber;
	public DataSetRaceAverageComparator(int i){
		raceNumber = i;
	}
	public int compare(DataSet first, DataSet second){
		double wakaflocka = first.getSingleRaceAverage(raceNumber);
		double asaprocky = second.getSingleRaceAverage(raceNumber);
		return (int)(wakaflocka - asaprocky);
	}
	public boolean equals(Object obj){
		if(obj instanceof DataSetRaceAverageComparator){
			DataSetRaceAverageComparator bleh = (DataSetRaceAverageComparator)obj;
			if(this.raceNumber == bleh.getRaceNumber())
				return true;
		}
		return false;
	}
	
	public int getRaceNumber(){
		return raceNumber;
	}

}
