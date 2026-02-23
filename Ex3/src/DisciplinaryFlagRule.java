// Fails eligibility if the student has any disciplinary flag.

//Checkpoint B
public class DisciplinaryFlagRule implements EligibilityRule {
    @Override
    public String check(StudentProfile student) {
        if (student.disciplinaryFlag != LegacyFlags.NONE) {
            return "disciplinary flag present";
        }
        return null;
    }
}

