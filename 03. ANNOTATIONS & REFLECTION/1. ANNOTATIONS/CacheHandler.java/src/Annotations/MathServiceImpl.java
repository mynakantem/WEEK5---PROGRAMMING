package Annotations;

public class MathServiceImpl implements MathService {

    @Override
    public long factorial(int n) {
        System.out.println("Calculating factorial for " + n);
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}

