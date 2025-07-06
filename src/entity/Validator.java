package entity;

public interface Validator {
    default void validateString(String value, String fieldName) {
        if(value == null || value.isBlank()) throw new IllegalArgumentException("El campo " + fieldName + " es inválido.");
    }

    void validateNumber(int value, String fieldName);
}
