package dev.luan.data.keyValue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class KeyValue <T, R> {
    /**
     * Represents the key of a key-value pair.
     */
    private T key;
    /**
     * Private field representing the value component of a key-value pair.
     */
    private R value;

    /**
     * Returns a string representation of the KeyValue object by concatenating the key and value with a colon and space in between.
     *
     * @return a string containing the key and value separated by a colon and space
     */
    @Override
    public String toString() {
        return key + ": " + value;
    }
}