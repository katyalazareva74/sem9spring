package ruexample.sem5hometask.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ruexample.sem5hometask.model.Task;
import ruexample.sem5hometask.model.TaskStatus;
import ruexample.sem5hometask.service.TaskService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private TaskService service;

    /**
     * Запрос возвращает список всех задач
     * @return - список задач
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return service.findAllTasks();
    }

    /**
     * Запрос отсылает задачу
     * @param task - сама задача, достаточного заполнения одного поля task
     * @return - возвращет задачу
     */
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return service.createTask(task);
    }

    /**
     * Запрос возвращает список задач с заданным статусом
     * @param status - статус задачи
     * @return - возвращает список задач
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return service.findTasksByStatus(status);
    }

    /**
     * Запрос редактирует статус задачи с заданным номером
     * @param id - номер задачи
     * @param task - сама задача, достаточно задать только поле status
     * @return - возвращает задачу с измененным статусом
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        return service.updateTaskStatus(id, task);
    }

    /**
     * Запрос удаляет заадчу по заданному номеру
     * @param id - номер задачи
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }
}
