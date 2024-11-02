/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmanagement;

/**
 *
 * @author admin
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Validation {

    public final String REGEX_STRING = "[a-zA-Z0-9 ]+";
    public final String REGEX_NAME = "[a-zA-Z ]+";

    public int getInteger(String message, String firstError, String secondError, String thirdError, double min,
            double max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // vòng lặp while sẽ dừng lại khi gặp điều kiện đúng
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Không được để trống!");
                } else {
                    int number = Integer.parseInt(input);
                    if (number < min) {
                        System.out.println(firstError);
                    } else if (number > max) {
                        System.err.println(secondError);
                    } else {
                        return number;
                    }
                }
            } catch (Exception e) {
                System.err.println(thirdError);
            }
        }
    }

    public String getString(String message, String error, String regex) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.print(message);
            String input = scanner.nextLine().trim(); // trim xóa dấu space
            if (input.isEmpty()) {
                System.out.println("Input's invalid, type it again!");
            } else {
                if (input.matches(regex)) {
                    return input;
                } else {
                    System.err.println(error);
                }
            }
        }

    }

    public double getDouble(String message, String firstError, String secondError,
            String thirdError, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                double number = Double.parseDouble(input);

                // check range
                if (number > max) {
                    System.out.println(firstError);
                } else if (number < min) {
                    System.out.println(secondError);
                } else if (number % 0.5 != 0) {
                    System.out.println("Must be modulo 0.5");
                } else {
                    return number;
                }
            } catch (Exception e) {
                System.out.println(thirdError);
            }
        }
    }

    
    //Hàm tìm kiếm task có id trùng với id tìm kiếm
    public Task getTaskByID(List<Task> list, int id) {
        for (Task task : list) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    //Hàm check over time nếu có bị trùng time với ca làm từ trước hay không
    public boolean checkOverLabs(List<Task> list, String assignee, Date from, Date to) {
        for (Task task : list) {
            //Nếu mà date, assignee của task mà trùng thì tiến hành compare thời gian
            if (task.getAssignee() == assignee) {
               
                if(task.getFrom().after(to)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Date getDate(String mess, String error) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(mess);
            String input = sc.nextLine();

            // Kiểm tra định dạng đầu vào
            if (!input.matches("^\\d{1,2}-\\d{1,2}-\\d{4}$")) {
                System.out.println("Please enter the date in the correct format (dd-MM-yyyy)");
            } else {
                // Khởi tạo đối tượng SimpleDateFormat để phân tích chuỗi input thành đối tượng Date
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                dateFormat.setLenient(false); // Đảm bảo ngày hợp lệ

                try {
                    // Parse chuỗi đầu vào về kiểu Date và trả về
                    return dateFormat.parse(input);

                } catch (Exception e) {
                    System.out.println(error);
                }
            }
        }
    }

}
