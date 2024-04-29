package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ExcelColumnNumber {

	public static void main(String[] args) {
		int col = titleToNumber("AB");

	}
	
    public static int titleToNumber(String columnTitle) {
        
        
        Map<Character,Integer> titleMap = new HashMap<>();
        int colNumber = 26;
        
        titleMap.put('A',1);
        titleMap.put('B',2);
        titleMap.put('C',3);
        titleMap.put('D',4);
        titleMap.put('E',5);
        titleMap.put('F',6);
        titleMap.put('G',7);
        titleMap.put('H',8);
        titleMap.put('I',9);
        titleMap.put('J',10);
        titleMap.put('K',11);
        titleMap.put('L',12);
        titleMap.put('M',13);
        titleMap.put('N',14);
        titleMap.put('O',15);
        titleMap.put('P',16);
        titleMap.put('Q',17);
        titleMap.put('R',18);
        titleMap.put('S',19);
        titleMap.put('T',20);
        titleMap.put('U',21);
        titleMap.put('V',22);
        titleMap.put('W',23);
        titleMap.put('X',24);
        titleMap.put('Y',25);
        titleMap.put('Z',26);
        
        if(columnTitle.length() == 1) return titleMap.get(columnTitle.charAt(0));
        
        else{
            int length = columnTitle.length()-1;
            for(int i = length-1; i >=0; i--){
                colNumber = colNumber * titleMap.get(columnTitle.charAt(i));
            }
            colNumber = colNumber + titleMap.get(columnTitle.charAt(length));
        }
        
        return colNumber;

    }
}


