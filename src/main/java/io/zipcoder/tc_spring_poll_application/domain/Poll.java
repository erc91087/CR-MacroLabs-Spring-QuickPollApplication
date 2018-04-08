package io.zipcoder.tc_spring_poll_application.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Poll {

    @Id
    @GeneratedValue
    @Column (name = "POLL_ID")
    private long id;

    @Column (name = "QUESTION")
    @NotEmpty
    private String question;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "POLL_ID")
    @OrderBy
    @Size (min = 2, max = 6)
    private Set<Option> options;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }
}