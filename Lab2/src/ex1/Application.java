package ex1;

import java.time.LocalDate;

public class Application extends Project {
    private Languages language;

    public Application(String name, LocalDate deadline, Languages language) {
        super(name, deadline);
        this.language = language;
        id=idProject;
        idProject++;
    }

    public Languages getLanguage() {
        return language;
    }

    public void setLanguage(Languages language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Application{" +
                "language=" + language +
                ", name='" + name + '\'' +
                ", deadline=" + deadline +
                '}';
    }

    public  void  setDeadline(LocalDate deadline1){
        deadline=deadline1;
    }
}
