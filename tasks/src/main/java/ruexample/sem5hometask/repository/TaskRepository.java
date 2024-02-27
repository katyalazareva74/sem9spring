package ruexample.sem5hometask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ruexample.sem5hometask.model.Task;
import ruexample.sem5hometask.model.TaskStatus;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    /**
     * Метод поиска задач по статусу
     * @param status - статус задачи
     * @return - возвращает список задач с заданным статусом.
     */
    List<Task> findByStatus(TaskStatus status);
}
