package numerology.service;

import javassist.NotFoundException;
import numerology.ZodiacEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DescriptionReaderTest {

    @Autowired
    private DescriptionReaderService descriptionReaderService;

    @Test
    @Before
    public void readDestinyDescriptionFromFileTest() throws NotFoundException {
        //given
        int destinyNumber = 5;
        String correctText = " " + "The number 5:Positive Characteristics: 5s are energetic, adventurous, daring and freedom-loving. They also tend to be versatile, flexible, adaptable, curious, social, sensual, quick-thinking, witty, courageous and worldly." + "              Negative Characteristics: On the flip side, 5s can be unstable, chaotic, self-indulgent, irresponsible or careless. They should beware the consequences of drug abuse and unhealthy sexual tendencies.";
        //when
        String result = descriptionReaderService.readDestinyDescriptionFromFile(destinyNumber);
        //then
        Assert.assertEquals(correctText, result);
    }

    @Test
    public void findLettersFromNameTest() throws NotFoundException {
        //given
        String name = "Janneg";
        String correctTest = "The Meaning of \"J\" in Your NameIn this specific case, \"J\" is for justice. You are all about fairness and balancing the scales. You make an exemplary friend and try hard to make sure everyone is happy and comfortable. Make sure to motivate yourself enough to tap into natural talents." + "The Meaning of \"G\" in Your NameYou are an intellectually active person with loads of drive and the ability to make things happen. You are a visionary, and this could benefit you financially down the line. You think on your feet, even though you prefer to be very systematic. You may even feel psychic sometimes.";
        //when
        String result = descriptionReaderService.findLettersFromName(name);
        //then
        Assert.assertEquals(correctTest, result);
    }

    @Test
    public void findNextLetterTest() {
        //given
        String letter = "O";
        String correctLetter = "P";
        //when
        String result = descriptionReaderService.findNextLetter(letter);
        //then
        Assert.assertEquals(correctLetter, result);
    }

    @Test
    public void readZodiacSignFromFile() {
        //given
        ZodiacEnum zodiacEnum = ZodiacEnum.AQUARIUS;
        String description = "[Strengths: Progressive, original, independent, humanitarian, , Weaknesses: Runs from emotional expression, temperamental, uncompromising, aloof, ," +

                " Aquarius likes: Fun with friends, helping others, fighting for causes, intellectual conversation, a good listener, , Aquarius dislikes: Limitations, broken promises, being lonely, dull or boring situations, people who disagree with them, ," +

                " Aquarius-born are shy and quiet , but on the other hand they can be eccentric and energetic. However, in both cases, they are deep thinkers and highly intellectual people who love helping others. They are able to see without prejudice, on both sides, which makes them people who can easily solve problems., , " +

                "Although they can easily adapt to the energy that surrounds them, Aquarius-born have a deep need to be some time alone and away from everything, in order to restore power. People born under the Aquarius sign, look at the world as a place full of possibilities., , Aquarius is an air sign, and as such, uses his mind at every opportunity. If there is no mental stimulation, they are bored and lack a motivation to achieve the best result., , The ruling planet of Aquarius, Uranus has a timid, abrupt and sometimes aggressive nature, but it also gives Aquarius visionary quality. They are capable of perceiving the future and they know exactly what they want to be doing five or ten years from now., , Uranus also gave them the power of quick and easy transformation, so they are known as thinkers, progressives and humanists. They feel good in a group or a community, so they constantly strive to be surrounded by other people., , The biggest problem for Aquarius-born is the feeling that they are limited or constrained. Because of the desire for freedom and equality for all, they will always strive to ensure freedom of speech and movement. Aquarius-born have a reputation for being cold and insensitive persons, but this is just their defence mechanism against premature intimacy. They need to learn to trust others and express their emotions in a healthy way.]";
        //when
        String result = descriptionReaderService.readZodiacSignFromFile(zodiacEnum);
        //then
        Assert.assertEquals(description, result);
    }
 /*@Test
    public void inputInCorrectNonExistentYear() throws UnsupportedEncodingException {
        //given
        String data = "" + inCorrectNonexistentYear+ " " + correctYear;
        InputStream testInput = new ByteArrayInputStream(data.getBytes("UTF-8"));
        Scanner sc = new Scanner(testInput);
        //when
        int result = Numerology.Main.readYearFromInput(sc);
        //then
        Assert.assertEquals(correctYear, result);
    }

*/

}
