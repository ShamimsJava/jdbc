package urmi.sum;

public class SumExample {
    
    public static void sum1(int x, int y){
        int z = x+y;
        System.out.println("The sum is: "+z);
    }
    
    public static int sum2(int x, int y){
        int z = x + y;
        return z;
    }
    
    public static void main(String[] args) {
        sum1(5,5);
        //System.out.println("The sum is: "+sum2(15,5));
        System.out.println(sum2(15,5)+100);
        int ur = sum2(15,5);
        //int sh = sum1(10,5);
    }
}
