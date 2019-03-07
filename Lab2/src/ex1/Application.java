package ex1;

import java.time.LocalDate;

/**
 *Aplication Class that represent a project of type aplication
 */
public class Application extends Project {
    /**
     * The language of aplication
     */
    private Languages language;

    /**
     * Initialize the aplication with his atribute
     * @param name Name of the aplication project
     * @param deadline  Deadline of aplication project
     * @param language Language of the aplication project
     */
    public Application(String name, LocalDate deadline, Languages language) {
        super(name, deadline);
        this.language = language;
        id=idProject;
        idProject++;
    }

    /**
     * @return Language of the project aplication
     */
    public Languages getLanguage() {
        return language;
    }

    /**
     * Set the language of the aplication
     * @param language The language we want to set the language of the aplication
     */
    public void setLanguage(Languages language) {
        this.language = language;
    }

    /**
     * A method by which we get information about the application
     * @return A string that contain information about aplication
     */
    @Override
    public String toString() {
        return "Application{" +
                "language=" + language +
                ", name='" + name + '\'' +
                ", deadline=" + deadline +
                '}';
    }

    /**
     * A method that set the deadline of the aplication
     * @param deadline1 The deadline of the aplication we want to set
     */
    public  void  setDeadline(LocalDate deadline1){
        deadline=deadline1;
    }
}
