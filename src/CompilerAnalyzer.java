import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.*;

public class CompilerAnalyzer {
    static List<String> lines = new ArrayList<>();

    public String[] saveLines(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines.toArray(new String[0]);
    }

    public static String preprocessCode(String code) {
        return code.replaceAll("[,\\[\\]]", "");
    }

    public static boolean lexicalAnalyzer(String code) {
        // Preprocess the code
        code = preprocessCode(code);

        String tokenRegex = "\\b(INT|FLO|DOU|BOO|CHA|LON|SHO|BYT|STR)\\b|"
                + "[a-zA-Z_][a-zA-Z_0-9]*|\\d+|\\+|\\-|\\*|/|=|;|\\(|\\)|'[^']'|true|false|\"[^\"]*\"";
        Pattern pattern = Pattern.compile(tokenRegex);
        Matcher matcher = pattern.matcher(code);

        while (matcher.find()) {
            String token = matcher.group();
            System.out.println("Lexical Token: " + token);
        }

        String remainingCode = code.replaceAll(tokenRegex, "").trim();
        return remainingCode.isEmpty();
    }

    public static boolean syntaxAnalyzer(String code) {
        code = preprocessCode(code);

        String syntaxRegex = "\\b(INT|FLO|DOU|BOO|CHA|LON|SHO|BYT|STR)\\b [a-zA-Z_][a-zA-Z_0-9]*"
                + "( = (\\d+|true|false|'[^']'|\\d+\\.\\d+|\"[^\"]*\"))?;";
        Pattern pattern = Pattern.compile(syntaxRegex);
        String[] statements = code.split(";");
        for (String statement : statements) {
            if (!statement.trim().isEmpty() && !pattern.matcher(statement.trim() + ";").matches()) {
                System.out.println("Syntax Error: Invalid statement -> " + statement.trim());
                return false;
            }
        }
        return true;
    }

    public static boolean semanticAnalyzer(String code) {
        code = preprocessCode(code);

        Set<String> declaredVariables = new HashSet<>();
        String[] lines = code.split(";");
        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;

            if (line.matches("\\b(INT|FLO|DOU|BOO|CHA|LON|SHO|BYT|STR)\\b [a-zA-Z_][a-zA-Z_0-9]*.*")) {
                String varName = line.split(" ")[1].split("=")[0].trim();
                declaredVariables.add(varName);
            } else if (line.contains("=")) {
                String varName = line.split("=")[0].trim();
                if (!declaredVariables.contains(varName)) {
                    System.out.println("Semantic Error: Variable '" + varName + "' used before declaration.");
                    return false;
                }
            }
        }
        return true;
    }
}
