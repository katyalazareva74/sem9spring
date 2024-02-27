package ruexample.sem5hometask.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tasks")
public class Task {
    /**
     * Требуется заполнить только поле task (описание задачи).
     * При создании задачи присваивается статус задачи NO_STARTED
     *  и задаются дата и время.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 60)
    private String task;
    @Column
    private TaskStatus status = TaskStatus.NO_STARTED;
    @Column
    private LocalDateTime localDateTime = LocalDateTime.now();
}
