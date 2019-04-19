package net.thoitrangsi.coffeeham.base;






/**
 * Created by thanh.le on 9/24/2018.
 */
//public class NetworkResponseTransformer  implements
//        Observable.Transformer<ApiResponse, ApiResponse> {
//    Gson gson;
//    public NetworkResponseTransformer(Gson gson){
//        this.gson = gson;
//    }
//
//    @Override
//    public Observable<ApiResponse> call(Observable<ApiResponse> observable) {
//        return observable
//                .flatMap(
//                        networkResponse -> {
//                            Throwable error = validateNetworkResponse(networkResponse);
//                            if (error != null) {
//                                Timber.e(error);
//                                return Observable.error(error);
//                            }
//
//
//                            Timber.e("Response",
//                                    "<-- Response: " + gson.toJson(networkResponse));
//
//                            return Observable.just(networkResponse);
//                        })
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread());
//    }
//
//    private Throwable validateNetworkResponse(ApiResponse response) {
//        if (response == null) {
//            return new RuntimeException("NetworkResponse null");
//        }
//        String code = response.status.code;
//        if (Util.isNullOrEmpty(code)) {
//            return new RuntimeException("NetworkStatusCode null for code = " + response.status.code);
//        }
//        switch (code) {
//            case SUCCESS:
//                return null;
//            case AUTHENTICATION_ERROR:
//                return new FailWithMessageException(response.status.msg);
//            case API_ERROR:
//                return new FailWithMessageException(response.status.msg);
//            case INVALID_REQUEST_ERROR:
//                return new FailWithMessageException(response.status.msg);
//            case PERMISSION_ERROR:
//                return new FailWithMessageException(response.status.msg);
//            case REFRESH_TOKEN_ERROR:
//                //-- send a signal for activity handle
//                EventBus.getDefault().postSticky(new RefreshTokenFailEvent());
//                return new FailWithMessageException(response.status.msg);
//            default:
//                return new RuntimeException("Uncaught exception");
//        }
//    }
//}
