package com.example.demo.core.utils;

public class ApiUtils {

    public static <T> ApiResult<T> success(T response){
        return new ApiResult<>(response);
    }

    // ** json으로 반환해야할 데이터
    public static  class ApiResult<T>{
        private boolean success; // 현재 상태
        private T response; // 반환할 실제 데이터

        public ApiResult(T response) {
            this.response = response;
        }
    }
}
