import java.util.*;

public class OnboardingService {
    private final Parser parser;
    private final StudentValidator validator;
    private final StudentRepository repo;
    private final ConfirmationPrinter printer;

    public OnboardingService(StudentRepository repo) { 
        this.parser = new Parser();
        this.validator = new StudentValidator();
        this.repo = repo; // Checkpoint D
        this.printer = new ConfirmationPrinter(); //Checkpoint E
     }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);

        //checkpoint B
        // Parsing is now handled by the parser class.
        Map<String, String> kv = parser.parse(raw);
        String[] fields = parser.extractStudentFields(kv);
        String name    = fields[0];
        String email   = fields[1];
        String phone   = fields[2];
        String program = fields[3];

       //Checkpoint C
       //Validation is now handled by StudentValidator class
       List<String> errors = validator.validate(name, email, phone, program);

        //Checkpoint E delegates the printing to Confrimation printer class.
        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(repo.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        repo.save(rec);
        
        //Checkpoint E delegates the printing to Confrimation printer class.
        printer.printSuccess(id,repo.count(), rec);
    }
}
