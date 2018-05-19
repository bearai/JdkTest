package algorithm.pet;
/**
 * 
 *
 * @author 艾亮方
 * @date 2018年3月23日   下午11:14:51
 * @version 1.0
 **/
public class Pet {

	private String name;
	private String type;

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public Pet(String type,String name) {
		this.type = type;
		this.name=name;
	}
	
}
