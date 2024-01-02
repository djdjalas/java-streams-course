package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    final  Predicate<Car> carPredicate = car -> car.getPrice() < 1000;
    List<Car> carsFiltered = cars.stream()
            .filter(carPredicate)
            .collect(Collectors.toList());

    System.out.println(carsFiltered);
    System.out.println(carsFiltered.size());

  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();

   List<PersonDTO> dtos=  people.stream()
            .map(person->{
              PersonDTO dto= new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
              return dto;
            })
            .collect(Collectors.toList());

   // as PersonDTO has map method, above can be refactored as below PersonDTO::map => method reference
    List<PersonDTO> dtosWithMethodReference= people.stream()
                    .map(PersonDTO::map)
                    .collect(Collectors.toList());

    dtosWithMethodReference.forEach(System.out::println);



   dtos.forEach(System.out::println);
   assertThat(dtos).hasSize(1000);

  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices

    double average= MockData.getCars()
            .stream()
            .mapToDouble(Car::getPrice)
            .average()
            .orElse(0);
    System.out.println(average);

  }

  @Test
  public void test() throws Exception {

  }
}



