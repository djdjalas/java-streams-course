package lectures;

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
    // 2. Then change implementation to find first 10 people

    List<Person> youngPeople = Lists.newArrayList();

    final int limit = 10;
    int counter = 0;

    for( Person person : people) {
      if(person.getAge() <= 18) {
        youngPeople.add(person);
        counter++;
        if(counter == limit) {
          break;
        }
      }
    }

    for (Person young : youngPeople) {
      System.out.println(young);
    }

  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    ImmutableList<Person> people = MockData.getPeople();

    List<Person> youngPeople = people.stream()
        .filter(person -> person.getAge() <= 18)
        .limit(10)
        .collect(Collectors.toList());

    youngPeople.forEach(System.out::println);

  }
}
