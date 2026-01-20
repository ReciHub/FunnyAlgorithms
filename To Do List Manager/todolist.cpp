#include <iostream>
#include <vector>
#include <string>

// Structure to represent a task
struct Task {
    int id;
    std::string description;
};

// Function to add a task
void addTask(std::vector<Task>& tasks, int& taskId) {
    std::string description;
    std::cout << "Enter the task description: ";
    std::cin.ignore();
    std::getline(std::cin, description);
    tasks.push_back({taskId++, description});
    std::cout << "Task added successfully!\n";
}

// Function to display all tasks
void displayTasks(const std::vector<Task>& tasks) {
    if (tasks.empty()) {
        std::cout << "No tasks in the to-do list.\n";
        return;
    }
    std::cout << "To-Do List:\n";
    for (const Task& task : tasks) {
        std::cout << "[" << task.id << "] " << task.description << "\n";
    }
}

// Function to edit a task
void editTask(std::vector<Task>& tasks) {
    int taskId;
    std::cout << "Enter the task ID to edit: ";
    std::cin >> taskId;
    for (Task& task : tasks) {
        if (task.id == taskId) {
            std::string newDescription;
            std::cout << "Enter the new task description: ";
            std::cin.ignore();
            std::getline(std::cin, newDescription);
            task.description = newDescription;
            std::cout << "Task edited successfully!\n";
            return;
        }
    }
    std::cout << "Task with ID " << taskId << " not found.\n";
}

// Function to remove a task
void removeTask(std::vector<Task>& tasks) {
    int taskId;
    std::cout << "Enter the task ID to remove: ";
    std::cin >> taskId;
    for (auto it = tasks.begin(); it != tasks.end(); ++it) {
        if (it->id == taskId) {
            tasks.erase(it);
            std::cout << "Task removed successfully!\n";
            return;
        }
    }
    std::cout << "Task with ID " << taskId << " not found.\n";
}

int main() {
    std::vector<Task> tasks;
    int taskId = 1;
    char choice;

    while (true) {
        std::cout << "\nMenu:\n";
        std::cout << "1. Add Task\n";
        std::cout << "2. Display Tasks\n";
        std::cout << "3. Edit Task\n";
        std::cout << "4. Remove Task\n";
        std::cout << "5. Quit\n";
        std::cout << "Enter your choice: ";
        std::cin >> choice;

        switch (choice) {
            case '1':
                addTask(tasks, taskId);
                break;
            case '2':
                displayTasks(tasks);
                break;
            case '3':
                editTask(tasks);
                break;
            case '4':
                removeTask(tasks);
                break;
            case '5':
                std::cout << "Exiting the program.\n";
                return 0;
            default:
                std::cout << "Invalid choice. Please try again.\n";
                break;
        }
    }

    return 0;
}
