import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        InputReader inputReader = new InputReader();
        Person p = inputReader.readPersonInformation();
        inputReader.readFromFile(builder, p.getDestinyNumber());
    }
}
