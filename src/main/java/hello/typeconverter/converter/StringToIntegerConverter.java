package hello.typeconverter.converter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
@Slf4j
public class StringToIntegerConverter implements Converter<String, Integer> { //Converter<S, T> S= 파라미터, T = 반환값
    @Override
    public Integer convert(String source) {
        log.info("convert source={}", source);
        //source라는 문자를 Integer타입으로 변환.
        return Integer.valueOf(source);
    }
}
