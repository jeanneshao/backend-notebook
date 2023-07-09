package com.example.jpademo.marshall;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jeanne 2023/7/9
 **/
@Data
@XmlRootElement
public class Settings {
    private boolean fooEnabled;

    public boolean isFooEnabled() {
        return fooEnabled;
    }

    public void setFooEnabled(boolean fooEnabled) {
        this.fooEnabled = fooEnabled;
    }
}
