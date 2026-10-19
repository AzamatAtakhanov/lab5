package StudyTracker;

public class Subject {
    private String name;
    private int studyTime = 0;

    public Subject(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStudyTime(int time) {
        studyTime += time;
    }

    public int getStudyTime() {
        return studyTime;
    }
}
