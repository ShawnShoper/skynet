package org.skynet.crawler.mall.gome.analyzer;

/**
 * Created by Medusar on 19/03/2017.
 */
public class AnalyzeResult {

    private boolean success;
    private String errorMsg;


    public static AnalyzeResult ofFailed(String errorMsg) {
        return new AnalyzeResult(false, errorMsg);
    }

    public AnalyzeResult(boolean success, String errorMsg) {
        this.success = success;
        this.errorMsg = errorMsg;
    }

    public AnalyzeResult() {
    }

    //TODO


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
