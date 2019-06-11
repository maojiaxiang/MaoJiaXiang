package mao.bw.com.maojiaxiang.presenter;

import java.lang.ref.Reference;

import io.reactivex.Observable;
import mao.bw.com.maojiaxiang.base.BasePresenter;
import mao.bw.com.maojiaxiang.core.DataCall;
import mao.bw.com.maojiaxiang.model.IRequest;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/11 09:26:16
 * @Description: 描述信息
 */
public class LoginPresenter<T> extends BasePresenter {
    private Reference<T>tReference;
    public LoginPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(IRequest iRequest, Object... args) {
        return iRequest.login((String)args[0],(String)args[1]);
    }
    //内存泄漏
    public void deachView(){
        if (tReference!=null){
            tReference.clear();
            tReference=null;
        }
    }
}
