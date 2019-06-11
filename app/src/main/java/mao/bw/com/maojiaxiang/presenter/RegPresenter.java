package mao.bw.com.maojiaxiang.presenter;

import io.reactivex.Observable;
import mao.bw.com.maojiaxiang.base.BasePresenter;
import mao.bw.com.maojiaxiang.core.DataCall;
import mao.bw.com.maojiaxiang.model.IRequest;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/11 09:52:11
 * @Description: 描述信息
 */
public class RegPresenter extends BasePresenter {
    public RegPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(IRequest iRequest, Object... args) {
        return iRequest.register((String)args[0],(String)args[1]);
    }
}
