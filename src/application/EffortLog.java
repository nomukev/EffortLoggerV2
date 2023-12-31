package application;

public class EffortLog {
	private String name; //name of this effort log
	private int effortValue; //USED FOR PLANNING POKER
	private int indexValue; //this log's index
	static int index = 1; //index of all effort logs
	private int weight; //weight for planning poker calculations
	//TODO: add more values required for effortlogger (dates, duration, defects, etc.)
	
	public EffortLog() {
		this.indexValue = index;
		this.name = ("EffortLog " + indexValue);
		this.effortValue = 5; //default value for effort value
		this.weight = 2; //default value for weight
		index++;
	}
	
	public EffortLog(int effortValue, int weight) {
		this.indexValue = index;
		this.name = ("EffortLog " + indexValue);
		this.effortValue = effortValue;
		this.weight = weight;
		index++;
	}
	
	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEffortValue() {
		return effortValue;
	}

	public void setEffortValue(int effortValue) {
		this.effortValue = effortValue;
	}

	public int getIndexValue() {
		return indexValue;
	}

	public void setIndexValue(int indexValue) {
		this.indexValue = indexValue;
	}

	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		EffortLog.index = index;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	//custom methods
	@Override
	public String toString() {
		return name;
	}
}
