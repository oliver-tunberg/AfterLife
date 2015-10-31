package model;

public class Timer {

    private double timeA;
    private double timeB;
    private double limit;
    private boolean completed;

    public Timer(double limit){
        this.limit = limit;

    }

    public void useTimer(){

        if(!completed){
            exercise();
        }

    }

    private void exercise(){
        if(timeA==0){
            timeA = System.nanoTime();
        }

        timeB = System.nanoTime();

        double delta = (timeB - timeA)/1000000000.0;

        if(limit <= delta){

            setCompleted(true);

        }
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }




}
