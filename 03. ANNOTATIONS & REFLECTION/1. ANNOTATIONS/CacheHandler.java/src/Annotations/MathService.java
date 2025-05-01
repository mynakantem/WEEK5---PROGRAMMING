package Annotations;

public interface MathService {
    @CacheResult
    long factorial(int n);
}

