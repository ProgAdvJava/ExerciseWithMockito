package be.pxl.exercise2;

import java.time.LocalDateTime;

public class TranslationResult {
    private final String original;
    private final String translation;
    private final LocalDateTime timestamp;

    public TranslationResult(String original, String translation) {
        this.original = original;
        this.translation = translation;
        this.timestamp = LocalDateTime.now();
    }

    public String getTranslation() {
        return translation;
    }

    public String getOriginal() {
        return original;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}