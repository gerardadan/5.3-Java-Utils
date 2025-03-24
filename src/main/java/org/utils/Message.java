package org.utils;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Message implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String text;

    public Message(String missatge) {
        this.text = missatge;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Message message = (Message) obj;
        return Objects.equals(text, message.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
