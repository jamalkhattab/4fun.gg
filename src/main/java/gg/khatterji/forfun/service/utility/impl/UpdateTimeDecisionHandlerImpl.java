package gg.khatterji.forfun.service.utility.impl;

import gg.khatterji.forfun.constant.ForFunTimeConstants;
import gg.khatterji.forfun.service.utility.TimeDecisionHandler;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

@Service
public class UpdateTimeDecisionHandlerImpl implements TimeDecisionHandler {
    @Override
    public long getTimeElapedSinceLastUpdate(Timestamp lastUpdatedDate) {
        LocalDateTime summonerLastUpdatedTime = LocalDateTime.ofInstant(lastUpdatedDate.toInstant(), ZoneId.systemDefault());
        LocalDateTime fromTemp = LocalDateTime.from(summonerLastUpdatedTime);
        LocalDateTime currentTime = LocalDateTime.now(ZoneId.systemDefault());
        return fromTemp.until(currentTime, ChronoUnit.SECONDS);
    }

    @Override
    public long getTimeLeftForUpdate(Timestamp lastUpdatedDate) {
        LocalDateTime currentTime = LocalDateTime.now(ZoneId.systemDefault());
        LocalDateTime fromTemp = LocalDateTime.from(LocalDateTime.ofInstant(lastUpdatedDate.toInstant(), ZoneId.systemDefault()));
        long lastUpdatedDateInSeconds= fromTemp.until(currentTime, ChronoUnit.SECONDS);
        return ForFunTimeConstants.SECONDS_FOR_UPDATE - lastUpdatedDateInSeconds;
    }
}
