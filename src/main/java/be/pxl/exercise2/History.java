package be.pxl.exercise2;

public interface History {

    TranslationResult lookup(String word) throws NotInHistoryException;
    void save(TranslationResult translationResult);
}