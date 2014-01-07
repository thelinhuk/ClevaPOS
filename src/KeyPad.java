

import java.util.HashMap;
import java.util.Iterator;


public class KeyPad {
	private String btnText;
	private String txtVal;
	private String strAfterDec;
	private int dotIndex;
	private HashMap<String, Integer> hmap;
	
	
	public KeyPad(){
		hmap = new HashMap();
		strAfterDec = "";
		dotIndex = 0;
		txtVal = "";
		
		for(int i =0; i < 10;i++){
			hmap.put(Integer.toString(i), new Integer(i));
		}
		hmap.put("0.00", new Integer(10));
		hmap.put(".", new Integer(11));

		
	
		
	}
	
	public String Clear(){
		
		return "";
	}
	
	public String Delete(){
	
		return "";
	}
	
	
	public String operate(String str,String curStr){
		String displayStr = "";
		dotIndex =curStr.indexOf(".");
		btnText = str;
		txtVal = curStr;
		if(isNumber(str) && notEmpty(str,curStr) && curStr.length() < 9){
			if(txtVal.equals("0.00") && !str.equals(".")){
				txtVal = "";
				txtVal = txtVal + btnText;
				displayStr = txtVal;
			}else{ 
				if(dotIndex < 0){
					txtVal = txtVal + btnText;
					displayStr = txtVal;
				}else if(dotIndex > 0){
					if(!btnText.equals(".")){
						txtVal = txtVal + btnText;
					}
					strAfterDec = txtVal.substring(dotIndex+1,txtVal.length());
					if(strAfterDec.length() > 2){
						txtVal = txtVal.substring(0,txtVal.length()-1);
					}
									
					displayStr = txtVal;
	
				}
			}
		}else if(str.equals("Clear")){
			displayStr = "";
			curStr = "";
			
		}else if(str.equals("Delete")){
			if(curStr.length() > 0){
				displayStr = curStr.substring(0,curStr.length()-1);
				
			}
		
			
		}else if(str.equals("£ 5")){
			displayStr = "5.00";
		}else if(str.equals("£ 10")){
			displayStr = "10.00";
		}else if(str.equals("£ 20")){
			displayStr = "20.00";
		}else if(str.equals("£ 50")){
			displayStr = "50.00";
			
		}else{
			if(!curStr.equals("")){
				displayStr = curStr;
			}
		}
		
		return displayStr;
	}
	
	public String validateSearch(String btnText, String curString){
		if(btnText.length() == 1){
			char ch = btnText.charAt(0);
			if(ch  > 47 && ch < 58){
				curString += btnText;
			}
		}
		
		if(btnText.equals("Delete")){
			if(curString.length() > 0){
				curString = curString.substring(0,curString.length()-1);
				
			}
			
		}else if(btnText.equals("Clear")){
			curString = "";
			btnText = "";
		}
		
		return curString;
	}
	
	
	private boolean notEmpty(String btnText,String curStr){
		if(btnText.equals(".") && curStr.equals("")){
			return false;
		}else{
			return true;
		}
	}
	
	private boolean isNumber(String str){
		if(hmap.containsKey(str)){
			return true;
		}else{
			return false;
		}
		
	}
	
}
