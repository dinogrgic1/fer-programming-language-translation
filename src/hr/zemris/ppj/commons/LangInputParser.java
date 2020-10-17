package hr.zemris.ppj.commons;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LangInputParser {

    private HashMap<String, String> RegExDict = new HashMap<>();

    public LangInputParser(String fileName) {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            int part = 0;
            String data = "";
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (part == 0 && line.contains("%X ")) {
                    part = 1;
                } else if (part == 1 && line.contains("%L ")) {
                    part = 2;
                } else if (part == 2 && line.contains("<")) {
                    part = 3;
                } else {
                    // error
                }

                switch (part) {
                    case 0:
                        data += line;
                        data += "\n";
                        break;
                    case 1:
                        RegExParse(data);
                        data = "";
                        break;
                    case 2:
                        LexerStateParse(line);
                        data = "";
                        break;
                    case 3:
                        LexerTokenParse(line);
                        data = "";
                        break;
                    case 4:
                        LexerRulesParse(line);
                        data = "";
                        break;
                    default:
                        break;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    private static HashMap<String, String> RegExParse(String data) {
        HashMap<String, String> dict = new HashMap<>();
        List<String> lines = Arrays.asList(data.split("\n"));

        for (String line : lines) {
            String[] arr = line.split(" ");
            dict.put(arr[0], arr[1]);
        }

        for (Map.Entry<String, String> right : dict.entrySet()) {
            for (Map.Entry<String, String> left : dict.entrySet()) {
                if (right.getValue().contains(left.getKey())) {
                    var key = left.getKey().replaceAll("\\{", "\\\\{");
                    key = key.replaceAll("\\}", "\\\\}");
                    var tmp = right.getValue().replaceAll(key, "(" + left.getValue() + ")");
                    dict.replace(right.getKey(), tmp);
                }
            }
        }
        return dict;
    }

    private void LexerTokenParse(String line) {
    }

    private void LexerRulesParse(String line) {
    }

    private void LexerStateParse(String line) {
    }


}
