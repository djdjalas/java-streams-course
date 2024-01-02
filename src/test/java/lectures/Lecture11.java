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

    String joinedString=" ";
    for(String name: names){
      joinedString +=name +", ";
    }
    System.out.println(joinedString.substring(0,joinedString.length()-2));

  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

    // without stream
    String sentence1= String.join(", ", names);
    // with stream
    String sentence2 = names.stream().collect(Collectors.joining(", "));
    System.out.println(sentence2);

  }
}
