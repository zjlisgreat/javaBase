package collection.cases;

import java.util.ArrayList;
import java.util.List;

/**
 *集合使用subList分页
 */
public class CollectionSubList {
	
	private static final int DEFAULT_PAGECOUNT = 10;
	private static final int DEFAULT_PAGESIZE = 1;

    public static List<List<Integer>> paging(List<Integer> list, int pageSize) {
        int totalCount = list.size();
        int pageCount;
        int m = totalCount % pageSize;

        if (m > 0) {
            pageCount = totalCount / pageSize + 1;
        } else {
            pageCount = totalCount / pageSize;
        }

        List<List<Integer>> totalList = new ArrayList<List<Integer>>();
        for (int i = 1; i <= pageCount; i++) {
            if (m == 0) {
                List<Integer> subList = list.subList((i - 1) * pageSize, pageSize * (i));
                totalList.add(subList);
            } else {
                if (i == pageCount) {
                    List<Integer> subList = list.subList((i - 1) * pageSize, totalCount);
                    totalList.add(subList);
                } else {
                    List<Integer> subList = list.subList((i - 1) * pageSize, pageSize * i);
                    totalList.add(subList);
                }
            }
        }

        return totalList;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < 52; i++) {
            list.add(i);
        }

//        List<List<Integer>> totalList = paging(list, 10);
//        System.out.println(totalList);
        
        List<Integer> resList = page(list, 10, 0);
        System.out.println(resList);
    }
    
    
    /**
     * @param list 集合数据 
     * @param pageCount 每页条数
     * @param pageSize 页码(第几页)
     * @return
     */
    public static List<Integer> page(List<Integer> list,int pageCount,int pageSize){
    	if(pageCount <= 0) {
    		pageCount = DEFAULT_PAGECOUNT;
    	}
    	if(pageSize <= 0) {
    		pageSize = DEFAULT_PAGESIZE;
    	}
    	int total = list.size();
    	int m = total % pageCount > 0 ? total/pageCount +1 : total/pageCount;
    	if(pageSize > m ) {
    		return new ArrayList<Integer>();
    	}
    	int start = (pageSize-1) * pageCount;
    	int end = start + pageCount > total ? total : start+pageCount;
    	return list.subList(start, end);
    }
    
    
    
}