class Classroom:
    def __init__(self, name, level, score, weight):
        self.name = name
        self.level = level
        self.score = score
        self.weight = weight

    def get_weighted_gpa(self):
        score = self.score

        if score >= 97:
            credits = 5.3
        elif score >= 93:
            credits = 5.0
        elif score >= 90:
            credits = 4.7
        elif score >= 87:
            credits = 4.3
        elif score >= 83:
            credits = 4.0
        elif score >= 80:
            credits = 3.7
        elif score >= 77:
            credits = 3.3
        elif score >= 73:
            credits = 3.0
        elif score >= 70:
            credits = 2.7
        elif score >= 67:
            credits = 2.3
        elif score >= 63:
            credits = 2.0
        elif score >= 60:
            credits = 1.7
        else:
            return 0.0

        if self.level == 2:
            credits -= 0.5
        elif self.level == 3:
            credits -= 1.0

        return credits * self.weight