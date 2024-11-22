import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main implements TextProcessor {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("Drozdov");
        System.out.println("Determine if the words in the sequence are identifiers\r\n" + //
                "Given a sequence of words. For each word print \"true\" or \"false\",\r\n" + //
                "depending on whether it is an identifier, i.e. starts with English\r\n" + //
                "letters in any case or underscore and does not contain any other symbols,\r\n" + //
                "except for letters of the English alphabet (in any register), numbers and a sign\r\n" + //
                "underlining.\r\n" + //
                "Example: input sequence \"_user 7user User2020\", exit - \"true false true\"");
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the first text to be processed: ");
        String s1 = scan.nextLine();
        System.out.println(main.process(s1));

        System.out.println("Template: " + main.getTemplate());
        System.out.println("Regular expression: " + main.getRegex());
        System.out.println("10 words of examples: " + Arrays.toString(main.get10Examples()));
        System.out.print("Enter the second text to be processed: ");

        String s2 = scan.nextLine();
        System.out.println("The number of words that match the pattern: " + main.regexCount(s2));
        System.out.println("An array of these words: " + Arrays.toString(main.regexFind(s2)));
        System.out.println("Text in which all words matching the pattern are deleted: " + main.regexRemove(s2));
        System.out.println(
                "Text in which all words that match the pattern are replaced with a sequence of five asterisks: "
                        + main.regexReplace(s2));

        System.out.println("Termination of work");
    }

    @Override
    public String process(String inputSequence) {
        String regex = "[a-zA-Z_][\\w]*";
        String[] words = inputSequence.split("\\s+");

        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.matches(regex)) {
                result.append("true ");
            } else {
                result.append("false ");
            }
        }

        return result.toString().trim();
    }

    @Override
    public int regexCount(String inputSequence) {
        int n = 0;
        Pattern p = Pattern.compile("\\d{2}-\\d[a-z]");
        Matcher m = p.matcher(inputSequence);
        while (m.find()) {
            n++;
        }
        return n;
    }

    @Override
    public String regexRemove(String inputSequence) {
        Pattern p = Pattern.compile("\\d{2}-\\d[a-z]");
        Matcher m = p.matcher(inputSequence);
        String s = m.replaceAll("");
        return s;
    }

    @Override
    public String regexReplace(String inputSequence) {
        Pattern p = Pattern.compile("\\d{2}-\\d[a-z]");
        Matcher m = p.matcher(inputSequence);
        String s = m.replaceAll("*****");
        return s;
    }

    @Override
    public String[] regexFind(String inputSequence) {
        int i = 0;
        String[] massiv = new String[regexCount(inputSequence)];
        Pattern p = Pattern.compile("\\d{2}-\\d[a-z]");
        Matcher m = p.matcher(inputSequence);
        while (m.find()) {
            massiv[i] = m.group();
            i++;
        }
        return massiv;
    }

    @Override
    public String getTemplate() {
        String s = "##-#α";
        return s;

    }

    @Override
    public String getRegex() {
        String s = "\\d\\d-\\d[a-z]";// ##-#α;
        return s;
    }

    @Override
    public String[] get10Examples() {
        String[] examples = new String[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            StringBuilder example = new StringBuilder();

            char c = (char) ('a' + random.nextInt(26));

            example.append(random.nextInt(10));
            example.append(random.nextInt(10));
            example.append('-');

            example.append(random.nextInt(10));
            example.append(c);

            examples[i] = example.toString();
        }
        return examples;
    }

}
