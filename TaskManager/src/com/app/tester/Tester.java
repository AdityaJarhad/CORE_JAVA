package com.app.tester;

import static com.app.utils.Utils.populateList;
import static com.app.utils.Utils.populateMap;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.app.core.Status;
import com.app.core.Task;

public class Tester {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			Map<Integer, Task> map = populateMap(populateList());
			Task task;
			boolean exit = false;
			while (!exit) {
				System.out.println("\nEnter "
						+"1. Add New Task\n"
						+"2. Delete a task\n"
						+"3. Update task status\n"
						+"4. Display all pending tasks\n"
						+"5. Display all pending tasks for today\n"
						+"6. Display all tasks sorted by taskDate\n"
						+"7. Display all task history\n"
						+"0. Exit");
				try {
					switch (sc.nextInt()) {
					case 1:	//1. Add New Task
						System.out.println("Enter taskName, description, taskDate");
						task = new Task(sc.next(), sc.next(), LocalDate.parse(sc.next()));
						map.put(task.getTaskId(), task);
						System.out.println("Added successfully!");
						break;
					case 2:
						//2. Delete a task
						System.out.println("Enter taskId");
						int a = sc.nextInt();
						map.remove(a);
						break;
					case 3:
						//3. Update task status
						System.out.println("Enter taskid");
						int id = sc.nextInt();
						System.out.println("Enter status");
						map.forEach((k,v) -> {
							if(v.getTaskId() == id) {
								v.setStatus(Status.valueOf(sc.next().toUpperCase()));
								v.setActive(false);
								System.out.println("Task completed...");
							}
						});
						break;
					case 4:
						map.forEach((k, v) -> {
							if (v.getStatus().toString().equals("pending".toUpperCase())) {
								System.out.println(v);
							}
						});
						break;
					case 5:
						//5. Display all pending tasks for today
						map.forEach((k,v) -> {
							if(v.getTaskDate().equals(LocalDate.now()) && v.getStatus().equals(Status.PENDING)) {
								System.out.println(v);
							}
						});
						break;
					case 6:
						//6. Display all tasks sorted by taskDate
						Comparator<Task> comp = (i1, i2) -> i1.getTaskDate().compareTo(i2.getTaskDate()) ;
						List<Task> list1 = map.values()
						.stream()
						.sorted(comp)
						.collect(Collectors.toList());
						list1.forEach(l -> System.out.println(l));
						break;
					case 7:
						map.forEach((k,v) -> System.out.println(v));
						break;
					default:
						exit = true;
						break;
					}
				} catch (Exception e) {
					sc.nextLine();
					e.printStackTrace();
				}
						
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
