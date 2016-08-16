package actestDemo.common;

/**
 * Created by sutaiyun on 2016/8/15.
 */
public class Response<T> {
    private String msg = "success";
    private Integer code = 1;
    T bizData;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getBizData() {
        return bizData;
    }

    public void setBizData(T bizData) { this.bizData = bizData; }

    public String toString() {
        return "Response{" +
                "msg='" +
                msg +
                '\'' +
                ", code=" +
                code +
                ", bizData=" +
                bizData.toString() +
                '}';
    }

    public static Response<Object> makeResponse(Object object) {
        Response<Object> rsp = new Response<>();

        rsp.setCode(1);
        rsp.setMsg("success");
        rsp.setBizData(object);
        return rsp;
    }
}
