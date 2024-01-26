FROM bellsoft/liberica-openjdk-alpine:11.0.16.1-1
COPY ./ ./src
RUN javac -sourcepath ./src -d ./out/production/seminar11 ./src/main/Main.java
RUN java -classpath ./out/production/seminar11 main.Main
RUN javadoc -d ./doc -sourcepath ./src -cp ./out/production/Seminar11/main -subpackages main