public class Ex4 {

    public void func(int x, int n){
        int mySign = -1;
        double sum = 0;
        for(int i = 1; i <= n; i++){
            sum += (Math.pow(x,i*2) / (this.calcFactorial(i)))*mySign;
            mySign *= -1;
        }

        System.out.println("answer = " + sum);
    }

    private int calcFactorial(int x){
        int result = 1;

        for (int i = 1; i <= x; i++) {
            result *= i;
        }
        return result;
    }
}
