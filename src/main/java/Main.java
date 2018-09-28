import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader();
        Person p = inputReader.readPersonInformation();
        DescriptionReader descriptionReader = new DescriptionReader();
        descriptionReader.readDestinyDescriptionFromFile(p.getDestinyNumber());
        if (inputReader.wouldYouLikeToKnownCompatibility()) {
            System.out.println(p.tellYourDestinyStory());
        } else descriptionReader.readDestinyDescriptionFromFile(p.getDestinyNumber());
        if (inputReader.doYouWantToKnowValueName()) {
           p.describeNameLetters();
        }else descriptionReader.readDestinyDescriptionFromFile(p.getDestinyNumber());

    }

}