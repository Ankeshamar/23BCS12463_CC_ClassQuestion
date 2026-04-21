import java.util.*;
class prefixsubarray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }  
        int prefixSum = 0;
        for(int i=0;i<n;i++){
            prefixSum += arr[i];
            System.out.print(prefixSum + " ");
        }
    }
}