package hr.fer.zemris.java.custom.collections;

public class Problem1 {

	public static void main(String[] args) {
		ArrayBackedIndexedCollection ic = new ArrayBackedIndexedCollection();
		System.out.println(ic.isEmpty());
		ic.add("jedan");
		ic.add("dva");
		ic.add("tri");
		
		ic.add("cetiri");
		ic.insert("jedan i pol", 0);
		ic.remove(0);
		System.out.println(ic.indexOf("cetiri"));
		System.out.println("kap: " + ic.getCapacity());
		System.out.println("size: " + ic.size());
		for (int i = 0; i<ic.size(); i++)
			System.out.println(ic.get(i));
	}

}
