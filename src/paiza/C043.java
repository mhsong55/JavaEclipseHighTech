package paiza;

import java.util.*;

public class C043 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//	        int cashItemCount = Integer.parseInt(sc.next());
        int cashItemCount = (new Random().nextInt(1000) + 1);
        System.out.println("N: " + cashItemCount);
        List<String> playerIDList = new ArrayList<>();
        for (int i = 0; i < cashItemCount; i++) {
            playerIDList.add(Integer.toString((new Random().nextInt(10000) + 1)));
//	            playerIDList.add(sc.next());
        }

        Set<String> playerIDSet = new HashSet<String>(playerIDList);
        System.out.println("IDSet: " + playerIDSet.size());
        System.out.println("N - IDSet = " + (cashItemCount - playerIDSet.size()));
        List<String> frequencyIDList = new ArrayList<>();
        List<Integer> frequencyValue = new ArrayList<>();
        for (String id : playerIDSet) {
            frequencyIDList.add(id);
            frequencyValue.add(Collections.frequency(playerIDList, id));
//	            System.out.println("ID: " + id + " Frequency: " + Collections.frequency(playerIDList, id));
        }
        List<Integer> maxValList = new ArrayList<>();
        int cycleCount = 0;
        int maxValue = Collections.max(frequencyValue);
        List<Integer> freValCount = new ArrayList<>();
        List<List<Integer>> freIDVal = new ArrayList<>();
        List<Integer> dum = new ArrayList<>();

        for (int i = 1; i < maxValue + 1 ; i++) {
            freValCount.add(i);
        }
        for (int j = 0; j < freValCount.size() ; j++) {
            dum.clear();
            for (int i = 0; i < frequencyIDList.size(); i++) {
                if(frequencyValue.get(i) == freValCount.get(j)) {
                    dum.add(Integer.parseInt(frequencyIDList.get(i)));
                }
            }
            freIDVal.add(dum);
            System.out.println("Value: "+ freValCount.get(j) + " ID Count = " + dum.size());
        }

        for (int i = 0; i < frequencyIDList.size(); i++) {
            if(frequencyValue.get(i) == Collections.max(frequencyValue)) {
                maxValList.add(Integer.parseInt(frequencyIDList.get(i)));
                cycleCount++;
        		System.out.println("max ID[" + (cycleCount) + "]: " + frequencyIDList.get(i));
        		System.out.println("max Value: " + frequencyValue.get(i));
            }
        }
        Collections.sort(maxValList);
        for (int i = 0; i < maxValList.size(); i++) {
            if(i == (maxValList.size() - 1)) {
                System.out.print(maxValList.get(i));
            } else {
                System.out.print(maxValList.get(i) + " ");
            }
        }
    }
}
