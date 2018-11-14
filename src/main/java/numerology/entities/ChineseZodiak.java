package numerology.entities;

import numerology.ZodiacEnum;

public class ChineseZodiak {
    private final ZodiacEnum zodiacEnum;
    private Person person;
    private Long id;
    public ChineseZodiak(ZodiacEnum zodiacEnum,Long id ){
        this.zodiacEnum = zodiacEnum;
        this.id = id;
    }


}
