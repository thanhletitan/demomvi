package net.thoitrangsi.coffeeham.base;


import com.google.gson.Gson;

import net.thoitrangsi.coffeeham.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by nam.huynh on 7/17/2018.
 */

/**
 * Define class interceptor for handle refresh token
 */
//public class RefreshTokenInterceptor implements Interceptor {
//
//    Gson mGson;
//
//    public RefreshTokenInterceptor() {
//        mGson = new Gson();
//    }
//
//    private Retrofit getRetrofit() {
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient.Builder okHttpClientBuilder = APIManager.getUnsafeOkHttpClient();
//        if(BuildConfig.DEBUG)
//            okHttpClientBuilder.addInterceptor(logging);
//        Retrofit retrofit = new Retrofit.Builder()
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create(mGson))
//                .baseUrl(AuvenirApi.BASE_URL)
//                .client(okHttpClientBuilder.build())
//                .build();
//        return retrofit;
//    }
//
//    @Override
//    public Response intercept(Chain chain) throws IOException {
//        Request originalRequest = chain.request();
//        Response originRespone = chain.proceed(originalRequest);
//        MediaType contentType = originRespone.body().contentType();
//        String originResponeString = originRespone.body().string();
//        try {
//            ApiResponse originApiResponse = mGson.fromJson(originResponeString, ApiResponse.class);
//
//            if (originApiResponse.status.code.equals(APICodeConstant.AUTHENTICATION_ERROR)) {
//                RefreshTokenApi refreshTokenApi = getRetrofit().create(RefreshTokenApi.class);
//
//                ApiResponse apiResponse = null;
//                try {
//                    apiResponse = refreshTokenApi.getRefreshToken(API_GRANT_TYPE_REFRESH_TOKEN, API_ID, API_SECRET, API_SCOPE,
//                            SharePreferenceHelper.getTokenForRefresh()).toBlocking().first();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    apiResponse = null;
//                }
//
//                if (apiResponse != null && apiResponse.status.code.equals(APICodeConstant.SUCCESS)) {
//                    String newToken = apiResponse.data.get("access_token").getAsString();
//                    SharePreferenceHelper.setToken(newToken);
//                    String newRefreshToken = apiResponse.data.get("refresh_token").getAsString();
//                    SharePreferenceHelper.setRefreshToken(newRefreshToken);
//
//
//                    Request compressedRequest = originalRequest.newBuilder()
//                            .header("Authorization", SharePreferenceHelper.getTokenForAPI())
//                            .build();
//                    return chain.proceed(compressedRequest);
//                } else {
//                    //-- change to "refresh token fail code"  in data respone
//                    originApiResponse.status.code = APICodeConstant.REFRESH_TOKEN_ERROR;
//
//                    ResponseBody body = ResponseBody.create(contentType, mGson.toJson(originApiResponse));
//                    return originRespone.newBuilder().body(body).build();
//                }
//            } else {
//                //-- need to create new respone because can not read string() of responce 2 time, following document of okhttp3
//                ResponseBody body = ResponseBody.create(contentType, mGson.toJson(originApiResponse));
//                return originRespone.newBuilder().body(body).build();
//            }
//
//        } catch (Exception e) {
//            ResponseBody body = ResponseBody.create(contentType, originResponeString);
//            return originRespone.newBuilder().body(body).build();
//        }
//    }
//
//    public interface RefreshTokenApi {
//        // Get Refresh Token API
//        @FormUrlEncoded
//        @POST("oauth/connect/token")
//        Observable<ApiResponse> getRefreshToken(@Field("grant_type") String grant_type, @Field("client_id") String client_id
//                , @Field("client_secret") String client_secret, @Field("scope") String scope
//                , @Field("refresh_token") String deviceType);
//    }
//
//}
