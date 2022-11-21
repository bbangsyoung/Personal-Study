import java.util.Scanner;

public class Q7_gaussianIntegral {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //a부터 b까지의 합을 구하자(가우스의 덧셈 사용)
        System.out.print("a을 입력해주세요 >> ");
        int a = scan.nextInt();
        System.out.print("b을 입력해주세요 >> ");
        int b = scan.nextInt();

        //일단 둘 중 작은 수를 앞에, 큰 수를 뒤로 해야함.
//        int temp[] = {a, b};
//        if(a > b) {
//            temp[0] = b; //temp[0]이 늘 작은 수
//            temp[1] = a;
//        }

        //int sum = (n + 1) * (n / 2) + (n % 2 == 1 ? (n + 1) / 2 : 0);   // 총합
        //int sum = (temp[1] + temp[0]) * (temp[1] / (temp[0]+1)) + (temp[1] % 2 == 1 ? (temp[1] + temp[0]) / 2 : 0);

        float sum = (a + b) * (b - a + 1) / 2;
        System.out.println((int) sum);
    }
}


