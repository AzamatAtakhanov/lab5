package ScreenTimeTracker;

public class Category {
    private String title;
    private int totalTime;
    private Type type;
    public Category(String title, Type type) {
        this.title = title;
        this.type = type;
    }
    public String getTitle() {
        return title;
    }
    public int getTotalTime() {
        return totalTime;
    }

    public void addTime(int time) {
        totalTime += time;
    }

    public Type getType() {
        return type;
    }
}

enum Type{
    Productive,
    Entertainment
}