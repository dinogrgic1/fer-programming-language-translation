package hr.zemris.ppj.commons;

import java.io.*;
import java.util.*;

public class LangInputParser {

    private ArrayList<String> fileContent;
    private List<String> lexStates;
    private List<String> lexTokens;
    public HashMap<Pair<String, String>, ArrayList<String>> lexRules;
    private HashMap<String, String> regExDict = new HashMap<>();

    public LangInputParser(String filePath) {
        try {
            fileContent = LangInputParser.ReadFileAsString(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.ParseFile();
    }

    private void ParseFile() {
        int part = 0;
        String data = "";

        for (String line : fileContent) {
            if (part == 0 && line.contains("%X ")) {
                part = 1;
            } else if (part == 1 && line.contains("%L ")) {
                part = 2;
            } else if (part == 2 && line.contains("<")) {
                part = 3;
            } else if (part == 4 && fileContent.get(fileContent.size() - 1) == line) {
                part = 5;
            }

            switch (part) {
                case 0:
                    data += line;
                    data += "\n";
                    break;
                case 1:
                    this.regExDict = RegExParse(data);
                case 2:
                    this.lexStates = LexerStateParse(line);
                    data = "";
                    part = 3;
                    break;
                case 3:
                    this.lexTokens = LexerTokenParse(line);
                    data = "";
                    part = 4;
                    break;
                case 4:
                    data += line;
                    data += "\n";
                    break;
                case 5:
                    data += line;
                    this.lexRules = LexerRulesParse(data);
                default:
                    break;
            }
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

    private List<String> LexerStateParse(String data) {
        data = data.replace("%X ", "");
        var states = Arrays.asList(data.split(" "));
        return states;
    }

    private List<String> LexerTokenParse(String data) {
        data = data.replace("%L ", "");
        var states = Arrays.asList(data.split(" "));
        return states;
    }

    private HashMap<Pair<String, String>, ArrayList<String>> LexerRulesParse(String data) {
        HashMap<Pair<String, String>, ArrayList<String>> dict = new HashMap<>();
        List<String> lines = Arrays.asList(data.split("\n"));

        Pair ps = new Pair("", "");
        ArrayList<String> array = new ArrayList<>();

        boolean read = false;
        for(String line : lines) {
            if(line.contains("<")) {
                ps = new Pair(line.substring(1, line.indexOf(">")), line.substring(line.indexOf(">") + 1));
            }

            if(line.contains("{")) {
                read = true;
            } else if(line.contains("}")) {
                dict.put(ps, array);
                read = false;
                ps = new Pair("", "");
                array = new ArrayList<>();
            } else if(read) {
                array.add(line);

            }
        }
        return dict;
    }


    public HashMap<String, String> GetRegExDict() {
        return regExDict;
    }

    public static ArrayList<String> ReadFileAsString(String filePath) throws IOException {
        ArrayList<String> file = null;
        try {
            InputStream is = new FileInputStream(filePath);
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));

            file = new ArrayList<>();
            String line = buf.readLine();
            while (line != null) {
                file.add(line);
                line = buf.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return file;
    }
}
