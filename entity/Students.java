package com.montella.demo.entity;

import lombok.*;


import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Students {
    @Getter
    @Setter
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
   @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
           generator = "student_sequence"

    )

    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(name="EmailAddress",
        nullable = false)
    private String Email_id;

    @Embedded
    private Guardian guardian;


}
