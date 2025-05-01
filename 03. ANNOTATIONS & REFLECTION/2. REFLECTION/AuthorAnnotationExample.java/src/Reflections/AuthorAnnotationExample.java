package Reflections;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "Jane Doe")
class Book {
    
}

public class AuthorAnnotationExample {
    public static void main(String[] args) {
        Class<Book> clazz = Book.class;

        if (clazz.isAnnotationPresent(Author.class)) {
           
            Author author = clazz.getAnnotation(Author.class);
            System.out.println("Author of Book class: " + author.name());
        } else {
            System.out.println("No @Author annotation found.");
        }
    }
}
