package Annotations;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

public class CacheHandler implements InvocationHandler {
    private final Object target;
    private final Map<String, Object> cache = new HashMap<>();

    public CacheHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(CacheResult.class)) {
            String key = method.getName() + "_" + (args != null ? args[0] : "null");

            if (cache.containsKey(key)) {
                System.out.println("Returning cached result for: " + key);
                return cache.get(key);
            }

            Object result = method.invoke(target, args);
            cache.put(key, result);
            System.out.println("Computed and cached result for: " + key);
            return result;
        } else {
            return method.invoke(target, args);
        }
    }
}
