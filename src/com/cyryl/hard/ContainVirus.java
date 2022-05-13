package com.cyryl.hard;

public class ContainVirus {

    int[][] field;

    public int containVirus(int[][] isInfected) {
        field = isInfected;
        boolean pandemic = true;
        int wallsBuild = 0;
        Virus worstVirus;

        while(pandemic){
            worstVirus = findDanger();
            if(worstVirus.spread == 0)
                pandemic = false;
            else {
                clearPredictions();
                wallsBuild += buildWallsSpreadVirus(worstVirus.id);
            }
        }
        return wallsBuild;
    }

    private void clearPredictions(){
        for(int i=0; i< field.length; i++)
            for(int j=0; j<field[0].length; j++)
                if(field[i][j] < -1)
                    field[i][j] = 0;
    }

    private int buildWallsSpreadVirus(int id) {

        int wallCount = 0;

        for(int i=0; i<field.length; i++){
            for(int j=0; j< field[0].length; j++){
                if(field[i][j] == id) {
                    field[i][j] = -1; // virus is walled
                    wallCount += countWall(i, j);
                }
                if(field[i][j] > 1){
                    field[i][j] = 1; // set virus for next year
                    spreadAround(i, j);
                }
            }
        }
        return wallCount;
    }

    private int countWall(int i, int j){
        int count = 0;
        if(i+1 < field.length && (field[i+1][j] == 0 || field[i+1][j] == 1))
            count++;
        if(i-1 >= 0 && (field[i-1][j] == 0 || field[i-1][j] == 1))
            count++;
        if(j+1 < field[0].length && (field[i][j+1] == 0 || field[i][j+1] == 1))
            count++;
        if(j-1 >= 0 && (field[i][j-1] == 0 || field[i][j-1] == 1))
            count++;
        return count;
    }

    private void spreadAround(int i, int j) {
        if(i+1 < field.length && field[i+1][j] == 0)
            field[i+1][j] = 1;
        if(i-1 >= 0 && field[i-1][j] == 0)
            field[i-1][j] = 1;
        if(j+1 < field[0].length && field[i][j+1] == 0)
            field[i][j+1] = 1;
        if(j-1 >= 0 && field[i][j-1] == 0)
            field[i][j-1] = 1;
    }

    public Virus findDanger(){

        int id = 2;
        int spread;
        int maxSpread = 0;
        Virus virus = new Virus();

        for(int i=0; i<field.length; i++){
            for(int j=0; j<field[0].length; j++){
                if(field[i][j] == 1) {
                    spread = checkSpread(i, j, id);
                    maxSpread = Math.max(maxSpread, spread);
                    if (spread == maxSpread) {
                        virus.id = id;
                        virus.spread = maxSpread;
                    }
                    id++;
                }
            }
        }
        return virus;
    }

    private int checkSpread(int i, int j, int id) {
        int spreadCount = 0;

        field[i][j] = id;

        if(i+1 < field.length)
            spreadCount += predictSpread(i+1, j, id);
        if(i-1 >= 0)
            spreadCount += predictSpread(i-1, j, id);
        if(j+1 < field[0].length)
            spreadCount += predictSpread(i, j+1, id);
        if(j-1>= 0)
            spreadCount += predictSpread(i, j-1, id);

        return spreadCount;
    }

    private int predictSpread(int i, int j, int id){
        int spreadCount = 0;
        if(field[i][j] == 0 || (field[i][j] < -1 && field[i][j] != id *-1)) {
            field[i][j] = id * -1;
            spreadCount++;
        }
        else if (field[i][j] == 1) {
            spreadCount += checkSpread(i, j, id);
        }
        return spreadCount;
    }

    private class Virus{
        int spread;
        int id;

        public Virus(){
            spread = 0;
            id = 0;
        }
    }
}
