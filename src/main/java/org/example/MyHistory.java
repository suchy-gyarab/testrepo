package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.LinkedHashSet;

public class MyHistory {
    String fileName;
    LinkedHashSet<String> data;

    public MyHistory(String fileName) {
        this.fileName = fileName;
        this.data = new LinkedHashSet<>();
    }

    public void read() throws IOException {
        try {
            Files.readString(Path.of(this.fileName)).lines().forEachOrdered(this.data::add);
        } catch (NoSuchFileException e) {
            data = new LinkedHashSet<>();
        }
    }

    public void save() throws IOException {
        Files.writeString(Path.of(this.fileName), this.toString());
    }

    public void addLine(String str) {
        data.add(str.charAt(str.length() - 1) == '\n' ? str.substring(0,str.length()-2) : str);
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (String s : data) {
            buf.append(s).append("\n");
        }
        return buf.toString();
    }
}