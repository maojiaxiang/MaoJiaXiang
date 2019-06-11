package mao.bw.com.maojiaxiang.model;

import io.reactivex.Observable;
import mao.bw.com.maojiaxiang.bean.LoginBean;
import mao.bw.com.maojiaxiang.bean.Result;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/11 09:20:09
 * @Description: 描述信息
 */
public interface IRequest {
    @FormUrlEncoded
    @POST("user/v1/login")
    Observable<Result<LoginBean>>login(@Field("phone")String phone,@Field("pwd")String pwd);
    @FormUrlEncoded
    @POST("user/v1/register")
    Observable<Result>register(@Field("phone")String phone,@Field("pwd")String pwd);
}
