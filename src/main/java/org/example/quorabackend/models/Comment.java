package org.example.quorabackend.models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long parent_id;

    private String text;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    private Long user_id;
}
