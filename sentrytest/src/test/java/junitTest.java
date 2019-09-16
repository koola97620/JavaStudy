import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import sentrytest.MyClass;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

public class junitTest {

    MyClass myClass = Mockito.mock(MyClass.class);

    @Test
    public void test() {


    }
}
