//package com.escort.ch3;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;
//import org.springframework.stereotype.Component;
//
//
//import java.util.Arrays;
//
//@Component("genre") class Genre {} // <bean id = "genre" class = "com.escort.ch3.Genre"/>
//@Component class Swing extends Genre {};
//@Component class Bebop extends Genre {};
//@Component class Musician {};
//@Component class Jazz {
//    @Value("So What") String standard;
//    @Value("1959") int year;
//    @Qualifier("bebop")
//    @Autowired Genre genre; // byType
//    @Autowired Musician[] musicians;
//
//    public Jazz() {}
//
//    public Jazz(String standard, int year, Genre genre, Musician[] musicians) {
//        this.standard = standard;
//        this.year = year;
//        this.genre = genre;
//        this.musicians = musicians;
//    }
//
//    public void setStandard(String standard) {
//        this.standard = standard;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }
//
//    public void setGenre(Genre genre) {
//        this.genre = genre;
//    }
//
//    public void setMusicians(Musician[] musicians) {
//        this.musicians = musicians;
//    }
//
//    @Override
//    public String toString() {
//        return "Jazz{" +
//                "standard='" + standard + '\'' +
//                ", year=" + year +
//                ", genre=" + genre +
//                ", musicians=" + Arrays.toString(musicians) +
//                '}';
//    }
//}
//
//public class SpringDiTest {
//    public static void main(String[] args) {
//        ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
////        Jazz jazz = (Jazz) ac.getBean("jazz"); // byName
//        Jazz jazz = ac.getBean("jazz", Jazz.class); // byName
////        Jazz jazz2 = (Jazz) ac.getBean(Jazz.class); // byType
////
////        Genre genre = (Genre) ac.getBean("swing"); // byName
//////        Genre genre = (Genre) ac.getBean(Genre.class); // byType
////        Musician musician = (Musician) ac.getBean("musician");
//
////        jazz.setStandard("So What");
////        jazz.setYear(1959);
////        jazz.setGenre(genre);
////        jazz.setMusicians(new Musician[] {ac.getBean("musician", Musician.class), (Musician) ac.getBean("musician")});
//
//        System.out.println("jazz = " + jazz);
//    }
//}
