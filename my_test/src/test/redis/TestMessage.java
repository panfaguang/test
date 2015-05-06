package test.redis;

import java.io.Serializable;

public class TestMessage implements Serializable {
    //
    private static final long serialVersionUID = 1L;
    private String name = "test";

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
