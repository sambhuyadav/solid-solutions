public class Main {
    public static void main(String[] args) {
        System.out.println("=== Student Onboarding ===");
        FakeDb db = new FakeDb();
        StudentRepository repo = db;
        OnboardingService svc = new OnboardingService(repo);

        String raw = "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";
        svc.registerFromRawInput(raw);

        System.out.println();
        System.out.println("-- repo DUMP --");
        System.out.print(TextTable.render3(db));
    }
}
