import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSequencingProblem {

    public static void main(String[] args){

        List<job> listOfJobs = new ArrayList<>();
        listOfJobs.add(new job("a", 2, 100));
        listOfJobs.add(new job("b", 1, 19));
        listOfJobs.add(new job("c", 2, 27));
        listOfJobs.add(new job("d", 1, 25));
        listOfJobs.add(new job("e", 3, 15));

        int[] maxProfitAndTotalJobs = getMaxProfitAndTotalJobs(listOfJobs);

        for(int i : maxProfitAndTotalJobs){
            System.out.println(i);
        }

    }

    private static int[] getMaxProfitAndTotalJobs(List<job> listOfJobs) {

        int[] output = new int[2];
        int maxProfit =0;
        int jobCount = 0;
        int maxDeadline =0;
        output[0] = maxProfit;
        output[1]  = jobCount;
        List<String> jobsIdSequence = new ArrayList<>();

        //Step1: get maxDeadline from all jobs -- so that we can declare array with that size
        //such that we can try to see for all those days
        //we are covering all jobs or not

       for(int i =0; i <listOfJobs.size(); i ++){
           if(listOfJobs.get(i).deadline > maxDeadline){
               maxDeadline = listOfJobs.get(i).deadline;
           }
       }

       //Step2 : Declare array with size maxDeadlIne and fill it with -1 means that day is free
        //that day we have not perfomed any job

        int[] deadlines = new int[maxDeadline];
       for(int i =0; i <maxDeadline; i++){
           deadlines[i] = -1;
       }

        //Step3: Sort the job list by profit in desc order -- as we have asked to maximum profit
        //high profit will be 1st then low and so on

        Collections.sort(listOfJobs, new Comparator<job>() {
            @Override
            public int compare(job o1, job o2) {
                return o2.profit - o1.profit;
            }
        });

        //Step4: Iterate list of jobs and see if if deadline for each job can be
        //performed if there is free slot i.e -1 for that index in deadlines array
        //basically from job deadline to 0 we will check if any index in deadlines is havoinh -1 or not

        for(int i =0; i <listOfJobs.size(); i ++){
            for(int j =listOfJobs.get(i).deadline-1; j >=0; j-- ){

                //check for free slot till 0 idex in deadlines array
                //If yes job can be performed
                //so add the profit for that job

                if(deadlines[j] == -1){
                    //mark deadlines array with value to make sure it marked as performed
                    deadlines[j] = i;
                    maxProfit = maxProfit+listOfJobs.get(i).profit;
                    jobCount++;
                    jobsIdSequence.add(listOfJobs.get(i).jobId);
                    //once we have performed any job in a day we cant perform any job again, hence break
                    break;
                }
            }
        }


        //either it can ask to return max profit and total jobs
        return output;
        //else if its asks to return jobs sequence id
        //return jobsIdSequence.stream().toArray(String[] :: new);

    }
}

class job{

    int profit;
    int deadline;
    String jobId;

    public job(String jobId,int deadline, int profit) {
        this.profit = profit;
        this.deadline = deadline;
        this.jobId = jobId;
    }
}
