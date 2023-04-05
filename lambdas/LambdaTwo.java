package lambdas;

import java.util.Arrays;
import java.util.List;

public class LambdaTwo {
    

    public static void main(String[] args)
    {
        List<Person> people = Arrays.asList(
            new Person("1OnePerson", "Nielsen", 17),
            new Person("2TwoPerson", "Jensen", 12),
            new Person("3ThreePerson", "Hansen", 84),
            new Person("4FourPerson", "Pedersen", 92),
            new Person("5FivePerson", "Thomsen", 76),
            new Person("6SixerPerson", "Torensen", 23),
            new Person("9NinerPerson", "Torgensen", 53)
        );

        System.out.println("All people whose last name starts with an T");
        printNames(people, (k) -> k.getLastName().startsWith("T"));

        System.out.println();
        System.out.println("All people whose 1st first name's character mod 2 is zero. Or All people whose first name number is odd");
        printNames(people, (k) -> {
            String[] floatInName = new String[1];
            boolean isEven = false;
            floatInName = k.getFirstName().split("[^\\d]");
            try
            {
                isEven = (Float.parseFloat(floatInName[0]) - 1) % 2 == 0;
            }
            catch(NumberFormatException nfe)
            {
                System.out.println("Hey, the first character of the first name must be a float");
            }
            return isEven;
        });
    }

    public static void printNames(List<Person> people, Condition condition)
    {
        for (Person p : people)
        {
            if (condition.test(p))
            {
                System.out.println(condition.test(p));
            }
        }
    }
}
