public class Test {

public String title;
	public String identifier;
	public String itemType;
	public List<ResponseDeclaration> responseDeclarations = new ArrayList();
	public List<OutcomeDeclaration> outcomeDeclarations	  = new ArrayList();
	public List<Chunk> chunks = new ArrayList();
	public List<Interaction> interactions = new ArrayList();
	public List<QtiObject> qtiObjects = new ArrayList();
	public List<PositionObjectStage> positionObjectStages = new ArrayList();
	public ResponseProcessing responseProcessing;
	public String itemRawXml;
	public String error;
	public String client;
	public Boolean hasMathML;
	public Item item;
	public URL itemUrl;


    public ItemObject(String title, String identifier, Item item) {
    	this.title = title;
    	this.identifier = identifier;
    	this.item = item;
    	this.itemType = "Unknown";
    	this.hasMathML = false;
    }

    public int addChunk(String htmlStr, Boolean isInteraction) {
    	Chunk chunk = new Chunk(htmlStr, isInteraction);
    	chunks.add(chunk);
    	return chunks.size()-1;
    }

    public int addChunk(String htmlStr, Boolean isInteraction, Boolean isStage, int stageIndex) {
    	Chunk chunk = new Chunk(htmlStr, false, isStage, stageIndex);
    	chunks.add(chunk);
    	return chunks.size()-1;
    }


	public static void main(String[] args) {
		System.out.println("Hello World!!!"); //adding comment
	}
}