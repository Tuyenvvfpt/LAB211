/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Task;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class TaskBO {
    List<Task> list;

    public TaskBO() {
        list = new ArrayList<>();
    }

    public List<Task> getList() {
        return list;
    }
    
    
    
    
    public int addTask(String requirement, int taskType, String date, double from,
            double to, String assignee, String reviewer) {
        //kiem tra xem co bi duplicate hay k
        //bi duplicate -> return -1 
        if (checkOverlaps(date, assignee, from, to)) {
            return -1;
        }else {
            Task task = new Task(taskType, requirement, date, from, to, assignee, reviewer);
            list.add(task);
            return task.getId();
        }
        
        //ko bi duplicate -> return id task
    }
    
    //ham de kiem tra xem tat ca cac thuoc tinh nhap vao co ko bi overlaps ko
    // => true => bi overlaps
    // => false => ko bi overlaps
    public boolean checkOverlaps(String date, String assignee, double from, double to) {

        //parameter: ki hieu la 2
        //task in list: ki hieu la 1
        for (Task task : list) {
            //if date and assignee of task equal to parameter then compare to plan To
            if (task.getDate().compareTo(date) == 0 && task.getAssignee().compareTo(assignee) == 0) {

                /*NOTE
            	 * from2 : parameter (user add on method "add task")
            	 * from1 : from of task already in list 
            	 * to2   : parameter ( user add on method "add task")
            	 * to1   : to of task already in list
            	 * */
                //if from2 < from1 && to2 > from1
                if (from < task.getPlanFrom() && to > task.getPlanFrom()) {
                    return true;
                }
                //if from2 = from1 => return true
                if (from == task.getPlanFrom() ) {
                    return true;
                }
                // if from2 > from1 and from2 < to1=> return true
                if (from > task.getPlanFrom()
                        && from < task.getPlanTo()) {
                    return true;
                }
            }
        }
        return false;
    }
    
}
