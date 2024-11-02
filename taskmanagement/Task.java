/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmanagement;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author admin
 */
public class Task {

    private int id;
    private int taskTypeID;
    private String requirementName;
    private Date from, to;
    private String assignee;
    private String reviewer;
    private String effort;

    public Task() {
    }

    public Task(int id, int taskTypeID, String requirementName, Date from, Date to, String assignee, String reviewer, String effort) {
        this.id = id;
        this.taskTypeID = taskTypeID;
        this.requirementName = requirementName;
        this.from = from;
        this.to = to;
        this.assignee = assignee;
        this.reviewer = reviewer;
        this.effort = effort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskTypeID() {
        return taskTypeID;
    }

    public void setTaskTypeID(int taskTypeID) {
        this.taskTypeID = taskTypeID;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getEffort(String unit, int quantity) {
        //Chuyển sang đơn vị ngày
        switch (unit.toUpperCase()) {
            case "H":
                // 1 giờ = 1/24 ngày
                effort = String.format("%.5f Days", quantity / 24.0);
                break;
            case "D":
                // 1 ngày = 1 ngày
                effort = String.format("%d Days", quantity);
                break;
            case "W":
                // 1 tuần = 7 ngày
                effort = String.format("%d Days", quantity * 7);
                break;

            default:
                throw new IllegalArgumentException("đơn vị không hợp lệ " + unit);

        }
        return effort;
    }

    public void setEffort(String effort) {
        this.effort = effort;
    }

    @Override
    public String toString() {
        // xóa from to đi và thời gian làm sẽ = to - from
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return String.format("%-10s %-15s %-10s %-15s %-10s %-10s %-15s %-15s\n",
                id, getTaskType(), requirementName, dateFormat.format(from), dateFormat.format(to), assignee, reviewer, effort);
    }

    // Hàm đổi từ code, test, design, review
    public String getTaskType() {

        switch (taskTypeID) {
            case 1:
                return "Code";

            case 2:
                return "Test";

            case 3:
                return "Design";

            case 4:
                return "Review";

        }
        return null;
    }

}
