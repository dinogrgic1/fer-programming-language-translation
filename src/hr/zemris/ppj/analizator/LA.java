package hr.zemris.ppj.analizator;

import hr.zemris.ppj.commons.ENKA;
import hr.zemris.ppj.commons.Pair;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LA {

    public static void main(String[] args) {


    }


    // program simulator
    public LA(String fileName, ENKA enka) {
        try (FileReader fr = new FileReader(fileName)) {
            int content;

            ArrayList<Integer> Q = new ArrayList<>();
            ArrayList<Integer> R = new ArrayList<>();
            Integer first = 0;
            R.add(0);

            while ((content = fr.read()) != -1) {

                Character input = (char) content;
                ArrayList<Integer> intersection = new ArrayList<>(R);
                intersection.retainAll(enka.getAcceptableState());

                if (intersection.size() == 0 && R.size() != 0) {
                    Q = R;
                    for (Integer q : Q) {
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp = enka.ETransition(new Pair<Integer, Character>(q, input));
                        for (Integer r : tmp)
                            R.add(r);
                    }
                } else if (intersection.size() != 0) {
                    first = intersection.get(0);
                    Q = R;
                    for (Integer q : Q) {
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp = enka.ETransition(new Pair<>(q, input));
                        for (Integer r : tmp)
                            R.add(r);
                    }
                } else if (R.size() == 0) {
                    if (first == 0)
                        System.out.println(content);
                    else
                        first = 0;
                    R = enka.ETransition(new Pair<>(0, '$'));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
