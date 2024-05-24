package day1;
import java.util.Random;
import java.util.stream.Collectors;
 
 
public class RandomStringGenerator {
    public static String generateRandomString(int length) {
        return new Random().ints(48, 58)
                           .limit(length)
                           .mapToObj(i -> (char) i)
                           .map(Object::toString)
                           .collect(Collectors.joining());
    }
 
    public static void main(String[] args) {
       
        System.out.println("Random 10-Digit String: " + randomString);
    }
}