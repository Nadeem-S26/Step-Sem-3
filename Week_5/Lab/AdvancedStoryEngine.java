import java.io.Serializable; 
import java.util.*; 
 
public class AdvancedStoryEngine { 
    public static void main(String[] args) { 
        CharacterDNA dna1 = CharacterDNA.createRandomDNA(); 
        CharacterDNA dna2 = CharacterDNA.createFromTemplate("Hero"); 
 
        StoryCharacter hero = new HeroCharacter(dna1, "Aria", "Forest", 
"Brave", "Save the Kingdom"); 
        StoryCharacter villain = new VillainCharacter(dna2, "Draven", 
"Castle", "Dark", "Rule the World", "Forbidden Magic"); 
 
        StoryEngine engine = StoryEngine.getInstance(); 
        engine.registerCharacter(hero); 
        engine.registerCharacter(villain); 
 
        System.out.println(engine.generateNarrative()); 
    } 
 
    public static final class CharacterDNA implements Serializable { 
        private static final long serialVersionUID = 1L; 
        private final String geneticId; 
        private final String personalityType; 
        private final String[] innateTalents; 
        private final String characterArchetype; 
        private final Map<String, Integer> baseAttributes; 
 
        private CharacterDNA(String geneticId, String personalityType, 
String[] innateTalents, 
                             String characterArchetype, Map<String, 
Integer> baseAttributes) { 
            this.geneticId = geneticId; 
            this.personalityType = personalityType; 
            this.innateTalents = innateTalents.clone(); 
            this.characterArchetype = characterArchetype; 
            this.baseAttributes = Collections.unmodifiableMap(new 
HashMap<>(baseAttributes)); 
        } 
 
        public static CharacterDNA createRandomDNA() { 
            Random r = new Random(); 
            String id = UUID.randomUUID().toString(); 
            String personality = r.nextBoolean() ? "Bold" : "Cautious"; 
            String[] talents = {"Strength", "Wisdom"}; 
            String archetype = r.nextBoolean() ? "Hero" : "Villain"; 
            Map<String, Integer> attrs = new HashMap<>(); 
            attrs.put("Power", r.nextInt(100)); 
            attrs.put("Wisdom", r.nextInt(100)); 
            return new CharacterDNA(id, personality, talents, archetype, 
attrs); 
        } 
 
        public static CharacterDNA createFromTemplate(String template) { 
            String id = UUID.randomUUID().toString(); 
            String[] talents = {"Charisma"}; 
            Map<String, Integer> attrs = new HashMap<>(); 
            attrs.put("Power", 80); 
            attrs.put("Wisdom", 70); 
            return new CharacterDNA(id, template, talents, template, 
attrs); 
        } 
 
        public final boolean isCompatibleWith(CharacterDNA other) { 
            return 
!this.characterArchetype.equals(other.characterArchetype); 
        } 
 
        public String getGeneticId() { return geneticId; } 
        public String getPersonalityType() { return personalityType; } 
        public String[] getInnateTalents() { return innateTalents.clone(); 
} 
        public String getCharacterArchetype() { return characterArchetype; 
} 
        public Map<String, Integer> getBaseAttributes() { return new 
HashMap<>(baseAttributes); } 
    } 
 
    public static class StoryCharacter { 
        private final String characterId; 
        private final CharacterDNA dna; 
        private final long birthTimestamp; 
        private String currentName; 
        private String currentLocation; 
        private String emotionalState; 
        private final Map<String, String> relationships = new HashMap<>(); 
        private int experiencePoints; 
        private final Set<String> learnedSkills = new HashSet<>(); 
        static final String STORY_ENGINE_VERSION = "4.0"; 
        public static final String CHARACTER_SYSTEM_VERSION = "4.0"; 
 
        public StoryCharacter(CharacterDNA dna) { 
            this(dna, "Unnamed", "Unknown", "Neutral"); 
        } 
 
        public StoryCharacter(CharacterDNA dna, String name) { 
            this(dna, name, "Unknown", "Neutral"); 
        } 
 
