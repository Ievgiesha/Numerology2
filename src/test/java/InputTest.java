import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InputTest {

  /* private static final int inCorrectBigDay = 114;
    private static final  int inCorrectNegativeDay = -23;
    private static final int correctDay = 22;
    private static final int inCorrectTooBigMonth = 13;
    private static final int InCorrectNegativeMonth = -2;
    private static final int correctMonth = 3;
    private static final int inCorrectEarlyYear = 1799;
    private static final  int inCorrectNonexistentYear = -20;
    private static final  int correctYear = 1973;

    @Test
    public void inputTooBigDayTest() throws UnsupportedEncodingException {
        //given
        String data = "" + inCorrectBigDay + " " + correctDay;
        InputStream testInput = new ByteArrayInputStream(data.getBytes("UTF-8"));
        Scanner sc = new Scanner(testInput);
        //when
        int result = Main.readDayFromInput(sc);
        //then
        Assert.assertEquals(correctDay, result);
    }

    @Test
    public void inputTooSmallDay() throws UnsupportedEncodingException {
        //given
        String data = "" + inCorrectNegativeDay + " " + correctDay;
        InputStream testInput = new ByteArrayInputStream(data.getBytes("UTF-8"));
        Scanner sc = new Scanner(testInput);
        //when
        int result = Main.readDayFromInput(sc);
        //then
        Assert.assertEquals(correctDay, result);
    }
    @Test
    public void inputTooBigMonth() throws UnsupportedEncodingException {
        //given
        String data = "" + inCorrectTooBigMonth+ " " + correctMonth;
        InputStream testInput = new ByteArrayInputStream(data.getBytes("UTF-8"));
        Scanner sc = new Scanner(testInput);
        //when
        int result = Main.readMonthFromInput(sc);
        //then
        Assert.assertEquals(correctMonth, result);
    }
    @Test
    public void inputInCorrectNegativeMonth() throws UnsupportedEncodingException {
        //given
        String data = "" + InCorrectNegativeMonth+ " " + correctMonth;
        InputStream testInput = new ByteArrayInputStream(data.getBytes("UTF-8"));
        Scanner sc = new Scanner(testInput);
        //when
        int result = Main.readMonthFromInput(sc);
        //then
        Assert.assertEquals(correctMonth, result);
    }
    @Test
    public void inputInCorrectEarlyYear() throws UnsupportedEncodingException {
        //given
        String data = "" + inCorrectEarlyYear+ " " + correctYear;
        InputStream testInput = new ByteArrayInputStream(data.getBytes("UTF-8"));
        Scanner sc = new Scanner(testInput);
        //when
        int result = Main.readYearFromInput(sc);
        //then
        Assert.assertEquals(correctYear, result);
    }
 @Test
    public void inputInCorrectNonExistentYear() throws UnsupportedEncodingException {
        //given
        String data = "" + inCorrectNonexistentYear+ " " + correctYear;
        InputStream testInput = new ByteArrayInputStream(data.getBytes("UTF-8"));
        Scanner sc = new Scanner(testInput);
        //when
        int result = Main.readYearFromInput(sc);
        //then
        Assert.assertEquals(correctYear, result);
    }

*/

}
