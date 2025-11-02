package org.example.entity;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTask;
    private Set<Task> bobsTask;
    private Set<Task> carolsTask;
    private Set<Task> unassignedTask;

    public TaskData(Set<Task> annsTask, Set<Task> bobsTask, Set<Task> unassignedTask, Set<Task> carolsTask) {
        this.annsTask = annsTask;
        this.bobsTask = bobsTask;
        this.unassignedTask = unassignedTask;
        this.carolsTask = carolsTask;
    }

    public Set<Task> getTasks(String name) {
        switch (name) {
            case "ann":
                return this.annsTask;
            case "bob":
                return this.bobsTask;
            case "carol":
                return this.carolsTask;
            case "all":
                return getUnion(bobsTask, annsTask, carolsTask);
            default:
                return new HashSet<>();
        }
    }

    public Set<Task> getUnion(Set<Task> ... sets) {
        HashSet<Task> allTasks = new LinkedHashSet<>();
        for (Set<Task> tasks : sets) {
            allTasks.addAll(tasks);
        }
        return allTasks;
    }

    public Set<Task> getIntersection(Set<Task> set1, Set<Task> set2) {
        Set<Task> intersect = new HashSet<>(set1);
                intersect.retainAll(set2);
         return intersect;
    }

    public Set<Task> getDifferences(Set<Task> set1, Set<Task> set2) {
        Set<Task> difference = new HashSet<>(set1);
                difference.removeAll(set2);
          return difference;
    }
}
