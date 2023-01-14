package com.escort.ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class Jazz {
    @Value("So What")
    String standard;
    @Value("1959")
    int year;
//    @Autowired
    Genre genre;
//    @Autowired
    Musician[] musicians;

    public Jazz() {}

    @Autowired
    public Jazz(@Value("So What") String standard, @Value("1959") int year, Genre genre, Musician[] musicians) {
        this.standard = standard;
        this.year = year;
        this.genre = genre;
        this.musicians = musicians;
    }

    @Override
    public String toString() {
        return "Jazz{" +
                "standard='" + standard + '\'' +
                ", year=" + year +
                ", genre=" + genre +
                ", musicians=" + Arrays.toString(musicians) +
                '}';
    }
}
@Component
class Genre {}
@Component
class Swing extends Genre {}
@Component
class Bebop extends Genre {}
@Component
class Musician {}

public class ApplicationContextTest {
    public static void main(String[] args) {
        ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
        Jazz jazz = (Jazz) ac.getBean("jazz");

        System.out.println("jazz = " + jazz);
    }
}
