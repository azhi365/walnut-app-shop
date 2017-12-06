import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class BaseTestCase {
    @Test
    public void md5() throws Exception {
        String x = DigestUtils.md5Hex("testCode1-DTU-20170925-000068e8f64bff-9060-49de-a06e-2646af9701a7");
        System.out.println(x);
    }
}
