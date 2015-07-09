import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Driver Class
 * mostly gui stuff
 * @author Shakeeb saleh
 * ID: 109239204
 *
 */
public class DataSetViewer extends JFrame{
	/**
	 * A) Add a data source  Prompt for the name of the csv file and the name of the data set, create a DataSet object, and add it to the end of the list. 
	 *  If the user does not specify a name, use the DataSet constructor that infers the name from the filename 
	 *  (if the user hits enter without typing anything at the prompt for the data sets name, your input reader will return an empty string). 
	 *  Display the name of the data set and the computed statistics upon completion.
	 * N) Sort by name  Create a DataSetNameComparator object and use it to sort the list of data sets, then print out the list.
	 * R) Sort by row - Create a DataSetNumRowsComparator object and use it to sort the list of data sets, then print out the list.
	 * V) Sort by average  Prompt for a column number, then create a DataSetRaceAverageComparator for that race and use it to sort the list of data sets, then print out the list. 
	 *  Print an error message if the given column is out of bounds.
	 * G) Get data  Prompt the user to enter the position of the data set to access (in the current sort order), 
	 *  the row number within that data set to access, and print the corresponding cars model name and time in each race.
	 * E) exit
	 */

	
	JButton addSource = new JButton("Add a new source");
	JButton sortByName = new JButton("Sort the DataSets by Name");
	JButton sortByRow = new JButton("Sort the DataSets by Row");
	JButton sortByAverage = new JButton("Sort the DataSets by Average");
	JButton getData = new JButton("Get Data");
	JButton exit = new JButton("Exit System");
	
	ArrayList<DataSet> dataSets = new ArrayList<DataSet>();
	
	public DataSetViewer(){
		this.setSize(400,600);
		this.setLayout(new GridLayout(6,1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.add(addSource);
		this.add(sortByName);
		this.add(sortByRow);
		this.add(sortByAverage);
		this.add(getData);
		this.add(exit);
		
		addSource.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){activate(1);}});
		sortByName.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){activate(2);}});
		sortByRow.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){activate(3);}});
		sortByAverage.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){activate(4);}});
		getData.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){activate(5);}});
		exit.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){activate(6);}});
		
		setVisible(true);
	}
	
	public void activate(int option){
		switch(option){
			case 1:{ // add a data source
				String filename = JOptionPane.showInputDialog("What is the Filename of the CSV file?");
				String name = JOptionPane.showInputDialog("What do you wish to name your file?");
				if (name.equals("")){
					DataSet johnLennon = new DataSet(filename);
					dataSets.add(johnLennon);
					JOptionPane.showMessageDialog(null, "Great Success! \n" + johnLennon.toString());
				} else {
					DataSet paulMcCartney = new DataSet(filename, name);
					dataSets.add(paulMcCartney);
					JOptionPane.showMessageDialog(null, "Great Success! \n" + paulMcCartney.toString());
				}
				//System.out.print("i found it!");
				break;
			}
			case 2:{ // sort by name
				DataSetNameComparator ringoStarr = new DataSetNameComparator();
				int i, j, minLocation;
				for(i=0; i<=dataSets.size() ;i++){
					minLocation = i;
					for(j=i+1; j<=dataSets.size()-1; j++){
						if((ringoStarr.compare(dataSets.get(j), dataSets.get(minLocation))) < 0)
							minLocation = j;
					Collections.swap(dataSets, minLocation, j);
					}
				}
			JOptionPane.showMessageDialog(null, dataSets.toString());
			break;
			}
			case 3:{ // sort by row
				DataSetNumRowsComparator georgeHarrison = new DataSetNumRowsComparator();
				DataSet holder = new DataSet();
				int i, j, minLocation;
				for(i=0; i<=dataSets.size() ;i++){
					minLocation = i;
					for(j=i+1; j<=dataSets.size()-1; j++){
						if((georgeHarrison.compare(dataSets.get(j), dataSets.get(minLocation))) < 0)
							minLocation = j;
						Collections.swap(dataSets, minLocation, j);
					}
				}
			JOptionPane.showMessageDialog(null, dataSets.toString());
			break;	
			}
			case 4:{ // sort by race average
				int race = Integer.parseInt(JOptionPane.showInputDialog("Please input, from 1 to 5, which race average you'd like to use as a basis"));
				DataSetRaceAverageComparator jayz = new DataSetRaceAverageComparator(race);
				DataSet holder = new DataSet();
				int i, j, minLocation;
				for(i=0; i<=dataSets.size() ;i++){
					minLocation = i;
					for(j=i+1; j<=dataSets.size()-1; j++){
						if((jayz.compare(dataSets.get(j), dataSets.get(minLocation))) < 0)
							minLocation = j;
						Collections.swap(dataSets, minLocation, j);
					}
				}
			JOptionPane.showMessageDialog(null, dataSets.toString());
			break;	
			}
			case 5:{ // getData 
				int numbah = Integer.parseInt(JOptionPane.showInputDialog("enter the position of the data you would like to access:"));
				String bloo = dataSets.get(numbah).toString();
				JOptionPane.showMessageDialog(null, bloo);
				break;
			}
			case 6:{// exit
				System.exit(0);
			}
		} // end of switch
	}
	
	public static void main(String[] args){
		DataSetViewer theBeatles = new DataSetViewer();
	}
}
