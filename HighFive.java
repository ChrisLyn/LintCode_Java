/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class HighFive {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, Double> map = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> hash = new HashMap<>();
        for (Record record : results) {
            if (!hash.containsKey(record.id)) {
                hash.put(record.id, new PriorityQueue<Integer>());
            }
            PriorityQueue<Integer> pq = hash.get(record.id);
            if (pq.size() < 5) {
                pq.add(record.score);
            } else {
                if (pq.peek() < record.score) {
                    pq.poll();
                    pq.add(record.score);
                }
            }
        }
        
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : hash.entrySet()) {
            Iterator<Integer> it = entry.getValue().iterator();
            double base = 0;
            while (it.hasNext()) {
                base += it.next();
            }
            map.put(entry.getKey(), base / 5);
        }
        return map;
    }
}