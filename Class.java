public class Class {
    private String name;
    private int score;
    private int level;
    private double yearsTaken;
    
    public Class() {}
    
    public Class(String name, int score, int level, double yearsTaken) {
        this.name = name;
        
        if (0 <= score && score <= 100) {
            this.score = score;
        } else {
            throw new IllegalArgumentException("Invalid score: " + score);
        }
        
        if (1 <= level && level <= 3) {
            this.level = level;
        } else {
            throw new IllegalArgumentException("Invalid level: " + level);
        }
        
        if (0 < yearsTaken && yearsTaken <= 4) {
            this.yearsTaken = yearsTaken;
        } else {
            throw new IllegalArgumentException("Invalid yearsTaken: " + yearsTaken);
        }
    }
    
    public String getName() {
        return name;
    }
    
    public int getScore() {
        return score;
    }
    
    public int getLevel() {
        return level;
    }
    
    public double getYearsTaken() {
        return yearsTaken;
    }
    
    /* MHS weighted GPA
    public double getWeightedCredits() {
        double credits = 0.0;
        
        if (score >= 97) {
            credits = 5.3;
        } else if (score >= 93) {
            credits = 5.0;
        } else if (score >= 90) {
            credits = 4.7;
        } else if (score >= 87) {
            credits = 4.3;
        } else if (score >= 83) {
            credits = 4.0;
        } else if (score >= 80) {
            credits = 3.7;
        } else if (score >= 77) {
            credits = 3.3;
        } else if (score >= 73) {
            credits = 3.0;
        } else if (score >= 70) {
            credits = 2.7;
        } else if (score >= 67) {
            credits = 2.3;
        } else if (score >= 63) {
            credits = 2.0;
        } else if (score >= 60) {
            credits = 1.7;
        } else { //score < 60
            credits = 0.0;
        }
        
        if (level == 3) { //reduce to College Prep credits
            credits -= 1.0;
        } else if (level == 2) { //reduce to Honors credits
            credits -= 0.5;
        } //otherwise, keep Advanced Placement credits
        
        return credits * yearsTaken;
    }
    */
    
    //possible 5.0 scale
    public double getWeightedCredits() {
        double credits = (double) ((score - 50) / 10 + 1);
        
        if (score == 100) {
            credits -= 1.0;
        }
        
        if (level == 3) { //reduce to College Prep credits
            credits -= 1.0;
        } else if (level == 2) { //reduce to Honors credits
            credits -= 0.5;
        } //otherwise, keep Advanced Placement credits
        
        return credits * yearsTaken;
    }
    
    public double getMaxPotentialWeightedCredits() {
        double credits = 5.3;
        
        if (level == 3) { //reduce to College Prep credits
            credits -= 1.0;
        } else if (level == 2) { //reduce to Honors credits
            credits -= 0.5;
        } //otherwise, keep Advanced Placement credits
        
        return credits * yearsTaken;
    }
    
    public String toString() {
        return name + " " + score + " " + level + " " + yearsTaken;
    }
}