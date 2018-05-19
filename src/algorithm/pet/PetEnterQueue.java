package algorithm.pet;
/**
 * 
 *
 * @author 艾亮方
 * @date 2018年3月23日   下午11:17:32
 * @version 1.0
 **/
public class PetEnterQueue {
	
	private Pet pet;
	
	private long time;
	
	public PetEnterQueue(Pet pet,long time) {
		this.pet = pet;
		this.time = time;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
}
