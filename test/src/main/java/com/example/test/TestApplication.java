package com.example.test;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TestApplication {

    /**
     * JSON格式输出使用fastjson
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.WriteNullStringAsEmpty);
        //时间格式化
        fastJsonConfig.setDateFormat("yyyyMMddHHmmss");
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //由于新版本fastjson设置了MediaType为'/',所以需要手动加入所需的MediaType
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        //增加JSON的MediaType
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        //下面的都是扩展的
        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XML);
        supportedMediaTypes.add(MediaType.IMAGE_GIF);
        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
        supportedMediaTypes.add(MediaType.IMAGE_PNG);
        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        supportedMediaTypes.add(MediaType.TEXT_XML);
        fastConverter.setSupportedMediaTypes(supportedMediaTypes);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //将fastjson添加到视图消息转换器列表内
        return new HttpMessageConverters(fastConverter);
    }

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}