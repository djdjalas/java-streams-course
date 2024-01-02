package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;

public class Lecture4 {

  @Test
  public void distinct() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);

    List<Integer> distinctNumbers=  numbers.stream()
            .distinct()
            .collect(Collectors.toList());

    assertThat(distinctNumbers).hasSize(9);
    System.out.println(distinctNumbers);

  }

  @Test
  public void distinctWithSet() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);

   //  Set<Integer> distinctSet= new HashSet<>(numbers);
    Set<Integer> distinctSet = numbers.stream().collect(Collectors.toSet()); // can be replaced with HasSet like above

    assertThat(distinctSet).hasSize(9);
    System.out.println(distinctSet);

  }
}
