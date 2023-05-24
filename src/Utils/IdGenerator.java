package Utils;

public class IdGenerator {
    private static IdGenerator INSTANCE;
    private Integer code = 0;

    /*The default constructor is private*/
    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new IdGenerator();
        }
        return INSTANCE;
    }

    public Integer getNextCode() {
        this.code = this.code + 1;
        return this.code;
    }
}
