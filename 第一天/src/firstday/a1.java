package firstday;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class a1 {
public static void main(String[] args) {
	Map<String , String> map=new HashMap<String, String>();
	map.put("kye1","1");
	map.put("key2","2");
	map.put("key3","3");
	for( Map.Entry<String, String> entry : map.entrySet()) {
		System.out.println(entry.getKey()+"="+entry.getValue());
	}
}
}
