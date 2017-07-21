package lectures;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture11 {

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

    String join = "";

    for(String name : names) {
      join += name + ", ";
    }

    System.out.println(join.substring(0, join.length()-2));

  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

    String join = names.stream()
        .map(String::toUpperCase)
        .collect(Collectors.joining("|"));

    System.out.println(join);
  }
}
