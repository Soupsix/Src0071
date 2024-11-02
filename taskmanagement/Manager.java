/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmanagement;

/**
 *
 * @author admin
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager {

    ArrayList<Task> list = new ArrayList<>();
    Validation validation = new Validation();
    Task task = new Task();
    int id = 0;

    public ArrayList<Task> getList() {
        return list;
    }

    public void data() {
//        list.add(new Task(1, 2, "Lao công", "21-10-2024", 3, 5, "Toan", "Truong"));
//        list.add(new Task(2, 2, "Lao công", "22-10-2024", 8, 10, "Toan", "Truong"));
//        list.add(new Task(3, 2, "Lao công", "23-10-2024", 12, 14, "Toan", "Truong"));
//        list.add(new Task(4, 2, "Lao công", "28-10-2024", 15, 16, "Toan", "Truong"));
    }

    public void getDataTask() {
        System.out.printf("%-10s %-15s %-10s %-15s %-10s %-10s %-15s %-15s\n",
                "ID", "TaskType", "Name", "From", "To", "Assignee", "Reviewer", "Effort");
        for (Task o : list) {
            System.out.println(o.toString());
        }
    }

    public void input() {
        // Nhập thông tin và Add vào trong List
        String requirementName, date, assignee, reviewer, effort;
        int taskType;
        Date from, to;

//        requirementName = validation.getString("Requrement name: ", "Wrong", validation.REGEX_NAME);
//        taskType = validation.getInteger("Task type: ", "Please input in range 1 - 4", "Please input in range 1 - 4", "Please input in range 1 - 4", 1, 4);
        from = validation.getDate("From: ", "Invalid");
        while (true) {
            try {
                to = validation.getDate("To: ", "Invalid"); //Need Carefully
                if (from.after(to)) {
                    System.out.println("Thời gian kết thúc ca làm việc không thể bé hơn thời gian bắt đầu!!!");
                } else {
                    break;
                }
            } catch (Exception e) {
            }

        }

        assignee = validation.getString("Assignee: ", "Wrong", validation.REGEX_NAME);
        reviewer = validation.getString("reviewer: ", "Wrong", validation.REGEX_NAME);

        while (true) {
            try {
                effort = validation.getString("Effort(ex: 1H, 2D, 3W): ", "Invalid", validation.REGEX_STRING);
                Pattern pattern = Pattern.compile("(\\d+)([HDW])");
                Matcher matcher = pattern.matcher(effort);

                if (matcher.matches()) {
                    int quantity = Integer.parseInt(matcher.group(1));
                    String unit = matcher.group(2).toUpperCase();

                    effort = task.getEffort(unit, quantity);
                    break;
                } else {
                    System.out.println("Invalid input, Please input such 1D, 2W, 3D...");
                }
            } catch (Exception e) {

            }

        }

        //Check xem có bị Duplicate về thời gian không!
        int result = addTask("a", 1, from, to, assignee, reviewer, effort);
        System.err.println("Added Successfuly!");
//        if (result == -1) {
//            System.err.println("Duplicate time");
//        } else {
//            System.out.println("Added Successfuly!");
//        }
    }

    //Delete Task 
    void deleteTask() {
        int id = validation.getInteger("Enter id: ", "Wrong", "Wrong", "Wrong", 0, Integer.MAX_VALUE);
        Task task = validation.getTaskByID(list, id);
        if (task == null) {
            System.out.println("Not found!!");
        } else {

            list.remove(task);
            System.err.println("Removed successfully!");

        }

    }

    //Check xem có bị trùng lặp thời gian không!
    public int addTask(String requirementName, int taskType, Date from,
            Date to, String assignee, String reviewer, String effort) {

        //Nếu như có trùng lặp ca làm việc thì trả về -1
//        if (validation.checkOverLabs(list, assignee, from, to)) {
//            return -1;
//        } else {
//            //id tăng lên 1
//            id += 1;
//            list.add(new Task(id, taskType, requirementName, from, to, assignee, reviewer));
//            return id;
//        }
        //id tăng lên 1 khi list có thêm 1 Task
        id += 1;
        list.add(new Task(id, taskType, requirementName, from, to, assignee, reviewer, effort));
        return id;
    }

}
