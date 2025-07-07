import java.util.ArrayList;

public class Basics{

    static class Student implements Comparable<Student>{
        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }

    static class Heap{
        ArrayList<Integer> al = new ArrayList<>();

        public void add(int data){
            al.add(data);

            int x = al.size()-1;
            int parent = (x-1)/2;

            while(al.get(x) < al.get(parent)){
                int temp = al.get(x);
                al.set(x, al.get(parent));
                al.set(parent, temp);

                x =parent;
                parent  = (x-1)/2;
            }
        }

        public int peek(){
            return al.get(0);
        }

        public void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;

            if(left< al.size() && al.get(left) < al.get(minIdx)){
                minIdx = left;
            }

            if(right< al.size() && al.get(right) < al.get(minIdx)){
                minIdx = right;
            }

            if(i!= minIdx){
                int temp = al.get(i);
                al.set(i, al.get(minIdx));
                al.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove(){
            int data = al.get(0);

            //swap first and last
            int temp  = al.get(0);
            al.set(0, al.get(al.size()-1));
            al.set(al.size()-1, temp);

            //delete last
            al.remove(al.size()-1);

            //heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty(){
            return al.size()==0;
        }
    }
    public static void main(String[] args) {
        // PriorityQueue<Student> pq = new PriorityQueue<>();
        // // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // pq.add(new Student("A", 2)); //O(log n)
        // pq.add(new Student("B", 1));
        // pq.add(new Student("C", 4));
        // pq.add(new Student("D", 7)); 
      

        // while(!pq.isEmpty()){
        //     System.out.println(pq.peek().name+"->"+" "+pq.peek().rank);  //O(1)
        //     pq.remove();  //O(log n)
        // }

        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }
    }
}