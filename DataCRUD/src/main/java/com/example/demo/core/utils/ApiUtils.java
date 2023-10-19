package com.example.demo.core.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ApiUtils {

    public static <T> ApiResult<T> success(T response){
        return new ApiResult<>(true,response,null);
    }

    public static <T> ApiResult<T> error(String message){
        return new ApiResult<>(false,null,new ApiError(message));
    }

    // ** json으로 반환해야할 데이터
    @AllArgsConstructor
    @Setter
    @Getter
    public static  class ApiResult<T>{
        private final boolean success; // 현재 상태
        private final T response; // 반환할 실제 데이터
        private final ApiError error;

        public String inString(){
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("success",success)
                    .append("response",response)
                    .append("error",error)
                    .toString();
        }
    }

    @AllArgsConstructor
    @Setter
    @Getter
    public static class ApiError{
        private final String message;

        public String inString(){
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("message",message)
                    .toString();
        }
    }
}
