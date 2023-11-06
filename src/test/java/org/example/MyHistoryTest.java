package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class MyHistoryTest {

    @TempDir
    Path dir;

    @Test
    void read() throws IOException {
        MyHistory h = new MyHistory(this.dir + "/abc");
        h.read();
    }

    @Test
    void save() throws IOException {
        MyHistory h = new MyHistory(this.dir + "/abc");
        h.addLine("ahoj");
        h.save();
        h = new MyHistory(this.dir + "/abc");
        h.read();
        assertEquals("ahoj\n", h.toString());
    }

    @Test
    void addLine() {
        MyHistory h = new MyHistory(this.dir + "/abc");
        h.addLine("test");
        h.addLine("test2");
        h.addLine("test");
        h.addLine("test");
        assertEquals("test\ntest2\n", h.toString());
    }

    @Test
    void testToString() {

    }
}