package Week_9.Practice;
public class VotingSystem {
    public void processVote(String voterId, String candidate) {
        class VoteValidator {
            public boolean validate(String id) {
                return id != null && id.matches("VOTER\\d{4}");
            }
        }
        VoteValidator validator = new VoteValidator();
        if (validator.validate(voterId)) {
            System.out.println("Vote recorded for " + candidate + " by voter " + voterId);
        } else {
            System.out.println("Invalid voter ID: " + voterId);
        }
    }
    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        system.processVote("VOTER1234", "Alice");
        system.processVote("1234VOTER", "Bob");
        system.processVote(null, "Charlie");
    }
}