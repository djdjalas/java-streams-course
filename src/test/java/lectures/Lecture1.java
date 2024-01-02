package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;


public class Lecture1 {

  @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();
    // 1. Find people aged less or equal 18
    for(Person person : people){
      if(person.getAge()<=18){
        //System.out.println(person.toString());
      }
    }

    // 2. Then change implementation to find first 10 people
    List <Person> first10YoungPeople= Lists.newArrayList();
    int limit=10;
    int counter=0;
    for(Person person : people){
      if(counter<limit){
        if(person.getAge()<=18){
          first10YoungPeople.add(person);
          counter++;
        }
      }

    }

    for (Person person: first10YoungPeople){
      System.out.println(person.toString());
    }

  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    ImmutableList<Person> people = MockData.getPeople();

    List<Person>youngPeople=people.stream()
            .filter(person -> person.getAge()<=18)
            .collect(Collectors.toList());
    /*
    for(Person p : youngPeople){
      System.out.println(p);
    }

     */

    List<Person> first10YoungPeople= people.stream()
            .filter(person -> person.getAge()<=18)
            .limit(10)
            .collect(Collectors.toList());

    first10YoungPeople.forEach(System.out::println);

    // Or
    people.stream()
            .filter(person -> person.getAge()<=10)
            .collect(Collectors.toList())
            .forEach(System.out::println);


  }
}
