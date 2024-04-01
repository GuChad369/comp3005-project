package comp3005.project.club.Util;

import java.io.Serializable;
import lombok.Data;


// unite the result format
@Data
public class ResultData <T> implements Serializable {

    private int status;
    private String message;
    private T data;
    private long timestamp ;

    public ResultData (){
        this.timestamp = System.currentTimeMillis();
    }


    public static <T> ResultData<T> success(T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(ReturnCodeEnum.RC200.getCode());
        resultData.setMessage(ReturnCodeEnum.RC200.getMessage());
        resultData.setData(data);
        return resultData;
    }

    public static <T> ResultData<T> fail(int code, String message) {
        ResultData<T> resultData = new ResultData<T>();
        resultData.setStatus(code);
        resultData.setMessage(message);
        return resultData;
    }
}
