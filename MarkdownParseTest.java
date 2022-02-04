import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import org.junit.*;
import java.io.IOException;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void links() throws IOException{
        ArrayList<String> output = new ArrayList<>();
        ArrayList<String> actual = new ArrayList<>();
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        output.add("https://something.com");
        output.add("some-page.html");
        assertEquals("test for getLinks", output, links);
    }

    @Test
    public void links2() throws IOException {
        ArrayList<String> output = new ArrayList<>();
        Path fileName = Path.of("test-file2.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        output.add("https://something.com");
        assertEquals(output, links);
    }
   @Test
        public void links3() throws IOException {
        ArrayList<String> output = new ArrayList<>();
        Path fileName = Path.of("test-file3.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        output.add("https://something.com");
        assertEquals(output, links);
    }
    @Test
    public void links4() throws IOException {
        ArrayList<String> output = new ArrayList<>();
        Path fileName = Path.of("test-file4.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        output.add("https://something.com");
        assertEquals(output, links);
    }
}