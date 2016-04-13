package OyeUtil;

public class Logics {
	
	public static boolean compStr (String str, String str2){
		
		try{
			if(str !=null && str2 !=null){
				
				if(str.equalsIgnoreCase(str2)){
					return true;
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("Null can't be acceptable");
		}
		return false;
	}

	
	public static void main(String[] args) {
		boolean state = compStr("NULL", null);
		System.out.println(state);
		
		
		String s1 = "Hello";
		String s2 = new String(s1);
		//String s2 = "Hello";
		
		if(s1 == s2){
			System.out.println("Pointing to same object");
		}else{
			System.out.println("Not Pointing to same object");
		}
		
		if(s1.equals(s2)){
			System.out.println("Data same");
		}else{
			System.out.println("Data Not Same");
		}
	}

}
