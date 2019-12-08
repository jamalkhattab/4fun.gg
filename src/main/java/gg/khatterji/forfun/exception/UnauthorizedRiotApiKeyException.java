package gg.khatterji.forfun.exception;

public class UnauthorizedRiotApiKeyException extends RuntimeException {
    private int errorStatusCode;
    private String errorStatusText;
    public UnauthorizedRiotApiKeyException(int errorStatusCode, String errorStatusText) {
        this.errorStatusCode = errorStatusCode;
        this.errorStatusText = errorStatusText;
    }

    public String getErrorStatusText() {
        return errorStatusText;
    }

    public void setErrorStatusText(String errorStatusText) {
        this.errorStatusText = errorStatusText;
    }

    public int getErrorStatusCode() {
        return errorStatusCode;
    }

    public void setErrorStatusCode(int errorStatusCode) {
        this.errorStatusCode = errorStatusCode;
    }
}
