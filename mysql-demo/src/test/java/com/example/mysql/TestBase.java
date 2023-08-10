package com.example.mysql;


import com.example.mysql.domain.S1;
import com.example.mysql.domain.S2;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.common.base.CaseFormat;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@SpringBootTest
@Slf4j
public class TestBase {


    public static JsonMapper jsonMapper = new JsonMapper();
    public static ObjectMapper objectMapper = new ObjectMapper();
    static {
        jsonMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        JsonSetter.Value customSetter = JsonSetter.Value.forValueNulls(Nulls.SKIP);
        jsonMapper.setDefaultSetterInfo(customSetter);

        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.setDefaultSetterInfo(customSetter);
    }

    protected String jsonFileDirectory = "D:\\git\\aspectj-demo\\mysql-demo\\src\\main\\resources\\json";

    Class[] entityClasses = new Class[]{  S1.class, S2.class};

    public void writeToJsonFile(Class clazz) {
        String jsonFilePath = jsonFileDirectory + camelToPascal(clazz.getSimpleName()) + ".json";
        Constructor declaredConstructor = null;
        try {
            declaredConstructor = clazz.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            Object targetObject = declaredConstructor.newInstance();

            objectMapper.writeValue(new File(jsonFilePath), targetObject);
        } catch (NoSuchMethodException e) {
            log.error("NoSuchMethodException===>", e.getMessage());
        } catch (InvocationTargetException e) {
            log.error("InvocationTargetException===>", e.getMessage());
        } catch (InstantiationException e) {
            log.error("InstantiationException===>", e.getMessage());
        } catch (IllegalAccessException e) {
            log.error("IllegalAccessException===>", e.getMessage());
        } catch (JsonMappingException jsonMappingException) {
            log.error("JsonMappingException===>", jsonMappingException.getMessage());
        } catch (JsonGenerationException e) {
            log.error("JsonGenerationException===>", e.getMessage());
        } catch (IOException e) {
            log.error("IOException===>", e.getMessage());
        }


    }

    public <T> T readObjectFromJsonFile(Class clazz) {
        String jsonFilePath = jsonFileDirectory + camelToPascal(clazz.getSimpleName()) + ".json";
        T targetObject = readObjectFromJsonFile(clazz, jsonFilePath);
        return targetObject;
    }
    public <T> T readObjectFromJsonFile(Class clazz,String jsonFilePath) {
        T targetObject = null;
        try {
            targetObject = (T) objectMapper.readValue(new File(jsonFilePath), clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return targetObject;
    }

    @Test
    void testWriteToJsonFile(Class clazz) {
        writeToJsonFile(clazz);

    }

    @Test
    void writeAllEmptyToJsonFile() {
        for (Class entityClass : entityClasses) {
            writeToJsonFile(entityClass);
        }
    }

    @Test
    void testReadFromJsonFile(Class clazz) {
        Object entity = readObjectFromJsonFile(clazz);
        log.info("{}", entity);
    }

    public static String camelToPascal(String camel) {

        if (Strings.isNullOrEmpty(camel)) {
            return "";
        }
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN,camel);
    }

    public static String pascalToCamel(String pascal){
        if (Strings.isNullOrEmpty(pascal)) {
            return "";
        }
        return CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL,pascal);
    }
}
