import java.util.Comparator;

public class DataSetNumRowsComparator implements Comparator<DataSet>{
	public DataSetNumRowsComparator(){
		
	}
	public int compare(DataSet first, DataSet second){
		int swagbeast = first.numRows();
		int swagmonster = second.numRows();
		return swagbeast - swagmonster;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof DataSetNumRowsComparator){
			return true;
		}
		return false;
	}

}
