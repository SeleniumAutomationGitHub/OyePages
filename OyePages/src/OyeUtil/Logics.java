package OyeUtil;

public class Logics {
	
	public static boolean compStr (String str, String str2){
		
		if(str !=null && str2 !=null){
			
			if(str.equalsIgnoreCase(str2)){
				return true;
			}
		}
		return false;
	}

	
	public static void main(String[] args) {
		boolean state = compStr("NULL", null);
		System.out.println(state);
	}

}
