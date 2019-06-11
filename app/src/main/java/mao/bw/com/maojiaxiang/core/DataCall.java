package mao.bw.com.maojiaxiang.core;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/11 09:21:43
 * @Description: 描述信息
 */
public interface DataCall<T> {
    void success(T result,Object...args);
}
