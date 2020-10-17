package hr.zemris.ppj.commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ENKA {

    private HashMap<PairState<Integer, Character>, ArrayList<Integer>> transitions;
    private int count = 0;
    private String startState;
    private String acceptableState;

    public ENKA() {

    }

    private int NewState() {
        count = count + 1;
        return count - 1;
    }

    private Boolean IsOperator(String exp, int idx) {
        int br = 0;
        while (idx - 1 >= 0 && exp.charAt(idx - 1) == '\\') {
            br++;
            idx = idx - 1;
        }
        return br % 2 == 0;
    }

    private int IdxGroup(String exp, int curr, int size) {
        if (size == 0)
            return 0;

        List<String> tmps = Arrays.asList(exp.split("|"));
        int res = exp.indexOf(tmps.get(size));

        if (res == -1)
            return 0;

        return res < curr ? res : 0;
    }

    public PairState<Integer, Integer> RegexToENKA(String regex) {
        ArrayList<String> choices = new ArrayList<>();

        int brackets = 0;
        int lastCut = 0;
        for (int i = 0; i < regex.length(); i++) {
            char curr = regex.charAt(i);

            if (curr == '(' && IsOperator(regex, i))
                brackets++;
            else if (curr == ')' && IsOperator(regex, i))
                brackets--;
            else if (brackets == 0 && curr == '|' && IsOperator(regex, i)) {
                lastCut = IdxGroup(regex, i, choices.size());
                choices.add(regex.substring(lastCut, i));
            }

        }

        if (choices.size() > 1)
            choices.add(regex.substring(lastCut, regex.length() - 1));

        int left = NewState();
        int right = NewState();

        if (choices.size() > 1) {
            for (int i = 0; i < choices.size(); i++) {
                PairState<Integer, Integer> tmp = RegexToENKA(choices.get(i));
                AddEpsilonState(left, tmp.left);
                AddEpsilonState(right, tmp.right);
            }
        } else {
            Boolean prefix = false;
            Integer last = left;

            for (int i = 0; i < regex.length(); i++) {
                Integer a, b;
                char curr = regex.charAt(i);

                if (prefix) {
                    char transition;
                    prefix = false;
                    if (curr == 't')
                        transition = '\t';
                    else if (curr == 'n')
                        transition = '\n';
                    else if (curr == '_')
                        transition = ' ';
                    else
                        transition = curr;

                    a = NewState();
                    b = NewState();
                    AddTransition(a, b, transition);
                } else {
                    if (curr == '\\') {
                        prefix = true;
                        continue;
                    }
                    if (curr != '(') {
                        a = NewState();
                        b = NewState();

                        if (curr == '$')
                            AddEpsilonState(a, b);
                        else
                            AddTransition(a, b, curr);
                        // 2b
                    } else {
                        int j = 0;
                        int brOpen = 0;
                        int brClose = 0;
                        for (int k = 0; k < regex.length(); k++) {

                            char currNew = regex.charAt(k);

                            if (i >= k) {
                                if (currNew == '(' && IsOperator(regex, k))
                                    brOpen++;
                            }
                            if (currNew == ')' && IsOperator(regex, k))
                                brClose++;
                            if (brClose == brOpen && brOpen != 0 && k > i) {
                                j = k;
                                break;
                            }

                        }
                        PairState<Integer, Integer> tmp = RegexToENKA(regex.substring(i + 1, j - 1));
                        a = tmp.left;
                        b = tmp.right;
                        i = j;
                    }
                }

                if (i + 1 < regex.length() && regex.charAt(i + 1) == '*') {
                    int x = a;
                    int y = b;
                    a = NewState();
                    b = NewState();
                    AddEpsilonState(a, x);
                    AddEpsilonState(y, b);
                    AddEpsilonState(a, b);
                    AddEpsilonState(y, x);
                    i = i + 1;
                }

                AddEpsilonState(last, a);
                last = b;
            }
            AddEpsilonState(last, right);
        }

        return new PairState<>(left, right);
    }

    private void AddEpsilonState(Integer left, Integer right) {
        AddTransition(left, right, '$');
    }

    private void AddTransition(Integer left, Integer right, Character transition) {
        PairState<Integer, Character> pair = new PairState(left, transition);
        ArrayList<Integer> tmp = transitions.get(pair);
        if (tmp == null)
            tmp = new ArrayList<>();
        tmp.add(right);
        transitions.replace(pair, tmp);
    }
}
