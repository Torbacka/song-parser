package data;

import org.junit.Test;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class INDataTest {

    @Test
    public void parsingTest() {
        INData inData = new INData("");
        assertThat(inData.getSongs().getSong()).hasSize(143);
    }
}
