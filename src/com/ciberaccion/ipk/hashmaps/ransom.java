package com.ciberaccion.ipk.hashmaps;

import java.util.ArrayList;
import java.util.List;

public class ransom {

    public static void main(String[] args) {

//        List<String> magazine = new ArrayList<>() {{add("give");add("me");add("one");
//            add("grand");add("today");add("night");}};
//        List<String> note = new ArrayList<>() {{add("give");add("one");
//            add("grand");add("today");}};

        List<String> magazine = new ArrayList<>() {{add("two");add("times");add("three");
            add("is");add("not");add("four");}};
        List<String> note = new ArrayList<>() {{add("two");add("times");
            add("two");add("is");add("four");}};
        Result.checkMagazine(magazine, note);
    }
}

class Result {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
        // Write your code here
        boolean flag= true;
        for (int i = 0; i < note.size(); i++) {
            if (magazine.contains(note.get(i))){
                int finalI = i;
                magazine.removeIf(s -> s.equals(note.get(finalI)));
//                System.out.println(note.get(i));
                continue;
            } else {
//                System.out.println("NO");
                flag = false;
                break;
            }
        }
        if (flag)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

}