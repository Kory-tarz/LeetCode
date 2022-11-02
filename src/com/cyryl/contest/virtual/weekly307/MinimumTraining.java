package com.cyryl.contest.virtual.weekly307;

public class MinimumTraining {
    public int minNumberOfHours(int energy, int experience, int[] oppEnergy, int[] oppExperience) {
        int requiredTraining = 0;
        for (int i = 0; i < oppEnergy.length; i++) {
            if(energy <= oppEnergy[i]){
                requiredTraining += oppEnergy[i] - energy + 1;
                energy = oppEnergy[i] + 1;
            }
            if(experience <= oppExperience[i]){
                requiredTraining += oppExperience[i] - experience + 1;
                experience = oppExperience[i] + 1;
            }
            energy -= oppEnergy[i];
            experience += oppExperience[i];
        }
        return requiredTraining;
    }
}