        public StoryCharacter(CharacterDNA dna, String name, String 
startLocation, String mood) { 
            if (dna == null) throw new IllegalArgumentException("DNA required"); 
            this.dna = dna; 
            this.characterId = UUID.randomUUID().toString(); 
            this.birthTimestamp = System.currentTimeMillis(); 
            this.currentName = name; 
            this.currentLocation = startLocation; 
            this.emotionalState = mood; 
        } 
 
        public String getCharacterId() { return characterId; } 
        public CharacterDNA getDna() { return dna; } 
        public long getBirthTimestamp() { return birthTimestamp; } 
        public String getCurrentName() { return currentName; } 
        public void setCurrentName(String currentName) { this.currentName 
= currentName; } 
        public String getCurrentLocation() { return currentLocation; } 
        public void setCurrentLocation(String currentLocation) { 
this.currentLocation = currentLocation; } 
        public String getEmotionalState() { return emotionalState; } 
        public void setEmotionalState(String emotionalState) { 
this.emotionalState = emotionalState; } 
        public Map<String, String> getRelationships() { return 
relationships; } 
        public int getExperiencePoints() { return experiencePoints; } 
        public void addExperience(int points) { this.experiencePoints += 
points; } 
        public Set<String> getLearnedSkills() { return learnedSkills; } 
        public void learnSkill(String skill) { 
this.learnedSkills.add(skill); } 
 
        public String toString() { return currentName + " (" + 
dna.getCharacterArchetype() + ")"; } 
    } 
 
    public static class HeroCharacter extends StoryCharacter { 
        private final String destinyQuest; 
        private String heroicVirtue; 
        private final Set<String> defeatedEnemies = new HashSet<>(); 
        public HeroCharacter(CharacterDNA dna, String name, String loc, 
String mood, String destinyQuest) { 
            super(dna, name, loc, mood); 
            this.destinyQuest = destinyQuest; 
            this.heroicVirtue = "Courage"; 
        } 
        public String getDestinyQuest() { return destinyQuest; } 
        public String getHeroicVirtue() { return heroicVirtue; } 
        public void setHeroicVirtue(String heroicVirtue) { 
this.heroicVirtue = heroicVirtue; } 
        public Set<String> getDefeatedEnemies() { return defeatedEnemies; 
} 
    } 
 
    public static class VillainCharacter extends StoryCharacter { 
        private final String evilScheme; 
        private final String corruptionSource; 
        private int evilInfluence; 
        public VillainCharacter(CharacterDNA dna, String name, String loc, 
String mood, String evilScheme, String corruptionSource) { 
            super(dna, name, loc, mood); 
            this.evilScheme = evilScheme; 
            this.corruptionSource = corruptionSource; 
            this.evilInfluence = 50; 
        } 
        public String getEvilScheme() { return evilScheme; } 
        public String getCorruptionSource() { return corruptionSource; } 
        public int getEvilInfluence() { return evilInfluence; } 
        public void increaseInfluence(int amt) { evilInfluence += amt; } 
    } 
 
    public static final class StoryEngine { 
        private static final StoryEngine INSTANCE = new StoryEngine(); 
        private final Map<String, StoryCharacter> activeCharacters = new 
HashMap<>(); 
        private final String[] narrativeRules = {"Heroes oppose Villains", 
"Conflict creates story"}; 
        private StoryEngine() {} 
        public static StoryEngine getInstance() { return INSTANCE; } 
        void registerCharacter(StoryCharacter c) { 
activeCharacters.put(c.getCharacterId(), c); } 
        public final String generateNarrative() { 
            StringBuilder sb = new StringBuilder(); 
            sb.append("Narrative v1\n"); 
            for (StoryCharacter c : activeCharacters.values()) { 
                sb.append(c.toString()).append(" enters the story.\n"); 
            } 
sb.append("Rules: ").append(Arrays.toString(narrativeRules)); 
return sb.toString(); 
} 
} 
} 