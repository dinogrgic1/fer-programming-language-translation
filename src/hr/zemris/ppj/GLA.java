package hr.zemris.ppj;

import hr.zemris.ppj.commons.ENKA;
import hr.zemris.ppj.commons.LangInputParser;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.TreeMap;

public class GLA {

    public static void main(String[] args) {
        LangInputParser lip = new LangInputParser("C:\\Users\\Dino\\dev\\FER\\PPJ\\test\\07_regex_regdefs\\test.lan");

        HashMap<String, String> dict = lip.GetRegExDict();
        HashMap<String, ENKA> automati = new HashMap<>();

        for (var reg : lip.lexRules.entrySet()) {
            var rule = reg.getKey().getFirst();
            var expression = reg.getKey().getSecond();

            var enka = automati.get(rule);
            if (enka != null) {
                enka.RegexToENKA(expression);
                automati.replace(rule, enka);
            } else {
                enka = new ENKA();
                enka.RegexToENKA(expression);
                automati.put(rule, enka);
            }
        }

        ArrayList<String> lines = new ArrayList<>();


        String start = "HashMap<String, HashMap<Pair<Integer, Character>, ArrayList<Integer>>> transitions = new HashMap<> () {{";
        String ruleTrans2 = ", new HashMap<>() {{ ";
        String ruleTrans3 = "}})";
        String end = "}};";
        String stateTrans3 = " }});";


        String first = "put(new Pair";
        String second = ", new ArrayList<>() {{ ";
        String third = "}});";

        for (var rule : automati.entrySet()) {
            String ruleString = "\"" + rule.getKey() + "\"";
            String ruleTrans1 = "put(";
            ruleTrans1 += ruleString;
            ruleTrans1 += ruleTrans2;

            var transitions = rule.getValue().getTransitions();
            for (var state : transitions.entrySet()) {
                String pair = state.getKey().toString();

                String stateTrans1 = "put(new Pair";
                stateTrans1 += pair;

                String stateTrans2 = ", new ArrayList<>(){{ ";
                for(var transition : transitions.get(state.getKey())) {
                    String transString = "add(" + transition + ");";
                    stateTrans2 += transString;
                }

                stateTrans1 += stateTrans2;
                stateTrans1 += stateTrans3;

                ruleTrans1 += stateTrans1;
            }

            ruleTrans1 += ruleTrans3;
            start += ruleTrans1;
        }

        start += end;
        System.out.println(start);

    }
}
