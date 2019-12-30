def LOG_NAME = "debug.log"
def LOG_PATH = "logs"
def LOG_ARCHIVE = "${LOG_PATH}/archive"

appender("RollingFile-Appender", RollingFileAppender) {
    file = "${LOG_PATH}/${LOG_NAME}"
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "${LOG_ARCHIVE}/debug%d.log"
        maxHistory = 90
        totalSizeCap = "5GB"
    }
    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n"
    }
}

appender('STDOUT', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss.SSS} %green([%thread]) %highlight(%-5level) %logger{50} - %msg%n"
    }
}

root(INFO, ['RollingFile-Appender', 'STDOUT'])
