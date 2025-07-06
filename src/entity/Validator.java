package entity;

public interface Validator {
    void validateString(String value, String fieldName);

    void validateNumber(int value, String fieldName);
}
