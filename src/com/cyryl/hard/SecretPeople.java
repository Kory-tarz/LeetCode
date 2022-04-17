package com.cyryl.hard;

import java.util.*;

public class SecretPeople {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<Integer>> meetingsAtTime = new TreeMap<>();
        UnionFind unionFind = new UnionFind(n);
        List<Integer> initiated = new ArrayList<>();

        for(int i=0; i< meetings.length; i++){
            int meetingTime = meetings[i][2];
            meetingsAtTime.putIfAbsent(meetingTime, new ArrayList<>());
            meetingsAtTime.get(meetingTime).add(i);
        }

        unionFind.union(0, firstPerson);

        for(int timeIndex : meetingsAtTime.keySet()){

            Set<Integer> participants = new HashSet<>();

            for(int time : meetingsAtTime.get(timeIndex)) {
                unionFind.union(meetings[time][0], meetings[time][1]);

                participants.add(meetings[time][0]);
                participants.add(meetings[time][1]);
            }

            for(int person : participants){
                if (!unionFind.isUnion(person, 0))
                    unionFind.removeFromUnion(person);
            }
        }
        for(int i=0; i<n; i++)
            if(unionFind.isUnion(i, 0))
                initiated.add(i);

        return initiated;
    }

    private class UnionFind{

        int[] parent;
        int[] rank;

        public UnionFind(int n){

            parent = new int[n];
            rank = new int[n];

            for(int i=0; i<parent.length; i++){
                parent[i] = i;
            }
        }

        public void union(int person, int otherPerson){

            int personParent = find(person);
            int otherPersonParent = find(otherPerson);

            if(personParent == otherPersonParent)
                return;

            if(rank[personParent] > rank[otherPersonParent])
                parent[otherPersonParent] = personParent;
            else if (rank[otherPersonParent] > rank[personParent])
                parent[personParent] = otherPersonParent;
            else{
                parent[otherPersonParent] = personParent;
                rank[personParent]++;
            }
        }

        public int find(int person) {

            if (parent[person] != person) {
                parent[person] = find(parent[person]);
            }
//            System.out.println("Parent: " + person);
            return parent[person];
        }

        public void removeFromUnion(int person){
            parent[person] = person;
        }

        public boolean isUnion(int person, int otherPerson){
            return find(person) == find(otherPerson);
        }

        public void unionPrint(){
            for(int p=0; p<parent.length; p++)
                System.out.println("Person: " + p + " Parent: " + parent[p] + " Rank: " + rank[p]);
            System.out.println();
        }

    }
}
