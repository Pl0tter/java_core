package seminar01.sample;

import seminar01.regular.Decorator;
import seminar01.regular.OtherClass;

/**
 * ...\JavaCore\src\main> javac -sourcepath ./java -d out java/seminar01/sample/Main.java
 * ...\JavaCore\src\main> java -classpath ./out seminar01.sample.Main
 * ...\JavaCore\src\main> javadoc -encoding utf8  -d docs -sourcepath ./java -cp ./out -subpackages ru
 * <p>
 * https://www.docker.com/products/docker-desktop/
 * https://hub.docker.com/
 * <p>
 * FROM bellsoft/liberica-openjdk-alpine:16.0.1
 * COPY ./java ./src
 * RUN mkdir ./out
 * RUN javac -sourcepath ./src -d out src/ru/geekbrains/lesson1/sample/Main.java
 * CMD java -classpath ./out ru.geekbrains.lesson1.sample.Main
 * <p>
 * <p>
 * ...\JavaCore\src\main> docker build . -t samplejavapp:v1
 * ...\JavaCore\src\main> docker run --rm samplejavapp:v1
 */
public class Main {

    public static void main(String[] args) {
        int result = OtherClass.add(2, 2);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.sub(2, 2);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.mul(2, 2);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.div(2, 2);
        System.out.println(Decorator.decorate(result));
    }
}
