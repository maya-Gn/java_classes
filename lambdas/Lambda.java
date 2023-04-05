package lambdas;

import java.util.Arrays;
import java.util.List;
/** The solution version I did by myself*/
public class Lambda {
   public static void main(String[] args){
       List<Person> people = Arrays.asList(
           new Person("Charles", "Dickens", 60),
           new Person("Lewis", "Carroll", 42),
           new Person("Thomas", "Carlyle", 51),
           new Person("Charlotte", "Bronte", 45),
           new Person("Matthew", "Arnold", 39)
       );
       // Step 2: Create a method that prints all elements in the list
       System.out.println("Printing all persons");
       printPeople(people, (k) -> true);
       System.out.println();
       // Step 3: Create a method that prints all people that have last name beginning with C
       System.out.println("Printing all persons with last name beginning with D");
       printPeople(people, (k) -> k.getLastName().startsWith("D"));
   }
   private static void printPeople(List<Person> pList, Condition condOne){
       // The reason that we passed a lambda to this function is that we intend to us it,
       // so we use it here.
       for(Person p: pList){
           if(condOne.test(p)){ // See notes below
               System.out.println(p);
           }
       }
   }
}
/** NOTES
* CondOne.test(p)
* CondOne = the object that contains/houses the lambda that was passed
  into the printPeople() function.
* note that the implementation of that lambda has a return type
  namely: a boolean.
*
* CondOne.test(): .test() is the method specified in the Condition
  interface. Since the method header has boolean as the return type,
  the lambda passed as "condOne" MUST return a boolean.
*      * So for example, we can System.out.println(condOne.test(p)).
*        which will print to the output: true or false.
* In the 2nd call to printPeople() .test() =
  (k) -> k.getLastName().startsWith("C") which returns a boolean.
* I think this is what is meant by we can change the implementation
  of the function defined in the interface.
       * So for example if test() specified to return a number
       when can do condOne.test(p) *(times) 4
*
*/

