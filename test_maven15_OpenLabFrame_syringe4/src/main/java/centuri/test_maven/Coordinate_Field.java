package centuri.test_maven;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultListModel;



public class Coordinate_Field {
	Field myField;
	Double [] tx;
	Double [] ty;
	Double A1_x= 1.4;
	Double A1_y= 5.4;
	Double A1_z = 35.0;
		
	public Coordinate_Field (Field myField) {
		this.myField = myField;
		this.tx = new Double[myField.getColumn()+1];
		this.ty = new Double[myField.getRow()+1];
		this.coordinate();
	}

	public void setField (Field myField) {
		this.myField = myField;
	}
	    
	public Field get_myField () {
		return this.myField;
	}
	
	public void set_A1_x (Double A1_x) {
		this.A1_x= A1_x;
	}
	
	public Double get_A1_x() {
		return this.A1_x;
	}
	
	public void set_A1_y (Double A1_y) {
		this.A1_y= A1_y;
	}
	
	public Double get_A1_y() {
		return this.A1_y;
	}
	
	public void set_A1_z (Double A1_z) {
		this.A1_z= A1_z;
	}
	
	public Double get_A1_z() {
		return this.A1_z;
	}
	
	void coordinate() {
		
		// nombre de colonne
		int column = myField.getColumn();
		
		// nombre de ligne
		int row = myField.getRow();
		
		// Point A1 en x
		//A1_x; = 1.4; //((myField.getxField()/column)/2); // = 2
		
		// Point A1 en y 
		//A1_y; // = 5.4; //((myField.getyField()/row)/2)+(((myField.getyField()/row))*(row-1)); // = 2 + 4 * (2-1)
				
		//Boucle pour récuppérer les coordonnées du x et du y en fontion des puits
		for (int r = 1; r < this.ty.length; r ++) {
			Double y = A1_y - ((myField.getyField()/row)*(r-1));
			ty[r]= y;
			
			for (int c = 1; c < this.tx.length; c ++) {
				Double x = A1_x + ((myField.getxField()/column)*(c-1)); 
				tx[c]= x;
				//System.out.println(x+" ; "+y);
			}	
		}
	}
	
	public int get_r (String well) {
		char[] array = well.toCharArray();
		char [] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		int r = Arrays.binarySearch(alphabet, array[0]) + 1;
		return r;	
	}
	
	public int get_c (String well) {
		char[] array = well.toCharArray();
		char [] chiffre = {'0','1','2','3','4','5','6','7','8','9'};
		int c = Arrays.binarySearch(chiffre, array[1]);
		return c;
	}
	
	public Double [] get_tx () {
		return this.tx;
	}
	
	public Double [] get_ty () {
		return this.ty;
	}
	
	public Double get_x_coordinate (int c) {
		Double x = this.tx[c];
		return x;
	}
	
	public Double get_y_coordinate (int r) {
		Double y = this.ty[r];
		return y;
	}
		 
	public Double well_x_coordinate (String well) {
		int c = this.get_c(well);
		Double x = this.tx[c];
		return x;
	}
	
	public Double well_y_coordinate (String well) {
		int r = this.get_r(well);
		Double y = this.ty[r];
		return y;
	}
	
	public void apply_all(DefaultListModel<String> listData, ArrayList<Event> data, Arduino myArduino ) {
		
		ArrayList wellName = new ArrayList();
		wellName.add("A1");
		wellName.add("A2");
		wellName.add("A3");
		wellName.add("B1");
		wellName.add("B2");
		wellName.add("B3");
		
		int count = 5;
		int size = listData.getSize();
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < size; j++) {
				listData.addElement(listData.getElementAt(j));
				data.add(data.get(j + 1));
			}
		}

		int l = 0;
		for (int k = 0; k < listData.getSize(); k++) {
			if (listData.getElementAt(k).toString().contains("A1") == true) {
				listData.remove(k);
				listData.add(k, wellName.get(l).toString());
				double coordinate_x = (get_x_coordinate(get_c(wellName.get(l).toString()))
						* 10);
				double coordinate_y = (get_y_coordinate(get_r(wellName.get(l).toString()))
						* 10);
				double coordinate_z = 35.0;
				data.set(k + 1, new Mouvement(coordinate_x, coordinate_y, coordinate_z, myArduino));
				l++;
			}
		}

	}
	
	
}