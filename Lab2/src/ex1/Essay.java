package ex1;

import java.time.LocalDate;

public class Essay extends Project {
    private Topics topic;

    public Essay(String name, LocalDate deadline, Topics topic) {
        super(name, deadline);
        this.topic = topic;
    }

    public Topics getTopic() {
        return topic;
    }

    public void setTopic(Topics topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Essay{" +
                "topic=" + topic +
                ", name='" + name + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}
