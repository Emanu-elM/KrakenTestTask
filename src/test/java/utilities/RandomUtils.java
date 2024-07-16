package utilities;

import java.util.Random;

public class RandomUtils {

    public static Integer getRandomNumber(int min, int max){
        Random rand = new Random();
        return rand.nextInt(max - min) + min;
    }
}
