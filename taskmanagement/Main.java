/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taskmanagement;

/**
 *
 * @author admin
 */


public class Main {
    public static void main(String[] args) {
        
      Validation validation = new Validation();
      Manager mng = new Manager();
        mng.data();
        //Ủa sao không để id = 0 nhỉ ta
        
        
        while (true) {            
        displayMenu();
        
            int option = validation.getInteger("Enter option: ", "Wrong!", "Wrong", "Wrong", 1, 4);
            switch (option) {
                case 1:
                    mng.input();
                    break;
                case 2: 
                    mng.deleteTask();
                    break;
                case 3: 
                    mng.getDataTask();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    private static void displayMenu() {
        System.out.println("========= Task program =========\n   1. Add Task\n   2. Delete task\n   3. Display Task\n   4. exit");
    }
}

