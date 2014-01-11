
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Calculator {
	private ArrayList<String> numdata;
	private String itemname;
	private float discount;
	private float discounted;
	private float total;
	private float totalAfterDiscount;
	public Calculator(){
		numdata = null;
		itemname = "";
		discount = 0;
		total = 0;
	}
	
	public float total(ArrayList list){
		float val = 0;
		for(int i =0;i < list.size();i++){
			val += Float.valueOf(list.get(i).toString());
			
		}
		return val;
	}
	public double deduct(){
//		float val = 0;
//		for(int i = 0; i < list.size(); i++)
//		{
//			val += Float.valueOf(list.get(i).toString());
//		}
//		
    	return 0;
	}
	
	
	public float getChange(JTable table,float pay){
		numdata = new ArrayList<String>();
		String discountVal = "";

		 DefaultTableModel model = (DefaultTableModel) table.getModel();
	        for (int count = 0; count < model.getRowCount(); count++){
	        	itemname = model.getValueAt(count, 0).toString();
	        	if(itemname.equals("Discount Amount")){
	        		discountVal =  model.getValueAt(count, 1).toString();
	        		discount = Float.valueOf(discountVal);
	        		
	        	}else{
		              numdata.add(model.getValueAt(count, 1).toString());	
	        	}
	              
	        }
	        
	        total = total(numdata);
	        total = pay - (total - discount);
	
			return total;

	}
	
	
	public float getDiscount(float discountAmount){

		String tot = AppUI.getTotal();
		if (tot != "")
		{
			tot = tot.replaceAll("[^0-9.]", "");
			float total = Float.parseFloat(tot);
			
			totalAfterDiscount = ((total / 100) * discountAmount);
			totalAfterDiscount = total - totalAfterDiscount;
		}
		return totalAfterDiscount;
		
	}
	
}
