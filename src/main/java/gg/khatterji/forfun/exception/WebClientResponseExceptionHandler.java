package gg.khatterji.forfun.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

public class WebClientResponseExceptionHandler {
    public static void throwCorrespondingResponseStatusException(WebClientResponseException webClientResponseException) {
        Logger logger = LoggerFactory.getLogger("WebClientResponseExceptionHandler");
        logger.error("Exception was thrown with cause = \'{}\' and exception = \'{}\'", webClientResponseException.getCause() != null ? webClientResponseException.getCause() : "NULL", webClientResponseException.getMessage(), webClientResponseException);
        switch (webClientResponseException.getRawStatusCode()) {
            case 400:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Server is having problems with the API key");
            case 403:
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server is having problems with the API key");
            case 404:
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no resources that match the parameters specified.");
            default:
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
        }
    }
}
