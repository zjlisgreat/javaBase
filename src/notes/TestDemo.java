package notes;
/**
 *@author zjl
 *2018年9月18日 上午12:14:54
 *使用continue跳出for循环异常，for循环是否继续执行
 */
public class TestDemo {
	public static void main(String[] args){
        for(int i=0;i<10;i++){
          try{
             System.out.println("i==========="+i);
             int k=i/0;
          }catch(Exception ex){
              ex.printStackTrace();
              System.out.println("ex======i====="+i +"===="+ex.getMessage());
              continue;
          }
        }
    }
}
