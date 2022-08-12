package de.ausgeufert.demo.performance;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity(name = "appraisal_questions")
@IdClass(PerformanceId.class)
public class Performance implements Serializable {

    @Id
    private String author;
    private String authorMail;
    private String authorTeam;

    @Id
    private String receiver;
    private String receiverMail;
    private String receiverTeam;

    private String reviewType;

    @Id
    private String questionId;

    private String rating;
    private String scale;

    private String comment;
}
