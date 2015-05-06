package filetest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestMap {
    public static void main(String[] args) {
        Map<Set<String>, Set<String>> map = new HashMap<Set<String>, Set<String>>();
        Set<String> key = new HashSet<String>();
        Set<String> value = new HashSet<String>();
        key.add("111");
        key.add("222");
        key.add("223");
        value.add("222");
        value.add("212");
        value.add("122");
        map.put(key, value);
        System.out.println(map.get(key).toString().replace("[", "").replace("]", ""));
    }
}
