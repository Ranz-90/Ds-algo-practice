package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NMeetingInOneRoom {

    /* There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i])
    where start[i] is start time of meeting i and end[i] is finish time of meeting i.
    What is the maximum number of meetings that can be accommodated in the meeting room
    when only one meeting can be held in the meeting room at a particular time?

    Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.*/

/*    N = 6
    start[] = {1,3,0,5,8,5}
    end[] =  {2,4,6,7,9,9}
    Output:
            4
    Explanation:
    Maximum four meetings can be held with
    given start and end timings.
    The meetings are - (1, 2),(3, 4), (5,7) and (8,9)*/
    public static void main(String[] args){
        int start[] = {1,3,0,5,8,5};
        int end[] =  {2,4,6,7,9,9};
        int N = 6;

        List<Integer> listOfPerformedMeeting = maxMeeting(start, end, N);
        if(!listOfPerformedMeeting.isEmpty()){
            for(int meeting : listOfPerformedMeeting) {
                System.out.println(meeting);
            }
        }
    }

    private static List<Integer> maxMeeting(int[] start, int[] end, int n) {
        List<meeting> meetings = new ArrayList<>();
        //this will be output list where we will meeting number that can be performed like 1, 2, 4, etc
        List<Integer> outputList = new ArrayList<Integer>();

        //Add start, end and position start from 1 for each meeting object and add in the list
        for(int i=0; i < n; i++){
            meetings.add(new meeting(start[i], end[i],i+1));
        }

        //Sort the List<meeting> based on end time..and for same end time , it will store smallest position first

        MeetingComparator mc = new MeetingComparator();
        Collections.sort(meetings,mc);


        //Always 1st meeting needs to be performed, so lets add the 1st meeting
        outputList.add(meetings.get(0).pos);

        //Store the endTime of 1st meeting, so that we can start other which is starting after this end
        int endLimit = meetings.get(0).endTime;

        for(int i=1; i <n; i++){
            //if any meeting start after the current end time we will perform this
            if(meetings.get(i).startTime > endLimit){

                //update endLimit with current endTime that performed
                endLimit = meetings.get(i).endTime;
                //once we performed lets add tha meeting in the outputList
                outputList.add(meetings.get(i).pos);
            }
        }
      return outputList;
    }

}

//custom java class to stored meeting start Time , end time and position of meeting i.e 1st meeting, 2nd meeting so on

class meeting{

    public int startTime;
    public int endTime;
    public int pos;

    public meeting(int start, int end, int pos) {

        this.startTime = start;
        this.endTime = end;
        this.pos = pos;
    }
}

//comparator class to sort the meeting based on end time -- , we will be having List<meeting> which will be sorted based on endTime
//if two meeting has same start and end time, let say if 4th and 6th meeting having same start and end time
//then store the 4th meeting 1st in the list

class MeetingComparator implements Comparator<meeting> {

    @Override
    public int compare(meeting o1, meeting o2) {
        if(o1.endTime < o2.endTime) {
            return -1;
        }
        else if(o1.endTime > o2.endTime){
            return 1;
        }
        //make sure meeting with same start and end but with lowest position store first;
        else if(o1.pos < o2.pos){
            return -1;
            }

        return 1;
    }
}