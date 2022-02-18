// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
/*
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            if(nextOpenBracket<0) break;// to avoid infinite loop
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            if(nextCloseBracket<0) break;
            int openParen = markdown.indexOf("(", nextCloseBracket);
            if(openParen<0) break;
            int closeParen = markdown.indexOf(")", openParen);
            if(closeParen<0) break;
            if(nextOpenBracket==0){
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }
            else{
                String toTest = markdown.substring(nextOpenBracket-1,nextOpenBracket);
                if(toTest.equals("!"));// if statement to avoid returning an image
                else toReturn.add(markdown.substring(openParen + 1, closeParen));
            } 
            
            currentIndex = closeParen + 1;
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}*/
// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        char ImageIndicator='!';
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);
            if(nextOpenBracket==-1||nextCloseBracket==-1||openParen==-1||closeParen==-1
            ||markdown.charAt(nextCloseBracket+1)!='('){
                return toReturn;
            }
            /*
            if(nextCloseBracket+1 != openParen){
             currentIndex = nextCloseBracket+1;
             continue;
            }
            */
            if(nextOpenBracket==0){
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
                System.out.println(currentIndex);
            }
            else{
                if(markdown.charAt(nextOpenBracket-1)==ImageIndicator){
                
                    currentIndex = closeParen + 1;
                    System.out.println(currentIndex);
                }
                else{
                    toReturn.add(markdown.substring(openParen + 1, closeParen));
                    currentIndex = closeParen + 1;
                    System.out.println(currentIndex);
                }

            }
            
            
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}