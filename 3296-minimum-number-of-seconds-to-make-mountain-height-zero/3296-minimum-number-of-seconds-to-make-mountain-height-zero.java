class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long answer=Integer.MIN_VALUE;
        PriorityQueue<Worker> pq=new PriorityQueue(new WorkerComparator());
        int workerSize=workerTimes.length;
        for(int i=0;i<workerSize;i++){
            Worker worker=new Worker();
            worker.setValue(workerTimes[i]);
            worker.setCurrentValue(workerTimes[i]);
            worker.setNumberOfWorker(1);
            pq.add(worker);
        }
        for(int i=0;i<mountainHeight;i++){
            Worker worker=pq.poll();
            long value=worker.getValue();
            int noOfWorker=worker.getNumberOfWorker();
            long currentValue=worker.getCurrentValue();
            answer=Math.max(currentValue,answer);
            // System.out.println(answer);
            int newNoOfOWorker=noOfWorker+1;
            long newValue=currentValue+value*newNoOfOWorker;
            // System.out.println(newValue);
            worker.setCurrentValue(newValue);
            worker.setNumberOfWorker(newNoOfOWorker);
            pq.add(worker);
        }
        // while(!pq.isEmpty()){
        //     System.out.println(pq.poll().getCurrentValue());
        // }
        return answer;
    }   
}
class WorkerComparator implements Comparator<Worker>{
    public int compare(Worker w1, Worker w2) {
        if(w1.getCurrentValue()
                <=w2.getCurrentValue()){
            return -1;
        }
        else{
            return 1;
        }          
    }
}
class Worker{
    private long value;
    private long currentValue;
    private int numberOfWorker;
    public long getValue(){
        return this.value;
    }
    public void setValue(long value){
        this.value=value;
    }
    public long getCurrentValue(){
        return this.currentValue;
    }
    public void setCurrentValue(long currentValue){
        this.currentValue=currentValue;
    }
    public int getNumberOfWorker(){
        return this.numberOfWorker;
    }
    public void setNumberOfWorker(int numberOfWorker){
        this.numberOfWorker=numberOfWorker;
    }
}