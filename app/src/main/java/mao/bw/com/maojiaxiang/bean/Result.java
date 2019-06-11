package mao.bw.com.maojiaxiang.bean;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/11 09:17:49
 * @Description: 描述信息
 */
public class Result<T> {
    /* "message": "登录成功",
             "status": "0000"*/
    public String message;
    public String status;
    public T result;

    public Result(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public Result(String message) {
    }
}
