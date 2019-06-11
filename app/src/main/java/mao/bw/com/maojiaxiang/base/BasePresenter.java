package mao.bw.com.maojiaxiang.base;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import mao.bw.com.maojiaxiang.bean.Result;
import mao.bw.com.maojiaxiang.core.DataCall;
import mao.bw.com.maojiaxiang.model.IRequest;
import mao.bw.com.maojiaxiang.util.HttpUtil;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/11 09:22:33
 * @Description: 描述信息
 */
public abstract class BasePresenter {
    private DataCall dataCall;

    public BasePresenter(DataCall dataCall) {
        this.dataCall = dataCall;
    }
    public void requestData(Object...args){
        IRequest iRequest = HttpUtil.getInstance().create(IRequest.class);
        getModel(iRequest,args)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn(new Function<Throwable,Result>() {
                    @Override
                    public Result apply(Throwable o) throws Exception {
                        o.printStackTrace();
                        return new Result(o.getMessage());
                    }
                })
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result o) throws Exception {
                        if ("0000".equals(o.status)){
                            dataCall.success(o.result);
                        }
                    }
                });
    }
    protected abstract Observable getModel(IRequest iRequest,Object...args);
}
