package Annotations;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        MathService mathService = (MathService) Proxy.newProxyInstance(
            MathService.class.getClassLoader(),
            new Class<?>[]{MathService.class},
            new CacheHandler(new MathServiceImpl())
        );

        System.out.println("Result: " + mathService.factorial(5));
        System.out.println("Result: " + mathService.factorial(5)); // Should use cache
        System.out.println("Result: " + mathService.factorial(4)); // New computation
    }
}
