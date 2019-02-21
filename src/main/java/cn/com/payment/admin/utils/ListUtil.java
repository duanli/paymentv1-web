package cn.com.payment.admin.utils;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
	public static <T> List<List<T>> splitList(List<T> list, int pageSize) {  
	    int total = list.size();  
	    //总页数  
	    int pageCount = total % pageSize == 0 ? (total / pageSize) : (total / pageSize + 1);  
	    List<List<T>> result = new ArrayList<List<T>>(); 
	    for(int i = 0; i < pageCount; i++) {  
	        int start = i * pageSize;  
	        //最后一条可能超出总数  
	        int end = (start + pageSize) > total ? total : (start + pageSize);  
	        List<T> subList = list.subList(start, end);  
	        result.add(subList);
	    }  
	    return result;  
	}  
}
