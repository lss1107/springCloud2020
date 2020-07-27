import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.ZonedDateTime;

@SpringBootTest
public class ZonedDateTimeTest
{
    @Test
    public void ZonedDateTime(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }
}
