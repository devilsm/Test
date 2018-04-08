import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.omg.PortableInterceptor.Interceptor;

public class PhoneNum {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Map<String,Integer> pn = new TreeMap<String,Integer>();
		
		int length = 0;
		if(in.hasNext()){
			length=in.nextInt();
		}
		for(int i=0; i<length; i++){
			String s = in.next().replace("-", "");
			StringBuilder sb = new StringBuilder();
			
			for(int j=0; j<s.length(); j++){
				char c = getNum(s.charAt(j));
				if(Character.isDigit(c)){
					sb.append(c);
				}
			}
			String result = sb.substring(0, 3) + "-" + sb.substring(3);
			if(pn.containsKey(result)){
				int count = pn.get(result) + 1;
				pn.put(result, count);
			} else {
				pn.put(result, 1);
			}
		}
		
		Set<String> se = pn.keySet();
		Iterator it = se.iterator();
		boolean flag = false;
		while (it.hasNext()){
			String s = it.next().toString();
			int count = pn.get(s);
			if(count > 1) {
				flag = true;
				System.out.println(s + " " + count);
			} 
		}
		if (!flag) {
			System.out.println("No duplicates. ");
		}
	}
	
	public static char getNum(char c) {
		if(Character.isDigit(c)){
			return c;
		}
		if(c=='A' || c=='B' || c=='C'){
			return '2';
		}
		if(c=='D' || c=='E' || c=='F'){
			return '3';
		}
		if(c=='G' || c=='H' || c=='I'){
			return '4';
		}
		if(c=='J' || c=='K' || c=='L'){
			return '5';
		}
		if(c=='M' || c=='N' || c=='O'){
			return '6';
		}
		if(c=='P' || c=='R' || c=='S'){
			return '7';
		}
		if(c=='T' || c=='U' || c=='V'){
			return '8';
		}
		if(c=='W' || c=='X' || c=='Y'){
			return '9';
		}
		return '#';
	}
}
