package practice_V2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class sasa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  List<String> arrayList = new ArrayList<String>();
	      arrayList.add("a");
	      arrayList.add("b");
	      arrayList.add("c");
	      arrayList.add("f");
	      arrayList.add("d");
	      arrayList.add("e");
	 System.out.println(arrayList.toString());
	 Collections.reverse(arrayList);
	 System.out.println(arrayList);
	 Collections.sort(arrayList);
	 System.out.println(arrayList);
	 Iterator<String> it = arrayList.iterator();
	 while(it.hasNext()) {
		 System.out.println(it.next());
	 }
//	      Iterator<String> it = arrayList.iterator(); String str = "";
//	      while (it.hasNext()) {
//	    	  str = (String) it.next();
//	    	  System.out.print(str);
//	          if (str.equals("f")) {
//	             it.remove();
//	            // break;
//	          }
//	      }
	}

}
