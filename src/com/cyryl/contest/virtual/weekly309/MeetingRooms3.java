package com.cyryl.contest.virtual.weekly309;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms3 {
    public int mostBooked(int n, int[][] meetings) {
        final int END = 1;
        final int START = 0;
        final int ROOM = 0;
        PriorityQueue<Integer> emptyRooms = new PriorityQueue<>();
        int[] roomMeetings = new int[n];
        for (int i = 0; i < n; i++) {
            emptyRooms.offer(i);
        }
        PriorityQueue<int[]> activeMeetings = new PriorityQueue<>((a, b) -> a[END] == b[END] ? a[ROOM] - b[ROOM] : a[END] - b[END]);
        PriorityQueue<int[]> futureMeetings = new PriorityQueue<>((a, b) -> a[START] - b[START]);
        for (int[] meeting : meetings) {
            futureMeetings.offer(meeting);
        }
        while (!futureMeetings.isEmpty()) {
            int[] currMeeting = futureMeetings.poll();
            while (!activeMeetings.isEmpty() && activeMeetings.peek()[END] <= currMeeting[START]) {
                int[] finishedMeeting = activeMeetings.poll();
                emptyRooms.offer(finishedMeeting[ROOM]);
            }
            if (!emptyRooms.isEmpty()) {
                int room = emptyRooms.poll();
                roomMeetings[room]++;
                activeMeetings.offer(new int[]{room, currMeeting[END]});
            } else {
                int[] meeting = activeMeetings.poll();
                roomMeetings[meeting[ROOM]]++;
                int timeShift = currMeeting[END] - currMeeting[START];
                activeMeetings.offer(new int[]{meeting[ROOM], meeting[END] + timeShift});
            }
        }
        int max = 0;
        int roomIdx = 0;
        for (int i = 0; i < roomMeetings.length; i++) {
            if(roomMeetings[i] > max){
                max = roomMeetings[i];
                roomIdx = i;
            }
        }
        return roomIdx;
    }
}
