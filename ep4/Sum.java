
import java.lang.Integer;

public class Sum {
    public static Sum _s = null;

    public static void main(String[] args){
        int i;
        int[] v = new int[args.length];

        _s = new Sum();

        for (i = 0; i < args.length; i++) {
            v[i] = Integer.parseInt(args[i]);
        }

        System.out.println(_s.computeVectorSum(v));
    }

    public int computeVectorSum (int[] v) {
        int i = 0;
        int sum = 0;
        while (i < v.length) {
            sum += v[i++];
        }
        return sum;
    }
}
