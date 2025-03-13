package org.ObserverPattern;

import java.util.ArrayList;
import java.util.List;


interface Member {
    void update(String taskName, String status);
}


class ConcreteTeamMember implements Member {
    private String name;

    public ConcreteTeamMember(String name) {
        this.name = name;
    }

    @Override
    public void update(String taskName, String status) {
        System.out.println("Team Member " + name + " notified: Task '" + taskName + "' changed to " + status);
    }
}


interface Task {
    void registerMember(Member member);
    void removeMember(Member member);
    void notifyMembers();
}

class ConcreteTask implements Task {
    private String name;
    private String status;
    private List<Member> members = new ArrayList<>();

    public ConcreteTask(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyMembers();
    }

    @Override
    public void registerMember(Member member) {
        members.add(member);
    }

    @Override
    public void removeMember(Member member) {
        members.remove(member);
    }

    @Override
    public void notifyMembers() {
        for (Member member : members) {
            member.update(name, status);
        }
    }
}

public class TaskDemo {
    public static void main(String[] args) {
        ConcreteTask taskX = new ConcreteTask("Feature X", "To Do");
        ConcreteTask taskY = new ConcreteTask("Bug Y", "To Do");

        Member member1 = new ConcreteTeamMember("Van Cao");
        Member member2 = new ConcreteTeamMember("Thi Mau");
        Member member3 = new ConcreteTeamMember("Cau Vang");
        Member member4 = new ConcreteTeamMember("Lao Hat"); // khong lam gi

        taskX.registerMember(member1);
        taskX.registerMember(member2);
        taskY.registerMember(member3);

        System.out.println("Initial task status: To Do");

        // Continuous loop changing task status every 10 seconds
        String[] statuses = {"In Progress", "Code Review", "Testing", "Done"};
        int index = 0;

        while (true) {

            String newStatus = statuses[index % statuses.length];
            System.out.println("\nTask status changing...");
            taskX.setStatus(newStatus);
            taskY.setStatus(newStatus);
            index++;

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
