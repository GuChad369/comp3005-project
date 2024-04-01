package comp3005.project.club.Util;


// define result code
public enum ReturnCodeEnum {
    RC200(200,"successfully!"),
    RC400(400,"failed!"),
    RC500(500,"server error");

    private final int code;
    private final String message;

    ReturnCodeEnum(int code, String message){
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
