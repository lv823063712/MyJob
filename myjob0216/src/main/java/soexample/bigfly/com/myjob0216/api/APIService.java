package soexample.bigfly.com.myjob0216.api;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * <p>文件描述：<p>
 * <p>作者：${吕飞}<p>
 * <p>创建时间：2019/2/16   11:34<p>
 * <p>更改时间：2019/2/16   11:34<p>
 * <p>版本号：1<p>
 */

public interface APIService {
    @GET
    Observable<ResponseBody> getReponseData(@Url String url, @QueryMap Map<String, String> map);
}
