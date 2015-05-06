import java.util.ArrayList;

public class ListTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("111111");
        list.add("111111");
        list.add("111111");
        list.remove("111111");
        System.out.println(list.size());
        /*
         * for (int i = 0; i < list.size(); i++) { list.remove(""); }
         */
    }
}
