import java.util.Comparator;

public class DataSetNameComparator implements Comparator<DataSet>{
	
	public DataSetNameComparator(){
	}
	
	public int compare(DataSet first, DataSet second){
		String terriermon = first.getName();
		String veemon = second.getName();
		return terriermon.compareToIgnoreCase(veemon);
	}
	
	public boolean equals(Object obj){
		if(obj instanceof DataSetNameComparator){
			return true;
		}
		return false;
	}

}
