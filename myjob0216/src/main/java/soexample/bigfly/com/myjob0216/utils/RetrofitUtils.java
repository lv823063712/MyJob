package soexample.bigfly.com.myjob0216.utils;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import soexample.bigfly.com.myjob0216.api.APIService;
import soexample.bigfly.com.myjob0216.api.Contents;

/**
 * <p>文件描述：<p>
 * <p>作者：${吕飞}<p>
 * <p>创建时间：2019/2/16   11:18<p>
 * <p>更改时间：2019/2/16   11:18<p>
 * <p>版本号：1<p>
 */

public class RetrofitUtils {

    private final APIService apiService;

    private RetrofitUtils() {
        //日志拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //okhttp
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                // 添加拦截器
                .addInterceptor(loggingInterceptor)
                //设置连接失败时重试
                .retryOnConnectionFailure(true)
                .build();
        //初始化retrofit
        Retrofit retrofit = new Retrofit.Builder()
                //结合gson解析
                .addConverterFactory(GsonConverterFactory.create())
                //结合rxjava
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Contents.BASE_URL)
                //结合ok
                .client(okHttpClient)
                .build();
        //通过retrofit创建这个apiservice就可以使用了
        apiService = retrofit.create(APIService.class);
    }

    //静态内部类单例
    public static RetrofitUtils getInstance() {

        return ViewHolder.RETROFIT_UTILS;
    }

    private static class ViewHolder {
        private static final RetrofitUtils RETROFIT_UTILS = new RetrofitUtils();
    }

    //封装get方法
    public void get(String url, Map<String, String> map,HttpListener httpListener) {
        apiService.getReponseData(url, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (null != httpListener) {
                            httpListener.error(e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        if (null != httpListener) {
                            try {
                                httpListener.success(responseBody.string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
    }

    //接口回调
    public interface HttpListener<T> {
        void success(T data);

        void error(T error);
    }

    private HttpListener httpListener;


}
