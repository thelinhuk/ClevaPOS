
import java.sql.Time;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import jpos.*;

public class Print {
	POSPrinterControl113 ptr;
	CashDrawerControl113 draw;
	public final int MAX_LINE_WIDTHS = 2;

	
	public Print(){
		ptr = (POSPrinterControl113)new POSPrinter();
		draw = (CashDrawerControl113)new CashDrawer();
		try {
			//Open the device.
			//Use the name of the device that connected with your computer.
			ptr.open("POSPrinter");
			draw.open("CashDrawer");
		
			//Enable the device.
			draw.claim(1000);
			ptr.claim(1000);
			
			//Enable the device.
			draw.setDeviceEnabled(true);
			ptr.setDeviceEnabled(true);
		}
		catch(JposException ex) {
			System.out.println(ex.toString());
		}
		
		try{
			ptr.setMapMode(POSPrinterConst.PTR_MM_METRIC);
			ptr.setRecLetterQuality(true);

			
		}catch(JposException ex){}
		
	
	}
	
	
	public void printReceipt(String brand,String tel,String addr,String change,String paid,String totalStr,
			ArrayList<String> itemname,ArrayList<String> itemprice,String dateTime,String UUID){
		DateFormat df = DateFormat.getDateInstance();
		Time t = new Time(System.currentTimeMillis());
		String time = df.format(Calendar.getInstance().getTime()) + " " + t.toString() + "\n";
		int[] RecLineChars = new int[MAX_LINE_WIDTHS];
		long lRecLineCharsCount;
		String printData = "";
		
		
		try {
			if(ptr.getCapRecPresent() == true){
				ptr.transactionPrint(POSPrinterConst.PTR_S_RECEIPT, POSPrinterConst.PTR_TP_TRANSACTION);
				ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|200uF");
				lRecLineCharsCount = getRecLineChars(RecLineChars);
				String CharLists = ptr.getRecLineCharsList();
				String aCharList[] = new String[MAX_LINE_WIDTHS];
				
				ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|cA" +  brand +"\n");
				ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT,  "\u001b|cA" + addr +"\n");
				ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|cA" + tel +"\n");
				ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\n");
				
				ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|cA" + time);
				
				ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\n");
				
				ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "------------------------------------------------");
				ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\n");

				for(int i =0;i < itemname.size();i++){
					printData = makePrintString(ptr.getRecLineChars(),itemname.get(i), "£"+ itemprice.get(i) );
					ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, printData + "\n");

				}
				
				ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "------------------------------------------------");
				printData = makePrintString(ptr.getRecLineChars(),"Total: ", "\u001b|bC\u001b|2C" + "£"+ totalStr+"\n" );
				ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, printData);
				printData = makePrintString(ptr.getRecLineChars(),"Customer's payment: ", "£"+ paid + "\n" );
				ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, printData);
				printData = makePrintString(ptr.getRecLineChars(),"Change: ", "£"+ change );
				ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, printData  + "\n");
				
				ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "Transaction ID:"  + "\n\n");
				
				ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT,  "\u001b|cA" +"Thank you for visting us"  + "\n");



				ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|200uF");
				ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|500uF");





				
				ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|fP");
				ptr.transactionPrint(POSPrinterConst.PTR_S_RECEIPT, POSPrinterConst.PTR_TP_NORMAL);
				this.close();
				
				draw.openDrawer();
				System.out.println("HELLO");
				// Wait during opend drawer.
				while(draw.getDrawerOpened() == false){
					Thread.sleep(100);
				}
				this.closeDraw();

				//When the drawer is not closed in ten seconds after opening, beep until it is closed.
				//If  that method is executed, the value is not returned

			}


		}
		catch(JposException ex) {
			System.out.println(ex.toString());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void closeDraw(){
		try{
			//Cancel the device
			draw.setDeviceEnabled(false);

			//Release the device exclusive control right.
			draw.release();

			//Finish using the device.
			draw.close();
		}
		catch(JposException ex){
		}
	}
	
	public String makePrintString(int lineChars,String text1,String text2){
		int spaces = 0;
		String tab = "";
		try{
			spaces = lineChars - (text1.length() + text2.length());
			for (int j = 0 ; j < spaces ; j++){
				tab += " ";
			}
		}
		catch(Exception ex){
		}
		return text1 + tab + text2;
	}
	
	private long getRecLineChars(int[] RecLineChars) throws JposException
	{
		long lRecLineChars = 0;
        long lCount;
        int i;

        // Calculate the element count.
        String[] temp = ptr.getRecLineCharsList().split(",");
        lCount = temp[0].length();

        if(lCount == 0) {
            lRecLineChars = 0;
        } 
        else {
            if (lCount > MAX_LINE_WIDTHS)
            {
                lCount = MAX_LINE_WIDTHS;
            }

			for( i = 0; i < lCount; i++) {
                RecLineChars[i] = Integer.parseInt(temp[i]);
         	}

            lRecLineChars = lCount;
     	}

        return lRecLineChars;
	}
	
	public void close(){
		try{
			//Cancel the device.
			ptr.setDeviceEnabled(false);

			//Release the device exclusive control right.
			ptr.release();

			//Finish using the device.
			ptr.close();
		}
		catch(JposException ex){
		}
		
	}

}
