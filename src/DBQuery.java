
import java.awt.List;
import java.sql.*;
import java.util.ArrayList;



class DBQuery{

	private String usr;
	private String pwd;
	private String host;
	private Connection conn;
	private ArrayList item;
	private ArrayList category, catID;



	public DBQuery(String username,String password){
		usr = username;
		pwd = password;
		conn = null;
		host = "jdbc:mysql://localhost:3306/posadmin_pos";
		

	}

	public void setHost(String host){
		this.host = host;
	}

	public void connectDB(){
		try{
			Class.forName("com.mysql.jdbc.Driver") ;
			conn = DriverManager.getConnection( host, usr, pwd );
		}catch(Exception e){
			System.out.println(e.toString());
			return;
		}
	}



	public ResultSet select(String table,String row_query,String con){
		String query = "Select * from " + table + " where " + row_query + "='" + con + "'";
		String value = "";
		Statement statement;
		ResultSet rs = null;
		try{
			if(conn != null){
				statement = conn.createStatement();
				rs = statement.executeQuery(query);
			}
		}catch(Exception e){
			System.out.println(e.toString());
			
		}


		return rs;
	}
	
	
	
	public ArrayList getItem(String itemid){
		item = new ArrayList();
		String itm="";
		ResultSet rs = select("Item","code",itemid);
		try{
			while(rs.next()){
				itm = rs.getString("item");
				item.add(itm);
				itm = rs.getString("price");
				item.add(itm);
			}
		}catch(Exception e){
			
		}
		return item;	
	}
	
	ArrayList price;
	
	public ArrayList getPrice(String itemName){
		price = new ArrayList();
		String itm="";
		ResultSet rs = select("item","item",itemName);
		try{
			while(rs.next()){
				//itm = rs.getString("item");
				//price.add(itm);
				itm = rs.getString("price");
				price.add(itm);
			}
		}catch(Exception e){
			
		}
		return price;	
	}
	
	public boolean isLogin(String pwd){
		String val ="";
		ResultSet rs = select("staff","code",pwd);
		boolean isLogged = false;
		try {
				while(rs.next()){
					val = rs.getString("code");
				}
				if(val.equals(pwd)){
					isLogged = true;
				}
				rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return isLogged;
	}
	
	//ArrayList cID;
	
	public ArrayList getCategory(){
		category = new ArrayList();
		String cat="";
		String id="";
		ResultSet rs = selectCategory("category","category_id");
		try{
			while(rs.next()){
				cat = rs.getString("category_name");
				category.add(cat);
			}
		}catch(Exception e){
			
		}
		return category;
	}
	
	private ArrayList cid;
	
	public ArrayList getID(String cName){
		cid = new ArrayList();
		String c_id = "";
		ResultSet rs = select("category","category_name",cName);
		try{
			while(rs.next()){
				c_id = rs.getString("category_id");
				cid.add(c_id);
			}
			
		}catch(Exception e){
			
		}
		return cid;
	}
	
	public ArrayList getItemsByCategory(String catID){
		cid = new ArrayList();
		String item = "";
		ResultSet rs = select("item","cat_id",catID);
		try{
			while(rs.next()){
				item = rs.getString("item");
				cid.add(item);
			}
			
		}catch(Exception e){
			
		}
		return cid;
	}
		
	public ResultSet selectCategory(String table,String row_query){
		String query = "Select * from " + table + " where " + row_query;
		String value = "";
		Statement statement;
		ResultSet rs = null;
		try{
			if(conn != null){
				statement = conn.createStatement();
				rs = statement.executeQuery(query);
				
			}
		}catch(Exception e){
			System.out.println(e.toString());
			
		}


		return rs;
	}
	
	public String buildInsertQuery(String tablename,ArrayList column, ArrayList values){
		String query = "Insert into " + tablename+" (";
		
		for(int i = 0;i < column.size();i++){
			if(!(i == column.size()-1)){
				query +=column.get(i).toString() + ",";
			}else{
				query +=column.get(i).toString();

			}
		}
		query += ")values(";
		
		for(int i =0; i < values.size();i++){
			if(!(i == values.size()-1)){
				query +=values.get(i).toString() + ",";
			}else{
				query +=values.get(i).toString();
			}
		}
		query += ")";
		
		
		return query;
	}
	
	public void insertTransaction(String query){
		Statement statement;
		try{
			if(conn != null){
				statement = conn.createStatement();
				statement.executeUpdate(query);
			
			}
		}catch(Exception e){
			System.out.println(e.toString());
			
		}
		
	}
	
	public void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
		
	

}