public interface TextProcessor {
    String process(String inputSequence);

    int regexCount(String inputSequence);

    String regexRemove(String inputSequence);

    String regexReplace(String inputSequence);

    String[] regexFind(String inputSequence);

    String getTemplate();

    String getRegex();

    String[] get10Examples();
}