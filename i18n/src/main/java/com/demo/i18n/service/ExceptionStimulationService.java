package com.demo.i18n.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.codec.CodecException;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Jeanne 2023/6/23
 **/
@Service
@Slf4j
public class ExceptionStimulationService {
    public void throwIOException() throws IOException {
        throw new IOException("Stimulated IOException");
    }
    public void throwFileNotFoundException() throws FileNotFoundException {
        throw new FileNotFoundException("Stimulated FileNotFoundException");
    }
    public void throwCodecException() throws CodecException {
        throw new CodecException("Stimulated CodecException");
    }

    public void nestException() throws IOException {
        try {
            throwFileNotFoundException();
        } catch (FileNotFoundException e) {
           log.error("FileNotFoundException",e);
           throw new IOException("nestException===>" + e.getMessage(),e);
        }
    }
    public void nestException2() throws Exception {
        try {
            nestException();
        }  catch (Exception e) {
            log.error("Exception",e);
            throw new Exception("nestException2===>" + e.getMessage(),e);
        }
    }
}
