package ProgIII.aula2.list;

import java.util.ArrayList;
import java.util.Iterator;

public class list {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Ivairton");
        list.add("Maxwell");
        list.add("Linder");
        list.add("Anthony");
        list.add("Robson");

        Iterator i = list.iterator();
        while (i.hasNext()) {
            String name = (String)i.next();
            System.out.println(name);
        }

        list.remove("Anthony");

        i = list.iterator();

        System.out.println();
        
        while(i.hasNext()) {
            String name = (String)i.next();
            System.out.println(name);
        }
    }
}