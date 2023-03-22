package be.pxl.exercise2;

import external.translator.Translator;

public class SmartDictionary {
    private final Translator translator;
    private final History history;

    public SmartDictionary(Translator translator, History history) {
        this.translator = translator;
        this.history = history;
    }

    public String lookUp(String word) {
        // lookup the word in history, if available, the translation is returned
        // if not available, the LookupFailedException is thrown,
        // the translator is used to translate the word, a TranslationResult is created and saved in history, and the translation
        // is returned.
        // if the translator throws the TranslationFailed exception, an LookupFailedException should be thrown by this lookup method
        return null;
    }
}