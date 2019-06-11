package mao.bw.com.maojiaxiang.bean;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/11 09:18:58
 * @Description: 描述信息
 */
public class LoginBean {
    /*  "headPic": "http://172.17.8.100/images/small/default/user.jpg",
              "nickName": "4Y_3w700",
              "phone": "15011460789",
              "sessionId": "15602147585372231",
              "sex": 1,
              "userId": 2231*/
    private String headPic;
    private String nickName;
    private String phone;
    private String sessionId;
    private String sex;
    private String userId;

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
