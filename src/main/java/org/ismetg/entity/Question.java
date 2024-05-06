package org.ismetg.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tblsoru")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "soru_metni")
    String questionText;
    @Column(name = "konu")
    String subject;
    @Column(name = "puan")
    Double point;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    List<Answer> answers;

    @OneToOne()
    Answer correctAnswer;

}
