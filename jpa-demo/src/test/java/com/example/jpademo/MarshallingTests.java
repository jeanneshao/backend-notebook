package com.example.jpademo;

import com.example.jpademo.marshall.Settings;
import com.sun.xml.txw2.annotation.XmlElement;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.oxm.jibx.JibxMarshaller;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

@SpringBootTest
@ActiveProfiles({"dev"})
@Slf4j
class MarshallingTests {
//    @Bean
//    public Marshaller marshaller() {
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        marshaller.setPackagesToScan("com.example.package"); // Replace with your package name
//        return marshaller;
//    }
//    @Bean
//    public Unmarshaller unmarshaller() {
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        marshaller.setPackagesToScan("com.example.package"); // Replace with your package name
//        return marshaller;
//    }


//    @Resource
//    Marshaller marshaller;
//    @Resource
//    Unmarshaller unmarshaller;

    @Test
    void writeXml() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.example.jpademo");
        Settings settings = new Settings();
//        StringWriter writer = new StringWriter();
//        try {
//            marshaller.marshal(settings, new StreamResult(writer));
//        } catch (Exception e) {
//           log.error("marshal error",e);
//        }
//        log.info("marshel result: \n{}",writer.toString());

        File xmlFile = null;
        try {
            xmlFile = ResourceUtils.getFile("classpath:xml/MarshallingTests.xml");
        } catch (FileNotFoundException e) {
            log.error("<======Catch Error======>", e);
        }

        try (FileWriter os = new FileWriter(xmlFile)) {
            StreamResult streamResult = new StreamResult(os);
            marshaller.marshal(settings,streamResult );

        } catch (Exception e) {
            log.error("marshal error",e);
        }
    }

    @SneakyThrows
    @Test
    void readXml() {
        Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();
        unmarshaller.setPackagesToScan("com.example.jpademo");
        File xmlFile = ResourceUtils.getFile("classpath:xml/MarshallingTests.xml");

        try (FileReader is = new FileReader(xmlFile)) {
            Settings settings = (Settings) unmarshaller.unmarshal(new StreamSource(is));
            log.info("read Settings \n{}", settings);
        }
    }


    @Test
    void testXStreamMarshaller(){
        XStreamMarshaller marshaller = new XStreamMarshaller();
        File xmlFile = null;
        try {
            xmlFile = ResourceUtils.getFile("classpath:xml/MarshallingTests.xml");
        } catch (FileNotFoundException e) {
            log.error("<======Catch Error======>", e);
        }

        try (FileWriter os = new FileWriter(xmlFile)) {
            StreamResult streamResult = new StreamResult(os);
            Settings settings = new Settings();
            marshaller.marshal(settings,streamResult );

        } catch (Exception e) {
            log.error("marshal error",e);
        }

        try (FileReader is = new FileReader(xmlFile)) {
            Settings settings = (Settings) marshaller.unmarshal(new StreamSource(is));
            log.info("read Settings \n{}", settings);
        } catch (FileNotFoundException e) {
            log.error("<======Catch FileNotFoundException======>", e);
        } catch (IOException e) {
            log.error("<======Catch IOException======>", e);
        }

    }



}
