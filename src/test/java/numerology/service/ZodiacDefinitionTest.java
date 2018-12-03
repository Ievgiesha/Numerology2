package numerology.service;

import numerology.ZodiacEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
public class ZodiacDefinitionTest {


    private ZodiacDefinition zodiacDefinition = new ZodiacDefinition();

    @Test
    public  void findZodiacSignTest(){
        //given
        LocalDate birthday1 = LocalDate.of(1973,6,1);
        LocalDate birthday2 = LocalDate.of(1993,11,4);
        ZodiacEnum gemini = ZodiacEnum.GEMINI;
        ZodiacEnum scorpio = ZodiacEnum.SCORPIO;
        //when
        ZodiacEnum result1 = zodiacDefinition.findZodiacSign(birthday1);
        ZodiacEnum result2 = zodiacDefinition.findZodiacSign(birthday2);
        //then
        Assert.assertEquals(gemini,result1);
        Assert.assertEquals(scorpio,result2);
    }
}
