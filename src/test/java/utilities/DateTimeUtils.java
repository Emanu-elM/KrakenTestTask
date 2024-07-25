package utilities;

import java.time.Duration;
import java.time.Instant;

public class DateTimeUtils {

    public static long getYesterdayTimestamp(){
        Instant now = Instant.now();
        Duration oneDay = Duration.ofDays(1);
        Instant yesterday = now.minus(oneDay);

        return yesterday.getEpochSecond();
    }
}
