package com.cyryl.contest.virtual.weekly317;

import java.util.*;
import java.util.stream.Collectors;

public class VideoCreator {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Integer> popularity = new HashMap<>();
        Map<String, Video> bestVideo = new HashMap<>();

        for (int i = 0; i < creators.length; i++) {
            popularity.put(creators[i], popularity.getOrDefault(creators[i], 0) + views[i]);
            Video video = bestVideo.getOrDefault(creators[i], new Video());
            int likes = video.likes;
            String best = video.id;
            if (views[i] > likes || (views[i] == likes && ids[i].compareTo(best) < 0)) {
                System.out.println("BEST: " + best + " likes: " + likes + "CURR: " + ids[i] + " likes " + views[i]);
                bestVideo.put(creators[i], new Video(ids[i], views[i]));
            }
        }
        List<Map.Entry<String, Integer>> ranking = popularity
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .collect(Collectors.toList());
        int bestPop = ranking.get(0).getValue();
        List<List<String>> result = new ArrayList<>();
        int i = 0;
        while (i < ranking.size() && ranking.get(i).getValue() == bestPop) {
            List<String> person = new ArrayList<>();
            String name = ranking.get(i).getKey();
            person.add(name);
            person.add(bestVideo.get(name).id);
            result.add(person);
            i++;
        }
        return result;
    }

    private class Video{
        String id;
        int likes;
        public Video(String id, int likes) {
            this.id = id;
            this.likes = likes;
        }

        public Video(){
            this.id = "#";
            this.likes = -1;
        }
    }
}
