package data;

public class Station {
	public int id;
	public Scooter[] slot;
	private int slotSize;

	public Station() {

	}

	public Station(int id, int slotSize) {
		this.id = id;
		this.slotSize = slotSize;
		slot = new Scooter[slotSize];
	}
	
	public int getId() {
		return this.id;
	}
	
	/* 返回station的非空slot数量 */
	public int size() {
		int count = 0;
		for(int i = 0; i < this.slotSize; i++) {
			if(slot[i] != null) {
				count++;
			}
		}
		return count;
	}
	
	/* 判断station是否slot全占满了 */
	public boolean isFull() {
		return this.size() == this.slotSize;
	}
	
	/* 判断station是否slot全为空 */
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	/* 添加成功返回true， 添加失败返回false */
	public boolean addScooter(Scooter item) {
		if (this.isFull()) {
			return false;
		}
		else {
			for (int i = 0; i < this.slotSize; i++) {
				if (slot[i] == null) {
					slot[i] = item;
					break;
				}
			}
			return true;
		}
	}
	
	/* remove成功返回scooter，remove失败返回null */
	public Scooter removeScooter(int slotId) {
		return this.slot[slotId];
	}


}
