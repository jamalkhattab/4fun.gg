package gg.khatterji.forfun.service.utility;

import java.sql.Timestamp;

public interface TimeDecisionHandler {
    long getTimeElapedSinceLastUpdate(Timestamp lastUpdatedDate);
    long getTimeLeftForUpdate(Timestamp lastUpdatedDate);
}
