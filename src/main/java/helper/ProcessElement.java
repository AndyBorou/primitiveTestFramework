package helper;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;

public class ProcessElement {

    public static List<String> getValue(List<WebElement> webElements) {
        return webElements.stream().map(element -> element.getAttribute("value")).collect(Collectors.toList());
    }
}
