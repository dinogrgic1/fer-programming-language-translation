package hr.zemris.ppj;

import hr.zemris.ppj.commons.ENKA;
import hr.zemris.ppj.commons.LangInputParser;

import java.util.Dictionary;
import java.util.HashMap;

public class GLA {

    public static void main(String[] args) {
        LangInputParser lip = new LangInputParser("C:\\Users\\Dino\\OneDrive - fer.hr\\FER\\5.semestar\\Prevođenje programskih jezika\\labosi\\Slozenija inacica\\Lab 1\\sloz_lab_1_integration[1]\\integration\\minusLang.lan");

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
    }
}
