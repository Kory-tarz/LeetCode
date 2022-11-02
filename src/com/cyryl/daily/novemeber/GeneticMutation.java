package com.cyryl.daily.novemeber;

import java.util.*;

public class GeneticMutation {

    private final static char[] GENES = {'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankData = new HashSet<>(Arrays.stream(bank).toList());
        if (!bankData.contains(end)) {
            return -1;
        }
        bankData.add(start);
        Map<String, Integer> mutationsToEnd = new HashMap<>();
        mutationsToEnd.put(end, 0);
        bankData.remove(end);
        Queue<String> geneQueue = new LinkedList<>();
        geneQueue.offer(end);
        while (!geneQueue.isEmpty()) {
            String currGene = geneQueue.poll();
            bankData.remove(currGene);
            StringBuilder geneBuilder = new StringBuilder(currGene);
            for (int i = 0; i < currGene.length(); i++) {
                char originalGene = currGene.charAt(i);
                for (char gene : GENES) {
                    geneBuilder.setCharAt(i, gene);
                    String mutatedGene = geneBuilder.toString();
                    if (bankData.contains(mutatedGene) && !mutationsToEnd.containsKey(mutatedGene)) {
                        mutationsToEnd.put(mutatedGene, mutationsToEnd.get(currGene) + 1);
                        geneQueue.offer(mutatedGene);
                    }
                }
                geneBuilder.setCharAt(i, originalGene);
            }
        }
        return mutationsToEnd.getOrDefault(start, -1);
    }
}
