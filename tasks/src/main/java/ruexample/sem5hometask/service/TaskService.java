package ruexample.sem5hometask.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ruexample.sem5hometask.model.Task;
import ruexample.sem5hometask.model.TaskStatus;
import ruexample.sem5hometask.repository.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository repository;

    /**
     * Метод поиска всех задач
     * @return - вщзвращает список задач
     */
    public List<Task> findAllTasks() {
        return repository.findAll();
    }

    /**
     * Метод создания задачи
     * @param task - сама задача
     * @return - возващает задачу, записанную в список задач
     */
    public Task createTask(Task task) {
        return repository.save(task);
    }

    /**
     * Метод поиска задач по статусу
     * @param status - статус задачи
     * @return - возвращает список задач с заданным статусом
     */
    public List<Task> findTasksByStatus(TaskStatus status) {
        return repository.findByStatus(status);
    }

    /**
     * Метод изменеия статуса задачи
     * @param id - номер задачи, для которой необходимо сменить статус
     * @param task - сама задача
     * @return - возвращает задачу с измененным статусом
     */
    public Task updateTaskStatus(Long id, Task task) {
        Task task1 = repository.findById(id).get();
        task1.setStatus(task.getStatus());
        return repository.save(task1);
    }

    /**
     * Метод удаления задачи по заданному номеру
     * @param id - номер задачи
     */
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
