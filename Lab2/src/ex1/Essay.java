package ex1;

import java.time.LocalDate;

/**
 * Essay Class that represent a project of type essay
 */
class Essay extends Project {
    /**
     * The topic of essay
     */
    private Topics topic;

    /**
     * Initialize the essay with his atribute
     * @param name Name of the essay project
     * @param deadline Deadline of the essay project
     * @param topic Topic of the essay project
     */
    public Essay(String name, LocalDate deadline, Topics topic) {
        super(name, deadline);
        this.topic = topic;

    }

    /**
     * @return Topic of the project essay
     */
    public Topics getTopic() {
        return topic;
    }

    /**
     * Set the topic of the essay
     * @param topic The topic we want to set the topic of the essay
     */
    public void setTopic(Topics topic) {
        this.topic = topic;
    }

    /**
     *A method by which we get information about the essay in string format
     * @return A string that contain information about essay
     */
    @Override
    public String toString() {
        return "Essay{" +
                "topic=" + topic +
                ", name='" + name + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}
